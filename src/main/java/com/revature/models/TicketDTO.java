package com.revature.models;

public class TicketDTO {

	private String description; 
	private int amount;
	
	public TicketDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TicketDTO(String description, int amount) {
		super();
		this.description = description;
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TicketDTO [description=" + description + ", amount=" + amount + "]";
	}
	
	
	
	
	
	
}
