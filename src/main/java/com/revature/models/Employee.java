package com.revature.models;

public class Employee {

	//variables for the employee class - must match the employees table in the database
		//note the private variables, private coupled with getters and setters (see below) are how we achieve ENCAPSULATION
		private int user_role_id;
		private String first_name;
		private String last_name;
		//Every Employee in this application will have a role associated with it
		
		
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Employee(int user_role_id, String first_name, String last_name) {
			super();
			this.user_role_id = user_role_id;
			this.first_name = first_name;
			this.last_name = last_name;
		}
		public int getUser_role_id() {
			return user_role_id;
		}
		public void setUser_role_id(int user_role_id) {
			this.user_role_id = user_role_id;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		; //in other words, every EMPLOYEE has a ROLE

		
		//this class won't have any methods, we just need it to represent (aka MODEL) some data
		
		//boilerplate code below------------------------------
		//boilerplate code is any code that you'll probably write over and over again
		//most classes that we make objects of will have constructors, getters/setters, toString
		//so java makes this easy for us with the source tab 
		
		//remember all of this can be generated with the source tab
		
		
		
		
		
		
		
}
