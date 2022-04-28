package com.revature.controllers;

import java.util.logging.Handler;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;

public class AuthController {

	//we need an AuthService object to use its login method.
	AuthService as = new AuthService();
	
	
	//we need a LoginHandler to handle login requests (which come to app.post("/login", handler)
	public Handler loginHandler = (ctx) -> {
		
		
		//with POST requests, we have data coming in, which we access with ctx.body();
		//the body means the BODY of the request-- ie the data the user sent.
		String body = ctx.body();
		
		//create a new GSON object to make Java <-> JSON conversions.
		Gson gson = new Gson();
		
		
		//turn that JSON string directly into a LoginDTO object
		//the method fromJSON() is the method that takes JSON and turns it into a Java Object.
		LoginDTO LDTO = gson.fromJson(body, LoginDTO.class);
		
		//control flow to determine what happens in the event of successful/unsuccessful login
		if(as.login(LDTO.getUsername(), LDTO.getPassword()) != null) {
			
			//if login is successful, create a user session so they can access the application's
			// functionalities.
			ctx.req.getSession();
			
			//return a successful login code
			ctx.status(202);
			
			//send back our Employee object.
			String employeeJSON = gson.toJson(as.login(LDTO.getUsername(), LDTO.getPassword()));
			
			//sends back our Employee JSON object
			ctx.result(employeeJSON);
			
		} else {
			ctx.status(401); //401 stands for "unauthorized"
			System.out.println("Login failed");
		}
		
		
		
		
	};
	
}
