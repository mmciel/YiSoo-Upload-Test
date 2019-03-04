package com.mmciel.Servlet;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mmciel.Tools.FileSolve;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		boolean isMult = ServletFileUpload.isMultipartContent(request);
		if(isMult) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				//控制大小
				upload.setSizeMax(1024*1024*30);
				factory.setSizeThreshold(10240);
				String tempPath = request.getSession().getServletContext().getRealPath("tempuploadfile");
				File tempdir = new File(tempPath);
				if (!tempdir.exists()) {
					tempdir.mkdirs();
				}
				factory.setRepository(tempdir);//设置临时位置
				@SuppressWarnings("unchecked")
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				String projectKey=null;
				String userKey=null;
				FileItem fileItem=null;

				while(iter.hasNext()) {
					FileItem item = iter.next();
					
					if (item.isFormField()) {
						
					
						if(item.getFieldName().equals("projectkey")) {
							projectKey = new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
							//System.out.println(projectKey);
						}else if (item.getFieldName().equals("userkey")) {
							userKey = new String(item.getString().getBytes("ISO-8859-1"), "UTF-8");
							//System.out.println(userKey);
						}else {
						}
					}else {
						fileItem = item;
					}
				}

				String path = request.getSession().getServletContext().getRealPath("uploadfile/");
				String oldFileName = fileItem.getName();
				String saveFilePath = FileSolve.saveFile(projectKey, userKey, path, oldFileName);
				if(!saveFilePath.isEmpty()){
					fileItem.write(new File(saveFilePath));
					request.setAttribute("message", "上传成功");
				}else{
					request.setAttribute("message", "未知问题，上传失败");
				}
			}catch (FileUploadBase.FileSizeLimitExceededException e) {
	            
	            request.setAttribute("message", "文件过大");
	            request.getRequestDispatcher("/message.jsp").forward(request, response);
	            e.printStackTrace();
	            return;
	        }catch (FileUploadBase.SizeLimitExceededException e) {
	            e.printStackTrace();
	            request.setAttribute("message", "文件过大");
	            request.getRequestDispatcher("/message.jsp").forward(request, response);
	            return;
	        }catch (Exception e) {
	        	request.setAttribute("message", "未知问题，上传失败");
	        	request.getRequestDispatcher("/message.jsp").forward(request, response);
	            e.printStackTrace();
	            return;
	        }
		}else {
			request.setAttribute("message", "文件异常");
		}
		request.getRequestDispatcher("/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
