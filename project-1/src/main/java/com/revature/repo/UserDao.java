package com.revature.repo;

import java.util.List;

import com.revature.models.Users;

public interface UserDao {
	

	public int insert(Users u); //insert users into project1 DB
	public int update(Users u);
	public List<Users> findAll(); //returns all the users from user table
}
