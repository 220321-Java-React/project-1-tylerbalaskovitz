package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.ErsReimbursement;
import com.revature.utils.ConnectionUtil;

public class ReviewTicketDAO {

	public void reviewTicket (ErsReimbursement reviewTicket) {
		//adding the try block to create a connection using the ConnectionUtil class we created in the .utils packaage
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			//this SQL statement uses the INSERT and INTO to put data into the SQL database so
			//that we can add new information into the DBeaver Database.
			
			String sql = "UPDATE ers_reimbursement SET reimb_status_id = '?' WHERE reimb_id ='?';"
					+ "values (?, ?);";
					
			
			
			
			
			//this prepared statement is used to will in the variables in the SQL string above.
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setInt(1, reviewTicket.getReimb_status_id());
			ps.setInt(2, reviewTicket.getReimb_id());
			
			
			
			ps.executeUpdate();
			
		
			// Maybe the above will work
			
			System.out.println("Congratulations, your ticket was updated");
			
		} catch (SQLException e) {
			System.out.println("Something went awfully wrong");
			e.printStackTrace();
		}
		
		
	}
	
	
}
