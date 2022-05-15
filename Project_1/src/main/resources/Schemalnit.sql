DROP TABLE IF EXISTS ers_users CASCADE;
DROP TABLE IF EXISTS ers_reimbursements CASCADE;


create type role as ENUM ('Employee', 'Manager');
create type type as ENUM ('Lodging', 'Travel', 'Food','Other');
create type status as ENUM ('Pending', 'Approved', 'Denied');



CREATE TABLE ers_users (

	ID SERIAL PRIMARY KEY,
	
	
	USERNAME VARCHAR (250) UNIQUE NOT NULL,
	PASSWORD VARCHAR (250) NOT NULL,
	ROLE VARCHAR (250) NOT NULL
);


CREATE TABLE ers_reimbursements (

	id SERIAL PRIMARY KEY,
	
	author INT NOT NULL,
	resolver INT,
	description TEXT NOT NULL,
	type VARCJAR (250) NOT NULL,
	status VARCHAR (250) NOT NULL,
	amount FLOAT NOT NULL,
	
	CONSTRAINT fk_author
		FOREIGN KEY (author)
			REFERENCES ers_users(id),
	CONSTRAINT fk_resolver
		FOREIGN KEY (resolver)
			REFERENCES ers_users(id)
);

INSERT INTO ers_users (USERNAME, PASSWORD, ROLE)
VALUES('DEFAULT', 'GUEST', 'EMPLOYEE'),('ADMIN', 'ADMIN', 'MANAGER');