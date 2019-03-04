package com.mmciel.Servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmciel.Bean.ProjectDataList;

/**
 * Servlet implementation class DelServlet
 */
@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String delname = request.getParameter("delkey");
		System.out.println(delname);
		ProjectDataList temp = new ProjectDataList();
		List<String> tempList = temp.getDataList();
		Iterator<String> it = tempList.iterator();
		 
        while (it.hasNext()) {
            String value = it.next();
            if (value.equals(delname)) {
                //System.out.println(value);
                it.remove();
                
            }
        }
		temp.addJsonFile(tempList);
		getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
