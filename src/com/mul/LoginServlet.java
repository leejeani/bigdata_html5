package com.mul;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = 
			request.getParameter("id");
		String pwd = 
			request.getParameter("pwd");
		if(id.equals("qqq") && pwd.equals("111")){
			response.sendRedirect("map.html");
		}else {
			response.sendRedirect("login.html");
		}
	}

}




