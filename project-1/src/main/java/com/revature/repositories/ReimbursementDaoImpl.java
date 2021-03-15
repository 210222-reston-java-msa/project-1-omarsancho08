package com.revature.repositories;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.models.Employee;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao{

	private static Logger log = Logger.getLogger(EmployeeDAOImpl.class);

	public boolean insert(Reimbursement re) {

		PreparedStatement stmt = null;

		try {

			Connection conn = ConnectionUtil.getConnection();
			String sql = "insert into reimbursement (amount, submit_date,resolved_date,description,author,resolver, status_id, type_id)"
					+ " VALUES (?, ?, ?, ?,?,?,?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, re.getAmount());
			stmt.setString(2, re.getDate_submit());
			stmt.setString(3, re.getDate_resolved());
			stmt.setString(4, re.getDesc());
			stmt.setInt(5, re.getAuthor());
			stmt.setInt(6, re.getResolver());
			stmt.setInt(7, re.getStatusId());
			stmt.setInt(8, re.getTypeId());

			if (!stmt.execute()) {
				return false;
			}

		} catch (SQLException ex) {
			log.warn("Unable to insert user", ex);
			return false;
		}
		// If everything is successful, we return true
		return true;
	}

	
	@Override
	public boolean update(Reimbursement re) {
		Connection conn = ConnectionUtil.getConnection();
		String SQL_UPDATE = "UPDATE reimbursement SET resolved_date=?,resolver=?,status_id=? WHERE id=?";

		try (PreparedStatement preparedStatement = conn.prepareStatement(SQL_UPDATE)) {

			preparedStatement.setString(1, re.getDate_resolved());
			preparedStatement.setInt(2,re.getResolver());
			preparedStatement.setInt(3, re.getStatusId());
			preparedStatement.setInt(4, re.getId());

			int row = preparedStatement.executeUpdate();

			// rows affected
			System.out.println(row);

		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}
	
	


	@Override
	public List<Reimbursement> findAllReimb() {
		List<Reimbursement> list = new ArrayList<Reimbursement>();

		try {
			
			Connection conn = ConnectionUtil.getConnection();
			
			String sql = "select reimbursement.id, reimbursement.amount, reimbursement.submit_date, reimbursement.resolved_date, \r\n"
					+ "reimbursement.description, reimbursement.author, reimbursement.resolver, reimbursement.status_id, reimbursement.type_id, employee.username \r\n"
					+ "from employee,reimbursement where employee.id=reimbursement.author";
			
			PreparedStatement stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int id= rs.getInt("id");
				int amount = rs.getInt("amount");
				String date_submit = rs.getString("submit_date");
				String date_resolved = rs.getString("resolved_date");
				String desc = rs.getString("description");
				int author = rs.getInt("author");
				int resolver = rs.getInt("resolver");
				int statusId = rs.getInt("status_id");
				int typeId = rs.getInt("type_id");
				String username=rs.getString("username");
				
				Reimbursement e = new Reimbursement(id,amount, date_submit, date_resolved, desc,author,resolver,statusId,typeId,username);
				list.add(e);
			}

		} catch (SQLException ex) {
			log.warn("Unable to retrieve all users", ex);

		}

		return list;
	}


	@Override
	public Reimbursement findByUsername(int id) {
		Reimbursement ua = new Reimbursement();
		Employee u = new Employee();

		Connection conn = ConnectionUtil.getConnection();
		String sql = "select id,amount, submit_date,resolved_date,description,author,resolver, status_id, type_id from reimbursement where author ='"+id+"'";

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				ua.setId(rs.getInt("id"));
				ua.setAmount(rs.getInt("amount"));
				ua.setDate_submit(rs.getString("submit_date"));
				ua.setDate_resolved(rs.getString("resolved_date"));
				ua.setDesc(rs.getString("description"));
				ua.setAuthor(rs.getInt("author"));
				ua.setResolver(rs.getInt("type_id"));
				ua.setStatusId(rs.getInt("status_id"));
				ua.setTypeId(rs.getInt("type_id"));

			}

		} catch (SQLException e) {

			e.printStackTrace();
			// if something goes wrong, return null
			return null;
		}

		return ua;

	}

	
}
