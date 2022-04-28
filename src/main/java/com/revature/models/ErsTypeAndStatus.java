package com.revature.models;

public class ErsTypeAndStatus {

	
	// the variables from the reimburse type table
			private int reimb_type_id;
			private String reimb_type;
			

			//the variables from reimbursement status table.
			private int reimb_status_id; 
			private String reimb_status;
			
			
			public ErsTypeAndStatus() {
				super();
				// TODO Auto-generated constructor stub
			}
			
			
			public ErsTypeAndStatus(int reimb_type_id, String reimb_type, int reimb_status_id, String reimb_status) {
				super();
				this.reimb_type_id = reimb_type_id;
				this.reimb_type = reimb_type;
				this.reimb_status_id = reimb_status_id;
				this.reimb_status = reimb_status;
			}


			@Override
			public String toString() {
				return "ErsTypeAndStatus [reimb_type_id=" + reimb_type_id + ", reimb_type=" + reimb_type
						+ ", reimb_status_id=" + reimb_status_id + ", reimb_status=" + reimb_status + "]";
			}


			public int getReimb_type_id() {
				return reimb_type_id;
			}


			public void setReimb_type_id(int reimb_type_id) {
				this.reimb_type_id = reimb_type_id;
			}


			public String getReimb_type() {
				return reimb_type;
			}


			public void setReimb_type(String reimb_type) {
				this.reimb_type = reimb_type;
			}


			public int getReimb_status_id() {
				return reimb_status_id;
			}


			public void setReimb_status_id(int reimb_status_id) {
				this.reimb_status_id = reimb_status_id;
			}


			public String getReimb_status() {
				return reimb_status;
			}


			public void setReimb_status(String reimb_status) {
				this.reimb_status = reimb_status;
			}
		
			
			
	
}
