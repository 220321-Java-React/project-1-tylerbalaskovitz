package com.revature.models;

public class LoginDTO {

	//Our loginDTO models only the username/password sent by the user
		private String username;
		private String password;
		private int user_role_id;
		
		
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


		
		public int getUser_role_id() {
			return user_role_id;
		}


		public void setUser_role_id(int user_role_id) {
			this.user_role_id = user_role_id;
		}


		public LoginDTO(String username, String password, int user_role_id) {
			super();
			this.username = username;
			this.password = password;
			this.user_role_id = user_role_id;
		}


		@Override
		public String toString() {
			return "LoginDTO [username=" + username + ", password=" + password + ", user_role_id=" + user_role_id + "]";
		}
		
		
		
	
}
