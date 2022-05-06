package com.revature.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.ErsReimbursement;

import com.revature.utils.ConnectionUtil;

public class ErsDAO {

	public ArrayList<ErsReimbursement> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<ErsReimbursement> displayAllReimbursements() {
		
		try (Connection conn = ConnectionUtil.getConnection()){
			
			//This string sql represents of the SQL Statement
			String sql = "select * from ers_reimbursement;";
				
			
			
			//A statement object is created to execute the query to the database.
			Statement s = conn.createStatement();
			
			//Execute the query into a ResultSet object, which will hold all the data
			ResultSet rs = s.executeQuery(sql);
			
			//This will instantiate an ArrayList to put our Employee objects into
			ArrayList<ErsReimbursement> allReimbursements = new ArrayList<>();
			
			//This while loop is used to create the recordName object to populate the
			//ArrayList with them. The ResultSet (rs) from above is holding our data
			while (rs.next()) {
				
				ErsReimbursement ER = new ErsReimbursement(
						
						rs.getInt("reimb_id"),
						rs.getInt("reimb_ammount"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_receipt"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						
						
						
						);
					allReimbursements.add(ER);	
				//finished the first part of this -- 
			}
			
			return allReimbursements;
			
		} 
		catch (SQLException e) {
				System.out.println("There were problems adding the record information to the database.");
				e.printStackTrace();
				
		}
			
		
		
		
		
		return null;
	}
	
}
