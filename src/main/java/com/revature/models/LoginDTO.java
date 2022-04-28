package com.revature.models;

public class LoginDTO {

	//Our loginDTO models only the username/password sent by the user
		private String username;
		private String password;
		
		
		//we made no args and all arg constructors to instantiate DTO objects
		public LoginDTO() {
			super();
			// TODO Auto-generated constructor stub
		}


		public LoginDTO(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}

		//we need getters and setters to access our fields (encapsulation)
		

		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		
		//This allows us to print out this class
		@Override
		public String toString() {
			return "LoginDTO [username=" + username + ", password=" + password + "]";
		}
		
		
		
	
}
