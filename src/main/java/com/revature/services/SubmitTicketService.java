package com.revature.services;

import com.revature.daos.SubmitTicketDAO;
import com.revature.models.ErsReimbursement;

public class SubmitTicketService {
	
	SubmitTicketDAO std = new SubmitTicketDAO();
	
	public Object submitTicket (ErsReimbursement description) {
		
		ErsReimbursement ersTicket = std.submitTicket(description);
		return ersTicket;
	}

}
