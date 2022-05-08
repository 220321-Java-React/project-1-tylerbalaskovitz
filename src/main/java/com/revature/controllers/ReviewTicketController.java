package com.revature.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.models.ErsReimbursement;
import com.revature.services.ReviewTicketService;


import io.javalin.http.Handler;

public class ReviewTicketController {

	Logger log = LogManager.getLogger(ReviewTicketController.class);
	ReviewTicketService rts = new ReviewTicketService();
	
	public Handler ReviewTicketHandler = (ctx) -> {
			
			
			//with POST requests, we have data coming in, which we access with ctx.body();
			//the body means the BODY of the request-- ie the data the user sent.
			String body = ctx.body();
			log.info("The string body of the ReviewTicketHandler has been created " + ctx.body());
			//create a new GSON object to make Java <-> JSON conversions.
			Gson gson = new Gson();
			
			
			//turn that JSON string directly into a ERSReimbursement object
			//the method fromJSON() is the method that takes JSON and turns it into a Java Object.
			ErsReimbursement RTDTO = gson.fromJson(body, ErsReimbursement.class);
			
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
				log.info("The Ticket Review was a success " + ctx.status(202));
				rts.reviewTicket(RTDTO);
};

}
