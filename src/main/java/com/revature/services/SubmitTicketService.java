package com.revature.services;

import com.revature.daos.SubmitTicketDAO;
import com.revature.models.ErsReimbursement;

public class SubmitTicketService {
	
	SubmitTicketDAO std = new SubmitTicketDAO();
	
	public Object submitTicket (ErsReimbursement description) {
		
	

	Object submitTicket(String reimb_description, int reimb_amount) {
		ErsReimbursement ersTicket = std.submitTicket( reimb_description, reimb_amount);
		return ersTicket;
		
	}

}

}