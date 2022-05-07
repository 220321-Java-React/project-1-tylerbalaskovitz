package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.ErsReimbursement;
import com.revature.utils.ConnectionUtil;

public class SubmitTicketDAO {
	
	
	public void submitTicket (ErsReimbursement submitTicket) {
		//adding the try block to create a connection using the ConnectionUtil class we created in the .utils packaage
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			//this SQL statement uses the INSERT and INTO to put data into the SQL database so
			//that we can add new information into the DBeaver Database.
			
			String sql = "insert into ers_reimbursement (reimb_ammount, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status, reimb_type_id)"
					+ "values (?, ?, 1, 1, 1, 1, 1); ";
					
			
			//this prepared statement is used to will in the variables in the SQL string above.
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, submitTicket.getReimb_amount());
			ps.setString(2, submitTicket.getReimb_description());
			
			
			
			ps.executeUpdate();
			
		
			// Maybe the above will work
			
			System.out.println("Congratulations, your ticket was submitted");
			
		} catch (SQLException e) {
			System.out.println("Something went awfully wrong");
			e.printStackTrace();
		}
		
		
	}
}
