CREATE TABLE ers_reimbursement(
reimb_id serial PRIMARY KEY, --The serial KEY FOR identifying the cord inserted INTO the table
reimb_ammount int,
reimb_submitted timestamp, 
reimb_resolved timestamp,
reimb_description text,
reimb_receipt int,
reimb_author int REFERENCES ers_users(ers_users_id),
reimb_resolver int REFERENCES  ers_users(ers_users_id),
reimb_status_id int REFERENCES ers_reimbursement_status(reimb_status_id),
reimb_type_id int REFERENCES  ers_reimbursement_type(reimb_type_id)-- these four reference the other TABLES TO be used WITHIN P1
);

INSERT INTO  ers_reimbursement (reimb_ammount,reimb_description, reimb_receipt)
VALUES (235, 'Pizza Party for Johns Birthday', 235),
	   (600, 'Bucket of Cheese for the Cheese Giveaway', 600),
	   (2000, 'Client Banquet', 2000),
	   (5000, 'Client trip to Hawaii for a week', 5000);
	  
	  

DROP TABLE ers_reimbursement 

CREATE TABLE ers_users (
ers_users_id serial PRIMARY KEY, 
ers_username text,
ers_password text,
user_first_name text,
user_last_name text, 
user_email text,
user_role_id int REFERENCES ers_user_roles(ers_user_role_id)
);

INSERT INTO  ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email)
VALUES ('bobmanager','password','Bob','Manager','bob.manager@revature.com'),
	   ('shigerumiyamoto','password','Shigeru','Miyamoto','mariogojump@revature.com'),
	   ('crazyrantsonfilm','password','Nicholas','Cage','goldylockshair@revature.com');

DROP TABLE ers_users;

CREATE TABLE ers_user_roles (
ers_user_role_id serial PRIMARY KEY,
user_role text
);

INSERT INTO  ers_user_roles (user_role)
VALUES ('Finance Manager'),
	   ('Programmer'),
	   ('Janitor'),
	  ('Secretary');
	


DROP TABLE ers_user_roles;

CREATE TABLE ers_reimbursement_type (
reimb_type_id serial PRIMARY KEY,
reimb_type text
);

INSERT INTO  ers_reimbursement_type (reimb_type)
VALUES ('Receipt'),
	   ('Bank Statement'),
	   ('Email');
	

DROP TABLE ers_reimbursement_type;

CREATE TABLE ers_reimbursement_status (
reimb_status_id serial PRIMARY KEY, 
reimb_status text 
);

INSERT INTO  ers_reimbursement_status (reimb_status)
VALUES ('Approved'),
	   ('Denied'),
	   ('Pending');
	

DROP TABLE ers_reimbursement_status;
