package com.revature.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Role;
import com.revature.models.Users;
import com.revature.util.ConnectionUtil;

public class UserDaoImpl implements UserDao {
	
	private static Logger log = Logger.getLogger(UserDaoImpl.class);


	@Override
	public int insert(Users u) {

		try {
			// Step 1. Get a connection using ConnectionUtil
			// import Connection from java.sql
			Connection conn = ConnectionUtil.getConnection();

			// Step 2. Define our SQL statements to perform an action on our DB
			String columns = "username, pass, first_name, last_name, email, role_id";
			String sql = "INSERT INTO users (" + columns + ") VALUES (?, ?, ?, ?, ?, ?)";
			// The ?'s are place-holders for input values
			// They work for PreparedStatements, which are designed to protect us from SQL
			// injection

			// Step 3a: Obtain Statement Object
			// PreparedStatement is a sub interface of Statement that provides extra
			// security to prevent SQL injection.
			PreparedStatement stmt = conn.prepareStatement(sql);

			// Step 3b: Inject values to replace all the ? marks
			// stmt.setInt(1, u.getId());
			stmt.setString(1, u.getUsername()); // replace 1st ? mark with u.getUsername()
			stmt.setString(2, u.getPassword()); // replace 2nd ? mark with u.getPassword()
			stmt.setString(3, u.getFirstName()); // replace 3rd ? mark with u.getFirstName()
			stmt.setString(4, u.getLastName());
			stmt.setString(5, u.getEmail());
			stmt.setInt(6, u.getRole()); // this is returning the int value for the Role id of the Role object

			// Step 4: Execute the statement;
			return stmt.executeUpdate(); // this will return the number of rows inserted (1)

		} catch (SQLException e) {
			// Step 5: Perform any exception handling in an appropriate means
			e.printStackTrace();
		}

		// otherwise we return 0 if we cannot insert a row into the database
		return 0;
	}

	@Override
	public List<Users> findAll() {

		List<Users> list = new ArrayList<Users>();

		try {
			
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "SELECT * FROM users";
			
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String password = rs.getString("pass");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String email=rs.getString("email");
				int roleId=rs.getInt("role_id");
				Users e = new Users(id,username,firstName, lastName, password,email,roleId);
				list.add(e);
			}

		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);

		}

		return list;
	}
	
	
	@Override
	public int update(Users u) {

		Connection conn = ConnectionUtil.getConnection();
		String SQL_UPDATE = "UPDATE users SET first_name=?,last_name=?,email=? WHERE id=?";

		try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {

			preparedStatement.setString(1, u.getFirstName());
			preparedStatement.setString(2, u.getLastName());
			preparedStatement.setString(3, u.getEmail());
			preparedStatement.setInt(4, u.getId());

			int row = preparedStatement.executeUpdate();

			// rows affected
			System.out.println(row);

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}




		 
}
