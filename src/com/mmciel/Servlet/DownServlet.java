package com.mmciel.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;

import com.mmciel.Data.Project;
import com.mmciel.Tools.FileSolve;

/**
 * Servlet implementation class DownServlet
 */
@WebServlet("/DownServlet")
public class DownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownServlet() {
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
        String projectName = request.getParameter("downkey");
		//System.out.println(projectName);
        String path = request.getSession().getServletContext().getRealPath("uploadfile/")+projectName;
        Map<String,String> fileNameMap = new TreeMap<String,String>();
        FileSolve.getListFile(new File(path),fileNameMap);

        request.setAttribute("fileNameMap", fileNameMap);
        request.setAttribute("projectName", projectName);
//        for (String i : fileNameMap.keySet()) {
//			System.out.println(fileNameMap.get(i));
//		}
        Project.projectName = projectName;
        //request.getRequestDispatcher("/downfile.jsp").forward(request, response);
        request.getRequestDispatcher("down.jsp").forward(request, response);
        //response.sendRedirect(request.getContextPath()+"/down.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
