package com.mmciel.Servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmciel.Data.Project;
import com.mmciel.Tools.FileSolve;

/**
 * Servlet implementation class TheDownServlet
 */
@WebServlet("/TheDownServlet")
public class TheDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TheDownServlet() {
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
		//得到要下载的文件名
        String fileName = request.getParameter("filename");
//        System.out.println(fileName);
        String projectName = Project.projectName;
		String tempPath = request.getSession().getServletContext().getRealPath("/uploadfile"+"/"+projectName);
		//System.out.println(projectName);
        String path = tempPath+"\\"+fileName;
        //得到要下载的文件
        File file = new File(path);
        //如果文件不存在
        if(!file.exists()){
            request.setAttribute("message", "资源不存在");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
 
        FileInputStream fis = new FileInputStream(path);
        String userAgent = request.getHeader("User-Agent");  
        byte[] bytes = userAgent.contains("MSIE") ? fileName.getBytes() : fileName.getBytes("UTF-8"); // name.getBytes("UTF-8")处理safari的乱码问题  
        String name = new String(bytes, "ISO-8859-1"); 
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", name));        ServletOutputStream out = response.getOutputStream();
        byte[] bt = new byte[1024];
        int length = 0;
        while((length=fis.read(bt))!=-1){
            out.write(bt,0,length);
        }
        out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
