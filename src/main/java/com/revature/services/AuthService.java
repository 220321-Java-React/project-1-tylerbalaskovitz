package com.revature.services;

import com.google.gson.JsonElement;
import com.revature.daos.LoginDAO;
import com.revature.models.Employee;
import com.revature.models.Login;
import com.revature.models.LoginDTO;
import com.revature.models.Role;

//You'll need to get this employee data from the DAO and DB
public class AuthService {


	
	//accessing the Login Dao
	
	LoginDAO ld = new LoginDAO();
	
	
/*
	public Object login(String username, String password) {
		//did just have the following
		
		 * 
		 * boolean erslogin = ld.login(username, password);
		
		return erslogin;
		 * 
		 * 
		 
		
	}
	
*/


	public Object login(String username, String password, int user_role_id) {
		Login erslogin = ld.login(username, password, user_role_id);
			
		return erslogin;
	}

	
		
	

	

	
	
	
	
	
	//typically, you'll want to validate username/password here in the service
	//by calling some DAO method that gets employees where username = ? and password = ?
	
	/*
	//hard coded login
	public Employee login(String username, String password) {
		if (username.equals("user") && password.equals("password")) {
			
			
			Role role = new Role();
			
			
			return new Employee(10, "Sandy", "Cheeks", role);
						
		} else {
			return null;
		}
		*/
		
		
	}

	
	
	