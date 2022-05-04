package com.revature.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Login;
import com.revature.utils.ConnectionUtil;

public class LoginDAO {

	//two catch blues within the statement. One is to try connecting to the DB and the other to try
	//the the passwords matching each other.
	public boolean login (String username, String password) {
	try (Connection conn = ConnectionUtil.getConnection()){
		String sql = "select * from ers_users WHERE username = ?;";
				
				String passwordtest = "";
		
				//A prepared statement for connecting to the database in the username column
				PreparedStatement ps = conn.prepareStatement(sql);
				
				//this is checking for the first value 1, in the Database, username
				ps.setString(1, username);
				
				//the result set is imported and is from executing the query listed above in
				//the prepared statement.
				ResultSet rs = ps.executeQuery();
				
				//This ArrayList is created to hold the Login information from accessing
				//the username column in the login_table table
				ArrayList<Login> userLoginList = new ArrayList<>();
				
				//while going through the result list, we get the password.
				while (rs.next()) {
				Login login = new Login(rs.getString("pword"));
				userLoginList.add(login);
				}
				//we try the login with the new ArrayList at position 0 since there is only one
				//value that is stored in the ArrayList titled userLoginList. This was done
				//with the method userLoginList.add(login). The login is using the result set rs
				//and the method rs.getString("pword"));
				try {
					Login testLogin = userLoginList.get(0);
					passwordtest = testLogin.getPword();
				} catch (IndexOutOfBoundsException e){
					System.out.println("Username doesn't exist");
						
				//the below uses the passwordtest to see if it's equal to the parameter's
				//password. If it does, then the login is successful. The system returns true
				//Which activites the Login menu allowing for the Login Menu to close
				//and everything is hunky dorey.
				} 
				if (password.equals(passwordtest)) {
					System.out.println("Log in was successful");
					// Menu menu = new Menu();
					
				//	menu.displayMenu();
					
					return true;
					
				} else {
					
					return false;
				}
			
	}catch (SQLException e ) {
		System.out.println("Please try logging in again");
		e.printStackTrace();
	}
	return false;
	

	} 
	
	
	
}