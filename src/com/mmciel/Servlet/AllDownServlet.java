package com.mmciel.Servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmciel.Tools.FileSolve;

/**
 * Servlet implementation class AllDownServlet
 */
@WebServlet("/AllDownServlet")
public class AllDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllDownServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String downProject = request.getParameter("alldownkey");
		String path = request.getSession().getServletContext().getRealPath("uploadfile/");
		//System.out.println(path);
		String fileName = FileSolve.ZipProject(path,downProject);
        FileInputStream fis = new FileInputStream(path+fileName);
        response.setCharacterEncoding("utf-8");
        String userAgent = request.getHeader("User-Agent");  
        byte[] bytes = userAgent.contains("MSIE") ? fileName.getBytes() : fileName.getBytes("UTF-8"); // name.getBytes("UTF-8")处理safari的乱码问题  
        String name = new String(bytes, "ISO-8859-1"); 
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", name));
        ServletOutputStream out = response.getOutputStream();
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
