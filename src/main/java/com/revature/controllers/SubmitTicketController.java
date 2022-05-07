package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.ErsReimbursement;
import com.revature.models.LoginDTO;
import com.revature.services.SubmitTicketService;

import io.javalin.http.Handler;

public class SubmitTicketController {

	SubmitTicketService sts = new SubmitTicketService();
	
public Handler SubmitTicketHandler = (ctx) -> {
		
		
		//with POST requests, we have data coming in, which we access with ctx.body();
		//the body means the BODY of the request-- ie the data the user sent.
		String body = ctx.body();
		
		//create a new GSON object to make Java <-> JSON conversions.
		Gson gson = new Gson();
		
		
		//turn that JSON string directly into a ERSReimbursement object
		//the method fromJSON() is the method that takes JSON and turns it into a Java Object.
		ErsReimbursement ERDTO = gson.fromJson(body, ErsReimbursement.class);
		
		//the control flow should have the two variables in the paramaters that I'm going to submit, more can be added
		//when I'm trying to do sessions 
		
		//control flow to determine what happens in the event of successful/unsuccessful login
		/*
		if(sts.submitTicket(ERDTO.getReimb_description(), ERDTO.getReimb_amount()) != null) {
			
			//if login is successful, create a user session so they can access the application's
			// functionalities.
			*/
			
			//return a successful login code
			ctx.status(202);
			
			sts.submitTicket(ERDTO);
			
		
		
		
		
		
		
	};
	
	
	
}
