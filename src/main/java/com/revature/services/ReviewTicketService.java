package com.revature.services;

import com.revature.daos.ReviewTicketDAO;
import com.revature.models.ErsReimbursement;

public class ReviewTicketService {

	ReviewTicketDAO rtd = new ReviewTicketDAO();
	
	public void reviewTicket(ErsReimbursement RTDTO) {
		rtd.reviewTicket(RTDTO);
		
	}

}
