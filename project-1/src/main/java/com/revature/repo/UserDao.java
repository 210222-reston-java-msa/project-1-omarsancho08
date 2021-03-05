package com.revature.repo;

import java.util.List;

import com.revature.models.Users;

public interface UserDao {

	public boolean insert(Users u); //insert users into project1 DB
	public boolean update(Users u); //update 
	
	public List<Users> findAll(Users u); //returns all the users from user table
}
