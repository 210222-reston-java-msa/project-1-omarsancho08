package com.revature.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.models.Employee;
import com.revature.models.LoginTemplate;
import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDao;
import com.revature.repositories.ReimbursementDaoImpl;
import com.revature.services.EmployeeService;

public class RequestHelper {

	private static Logger log = Logger.getLogger(RequestHelper.class);
	private static ObjectMapper om = new ObjectMapper();

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

		// I'm going to build a model called LoginTemplate which holds a username and
		// passwrod
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class); // from JSON --> Java Object

		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();

		log.info("User attempted to login with username: " + username);
		Employee e = EmployeeService.confirmLogin(username, password);

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

	public static void processManageLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {

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

		// I'm going to build a model called LoginTemplate which holds a username and
		// passwrod
		LoginTemplate loginAttempt = om.readValue(body, LoginTemplate.class); // from JSON --> Java Object

		String username = loginAttempt.getUsername();
		String password = loginAttempt.getPassword();

		log.info("User attempted to login with username: " + username);
		Employee e = EmployeeService.confirmManagerLogin(username, password);

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

	public static void processLogout(HttpServletRequest req, HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession(false); // I'm capturing the session, but if there ISN'T one, I don't
														// create a new one.

		log.info("Processing logout");

		if (session != null) {

			String username = (String) session.getAttribute("username");
			log.info(username + " has logged out");

			session.invalidate();
		}

		res.setStatus(200);

	}

	// This method's purpose is to return all Employees from the DB in JSON form
	public static void processEmployees(HttpServletRequest req, HttpServletResponse res) throws IOException {

		res.setContentType("application/json;charset=UTF-8");

		try (PrintWriter out = res.getWriter()) {

			List<Reimbursement> emp = EmployeeService.findAllReimb();

			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

			out.print(gson.toJson(emp));
			log.info("All Reimbursement were requested");
		}

	}
	
	
	// This method's purpose is to return all Employees from the DB in JSON form
		public static void processEmployeesByUsername(HttpServletRequest req, HttpServletResponse res) throws IOException {

			res.setContentType("application/json;charset=UTF-8");

			int author=Integer.parseInt(req.getParameter("authorId"));
			
			Reimbursement rm=new Reimbursement();
			
			rm.setAuthor(author);
			
			
			try (PrintWriter out = res.getWriter()) {

				List<Reimbursement> emp = EmployeeService.findAllReimb();

				
				
				Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

				out.print(gson.toJson(EmployeeService.findRembiById(author)));
				log.info("All Reimbursement were requested");
			}

		}

	// This method's purpose is to return all Employees from the DB in JSON form
	public static void processEmployeeById(HttpServletRequest req, HttpServletResponse res) throws IOException {

		res.setContentType("application/json;charset=UTF-8");

		try (PrintWriter out = res.getWriter()) {

			List<Reimbursement> reimb = EmployeeService.findAllReimb();

			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

			out.print(gson.toJson(reimb));
			log.info("All Reimbursement was requested");
		}

	}
	
	public static void processUsers(HttpServletRequest req, HttpServletResponse res) throws IOException {

		res.setContentType("application/json;charset=UTF-8");

		try (PrintWriter out = res.getWriter()) {

			List<Employee> users = EmployeeService.findAll();

			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

			out.print(gson.toJson(users));
			log.info("All Users was requested");
		}

	}
	
	

	public static void processError(HttpServletRequest req, HttpServletResponse res) throws IOException {

		log.info("Ran into an Error Redirecting");
		try {
			req.getRequestDispatcher("error.html").forward(req, res);
			// we do NOT create a new request
			// we also maintain the url....
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

	public static void processInsert(HttpServletRequest req, HttpServletResponse res) throws IOException {

		res.setContentType("text/html");

		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		int roleId = Integer.parseInt(req.getParameter("role_id"));

		Employee e = new Employee();

		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setUsername(username);
		e.setPassword(password);
		e.setEmail(email);
		e.setRole_id(roleId);

		if (e == null) {
			log.info("Object was Empty");
		} else {
			log.info("Insert Action was done!: " + username);

			EmployeeService.insert(e);
		}

		try {
			req.getRequestDispatcher("/home.html").forward(req, res);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void processInsertReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {

		ReimbursementDao rDao = new ReimbursementDaoImpl();

		res.setContentType("text/html");
		int amount = Integer.parseInt(req.getParameter("amount"));
		String submit_date = req.getParameter("submit_date");
		String date_resolved=req.getParameter("date_resolved");
		String description = req.getParameter("description");
		int author = Integer.parseInt(req.getParameter("author"));
		int resolver=Integer.parseInt(req.getParameter("resolver"));
		int status_id = Integer.parseInt(req.getParameter("status_id"));
		int type_id = Integer.parseInt(req.getParameter("type_id"));

		Reimbursement r = new Reimbursement();

		r.setAmount(amount);
		r.setDate_submit(submit_date);
		r.setDate_resolved(date_resolved);
		r.setDesc(description);
		r.setAuthor(author);
		r.setResolver(resolver);
		r.setStatusId(status_id);
		r.setTypeId(type_id);

		if (r != null) {
			EmployeeService.insert(r);
			log.info("Reimbursement was submitted by: " + r.getUsername());
		} else {
			log.warn(author + " was unable to insert Reimbursement");
		}

		try {
			req.getRequestDispatcher("/home.html").forward(req, res);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void processUpdate(HttpServletRequest req, HttpServletResponse res) throws IOException {

		res.setContentType("text/html");

		int id = Integer.parseInt(req.getParameter("id"));
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
		String email = req.getParameter("email");

		Employee e = new Employee();

		e.setId(id);
		e.setFirstName(first_name);
		e.setLastName(last_name);
		e.setEmail(email);

		try {
			if (e != null) {
				EmployeeService.update(e);
				log.info("Update Action was done by: " + first_name);
			} else {
				log.warn("Unable to update User " + first_name);
			}

			req.getRequestDispatcher("/home.html").forward(req, res);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void processReimbUpdate(HttpServletRequest req, HttpServletResponse res) throws IOException, NumberFormatException {

		res.setContentType("text/html");

		int id = Integer.parseInt(req.getParameter("id"));
		String date_resolved = req.getParameter("date_resolved");
		int resolver = Integer.parseInt(req.getParameter("resolver"));
		int status_id = Integer.parseInt(req.getParameter("status_id"));

		Reimbursement rb = new Reimbursement();
		try {
		rb.setId(id);
		rb.setDate_resolved(date_resolved);
		rb.setResolver(resolver);
		rb.setStatusId(status_id);

		
			if (rb != null) {
				EmployeeService.update(rb);
				log.info("Update Action was done by: "+ resolver);
			} else {
				log.warn("Unable to approve request ");
			}

			req.getRequestDispatcher("/ManageHome.html").forward(req, res);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}