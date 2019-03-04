package com.mmciel.Servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmciel.Tools.FileSolve;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class LookServlet
 */
@WebServlet("/LookServlet")
public class LookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().println("123");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
        String projectName = request.getParameter("projectkey");
		//System.out.println(projectName);
        String path = request.getSession().getServletContext().getRealPath("uploadfile/")+projectName;
        Map<String,String> fileNameMap = new TreeMap<String,String>();
        FileSolve.getListFile(new File(path),fileNameMap);
//        JSONObject json = JSONObject.fromObject(fileNameMap);
//        for(String i:fileNameMap.keySet()) {
//        	//System.out.println(i);
//        	System.out.println(fileNameMap.get(i));
//        }
//        PrintWriter out=response.getWriter();
//        out.println(json);
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/listfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
