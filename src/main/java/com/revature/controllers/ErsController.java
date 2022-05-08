package com.revature.controllers;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.javalin.http.Handler;


import com.google.gson.Gson;
import com.revature.models.ErsReimbursement;
import com.revature.services.ErsService;

public class ErsController {

	Logger log = LogManager.getLogger(ErsController.class);
	
	//we need an EmployeeService object
		ErsService es = new ErsService();
		
		
		//this handler will get the HTTP get request for all employees, and send back the
		//employees from the database.
		//ALl the handlers for the requests occurs at the Controller layer.
		public Handler getERSReimbursements = (ctx) -> {
			
			if(ctx.req.getSession(true) != null) {
				
				log.info("The ERS Reimbursements Handler was a success" + ctx);	
			
			
			
			//we need an ArrayList of Employee objects. (This is grabbed from the service layer)
			ArrayList<ErsReimbursement> ErsReimbursement = es.getEmployees();
			
			
			
			//we need a GSON object to convert our Java object into JSON
			//(since we can only transfer JSON, not Java)
			Gson gson = new Gson();
			
			log.info("The GSON inside of ERS Reimbursements Handler was a success" + gson);
			
			
			//use the JSON .toJSON() method to turn our Java into JSON
			String JSONEmployees = gson.toJson(ErsReimbursement);
			
			//Give a response containg our JSON string back to the webpage (or wherever the HTTP request
			//came from.
			ctx.result(JSONEmployees); // .result() sends a response of data back
			ctx.status(200); //.status() sets the HTTP status code. 200 stands for "Ok"
			} else {
				ctx.status(401);
				log.warn("There was a failure within the ERS Reimbursement Handler");
			}
			
		};
	
}
