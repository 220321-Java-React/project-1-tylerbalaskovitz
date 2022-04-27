CREATE TABLE ers_reimbursement(
reimb_id serial PRIMARY KEY, --The serial KEY FOR identifying the cord inserted INTO the table
reimb_ammount int,
reimb_submitted timestamp, 
reimb_resolved timestamp,
reimb_description VARCHAR (250),
reimb_receipt int,
reimb_author int REFERENCES ers_users(ers_users_id),
reimb_resolver int REFERENCES  ers_users(ers_users_id),
reimb_status_id int REFERENCES ers_reimbursement_status(reimb_status_id),
reimb_type_id int REFERENCES  ers_reimbursement_type(reimb_type_id)-- these four reference the other TABLES TO be used WITHIN P1
);

CREATE TABLE ers_users (
ers_users_id serial PRIMARY KEY, 
ers_username VARCHAR (50),
ers_password VARCHAR (50),
user_first_name VARCHAR (100),
user_last_name VARCHAR (100), 
user_email VARCHAR (150),
user_role_id int REFERENCES ers_user_roles(ers_user_role_id)
);

DROP TABLE ers_users;

CREATE TABLE ers_user_roles (
ers_user_role_id serial PRIMARY KEY,
user_role VARCHAR (10)
);

DROP TABLE ers_user_roles;

CREATE TABLE ers_reimbursement_type (
reimb_type_id serial PRIMARY KEY,
reimb_type VARCHAR (10)
);

DROP TABLE ers_reimbursement_type;

CREATE TABLE ers_reimbursement_status (
reimb_status_id serial PRIMARY KEY, 
reimb_status VARCHAR(10) 

);

DROP TABLE ers_reimbursement_status;
