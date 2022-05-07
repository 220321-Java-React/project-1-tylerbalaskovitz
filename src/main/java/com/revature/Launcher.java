package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.LoginController;
import com.revature.controllers.ErsController;

import com.revature.controllers.SubmitTicketController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

    public static void main(String[] args) {
    	

		//In this try/catch, we're just testing whether our Connection (from the ConnectionUtil Class) is successful
		//remember - the getConnection() method will return a Connection Object if you connect successfully
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("CONNECTION SUCCESSFUL :)");
		} catch (SQLException e) { //if creating this connection fails... catch the exception and print the stack trace
			System.out.println("connection failed... :(");
			e.printStackTrace();
		}
		
		// we now have a webpage that needs to send an HTTP request to our Java Server!
		// we no longer have a menu that works on the CLI. We jus JAVALIN
		
		//Javalin is a technology we use to take in HTTP requests (from our front end)
		// and sends back HTTP requests
		//HTTP Responses can be anything from data that was requested, to just a status code
		//that says data was received
		
		
		//Making Controller and classes that need to be created for the different buttons in the front end
		//these are all used for the employee's HTML page in the front end.
		
	
		
		SubmitTicketController stc = new SubmitTicketController();
		
		
		//These controllers are used for the 
		
		
		
		
		
		
		
		//Instantiating an EmployeeController object so that we can access its Handlers
		ErsController ec = new ErsController();
		
		//Instantiating an AUthController object so we can access its handlers.
		LoginController ac = new LoginController();
		
		
		//Typical Javalin syntax to create a Javalin object
		Javalin app = Javalin.create(
				
				//the config lambda lets us specify certain configurations.
				config -> {
					config.enableCorsForAllOrigins(); 
					//this allows us to process JavaScript requests from anywhere.
				}
			).start(3000);
		
		//We need to make some endpoint handlers, which will take in requests and send them where
		//they need to go. Javalin endpoint handlers are like the traffic cop to your server. They take traffic
		//and direct it.
		
		//handler ending in /employee that takes in get requests, and will return all employees
		//the app.get() emthod takes in a URL endpoint and a place in the server to send the request to
		app.get("/getReimbursements", ec.getERSReimbursements);
		
		
		//this handler ends in /login for taking in POST requests
		//this will validate the user's logins
		// the app.post() method will take in a URL endpoint ad a place in the server
		//to send the request to 
		app.post("/login", ac.loginHandler);
		
		app.post("/submit", stc.SubmitTicketHandler);
		
		//app.put this is for updating tickets.
	}
	
    	
    }

