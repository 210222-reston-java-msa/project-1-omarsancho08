package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Users;
import com.revature.services.EmployeeServices;
import com.revature.util.RequestHelper;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
public static void processLogin(HttpServletRequest req, HttpServletResponse res) throws IOException { 
		
		// We want to turn whatever we recieve as the request into a string to process
		BufferedReader reader = req.getReader();
		StringBuilder s = new StringBuilder();
		
		// logic to transfer everything from our reader to our string builder
		String line = reader.readLine();
		while (line != null) {
			s.append(line);
			line = reader.readLine();
		}
		
		String body = s.toString();
		log.info(body);
		
		
		// I'm going to build a model called LoginTemplate which holds a username and passwrod
		Users loginAttempt = om.readValue(body, Users.class); // from JSON --> Java Object

		
		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();	
		
		log.info("User attempted to login with username: " + username);
		Users e = EmployeeServices.confirmLogin(username, password);
			
		if (e != null) {
			// get the current session OR create one if it doesn't exist
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			
			// Attaching the print writer to our response
			PrintWriter pw = res.getWriter();
			res.setContentType("application/json");
			
			// this is converting our Java Object (with property firstName!) 
			// to JSON format....that means we can grab the firstName property
			// after we parse it. (We parse it in JavaScript)
			pw.println(om.writeValueAsString(e));

			
			log.info(username + " has successfully logged in");	
		} else {
			res.setStatus(204); // this means that we still have a connection, but no user is found
		}
		
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
