package com.revature.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.RequestHelper;

import com.revature.util.RequestHelper;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// we will rewrite the URL's 
		final String URI = request.getRequestURI().replace("/EmployeeDBServlets/", "");
		
		switch(URI) {
		case "login":
			RequestHelper.processLogin(request, response);
			break;
		case "managelogin":
			RequestHelper.processManageLogin(request, response);
			break;
		case "logout":
			RequestHelper.processLogout(request, response);
			break;
		case "employees":
			RequestHelper.processEmployees(request, response);
			break;
		case "findByUsername":
			RequestHelper.processEmployeesByUsername(request, response);
			break;
		case "users":
			RequestHelper.processUsers(request, response);
			break;
		case "insert":
			RequestHelper.processInsert(request, response);
			break;
		case "insertReimb":
			RequestHelper.processInsertReimb(request, response);
			break;
		case "updateUser":
			RequestHelper.processUpdate(request, response);
			break;
		case "approveRequest":
			RequestHelper.processReimbUpdate(request, response);
			break;
		case "error":
			RequestHelper.processError(request, response);
			break;
		} 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
