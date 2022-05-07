package com.revature.services;

import com.revature.daos.SubmitTicketDAO;
import com.revature.models.ErsReimbursement;

public class SubmitTicketService {
	
	SubmitTicketDAO std = new SubmitTicketDAO();
	
	public void submitTicket (ErsReimbursement description) {
		
	
		std.submitTicket(description);
	}

}

