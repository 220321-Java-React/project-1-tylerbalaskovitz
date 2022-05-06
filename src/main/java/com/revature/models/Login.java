package com.revature.models;

public class Login {
	
	
	
	
	private int user_role_id;
	private String username;
	private String pword;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(int user_role_id, String username, String pword) {
		super();
		this.user_role_id = user_role_id;
		this.username = username;
		this.pword = pword;
	}
	@Override
	public String toString() {
		return "Login [user_role_id=" + user_role_id + ", username=" + username + ", pword=" + pword + "]";
	}
	public Login(String username, String pword) {
		super();
		this.username = username;
		this.pword = pword;
	}
	public Login(String string) {
		// TODO Auto-generated constructor stub
	}
	
	public Login(int int1) {
		// TODO Auto-generated constructor stub
	}
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	
	
	
	
	

}
