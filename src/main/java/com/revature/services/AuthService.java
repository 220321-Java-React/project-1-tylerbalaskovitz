package com.revature.services;

import com.revature.models.Employee;
import com.revature.models.Role;

//You'll need to get this employee data from the DAO and DB
public class AuthService {

	//typically, you'll want to validate username/password here in the service
	//by calling some DAO method that gets employees where username = ? and password = ?
	
	//hard coded login
	public Employee login(String username, String password, int user_role_id) {
		if (username.equals("user") && password.equals("password")) {
			
			
			Role role = new Role();
			
			
			return new Employee(10, "Sandy", "Cheeks", role);
						
		} else {
			return null;
		}
		
		
	}
}
	
	
	