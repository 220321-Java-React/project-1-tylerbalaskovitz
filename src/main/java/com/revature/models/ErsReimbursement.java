package com.revature.models;

public class ErsReimbursement {

	private int reimb_id;
	private int reimb_submitted;
	private int reimb_resolved;
	
	private String reimb_description;
	private int reimb_receipt;
	private int reimb_author; 
	private int reimb_resolver; 
	private int reimb_status_id; 
	private int reimb_type_id;
	public ErsReimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErsReimbursement(int reimb_id, int reimb_submitted, int reimb_resolved, String reimb_description,
			int reimb_receipt, int reimb_author, int reimb_resolver, int reimb_status_id, int reimb_type_id) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt = reimb_receipt;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}
	@Override
	public String toString() {
		return "ErsReimbursement [reimb_id=" + reimb_id + ", reimb_submitted=" + reimb_submitted + ", reimb_resolved="
				+ reimb_resolved + ", reimb_description=" + reimb_description + ", reimb_receipt=" + reimb_receipt
				+ ", reimb_author=" + reimb_author + ", reimb_resolver=" + reimb_resolver + ", reimb_status_id="
				+ reimb_status_id + ", reimb_type_id=" + reimb_type_id + "]";
	}
	public int getReimb_id() {
		return reimb_id;
	}
	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}
	public int getReimb_submitted() {
		return reimb_submitted;
	}
	public void setReimb_submitted(int reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}
	public int getReimb_resolved() {
		return reimb_resolved;
	}
	public void setReimb_resolved(int reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}
	public String getReimb_description() {
		return reimb_description;
	}
	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}
	public int getReimb_receipt() {
		return reimb_receipt;
	}
	public void setReimb_receipt(int reimb_receipt) {
		this.reimb_receipt = reimb_receipt;
	}
	public int getReimb_author() {
		return reimb_author;
	}
	public void setReimb_author(int reimb_author) {
		this.reimb_author = reimb_author;
	}
	public int getReimb_resolver() {
		return reimb_resolver;
	}
	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}
	public int getReimb_status_id() {
		return reimb_status_id;
	}
	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}
	public int getReimb_type_id() {
		return reimb_type_id;
	}
	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}
	
	
	
}
