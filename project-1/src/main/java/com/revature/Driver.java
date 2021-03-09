package com.revature;

import com.revature.models.Users;
import com.revature.repo.UserDao;
import com.revature.repo.UserDaoImpl;
import com.revature.services.EmployeeServices;
import com.revature.util.ConnectionUtil;

import jdk.internal.org.jline.utils.Log;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		UserDao dao=new UserDaoImpl();
		Users u=new Users("lilwayne","pass","lil","wayne","weezy@yahoo.com",1);
		
		
		
		System.out.println(EmployeeServices.findByUsername("omarsancho"));

	}
}
