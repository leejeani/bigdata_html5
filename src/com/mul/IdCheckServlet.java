package com.mul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/IdCheckServlet", "/idc" })
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. ID�� �޴´�.
		String id = 
		request.getParameter("id");
		// 2. ID�� üũ �Ѵ�.
		String result = "";
		if(id.equals("chmin")) {
			result = "0";
		}else {
			result = "1";
		}
		// 3. ����� �ٽ� ���� �Ѵ�.
		PrintWriter out = 
			response.getWriter();
		out.println(result);
		out.close();
	}

}


