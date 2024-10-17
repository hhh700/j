CREATE TABLE User (
	user_id INTEGER PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
    address VARCHAR(100),
    phone_number VARCHAR(12),
	username VARCHAR(12) NOT NULL,
	password VARCHAR(12) NOT NULL,
	is_admin boolean NOT NULL,
);

CREATE TABLE Scroll (
	scroll_id INTEGER PRIMARY KEY,
	name VARCHAR(100) UNIQUE NOT NULL,
	binary_file_name VARCHAR(255),
	binary_file_data bytea,
)