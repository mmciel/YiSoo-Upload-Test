package com.mmciel.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mmciel.Data.Admin;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        if(username.equals(Admin.username) && password.equals(Admin.password)) {
        	request.getSession().setAttribute("username", "mmciel");
        	getServletContext().getRequestDispatcher("/main.jsp").forward(request, response);
        	
        }else {
        	response.sendRedirect( request.getContextPath()+"/index.jsp");
        }
		
	}

}
