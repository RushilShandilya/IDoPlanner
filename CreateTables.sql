CREATE DATABASE IF NOT EXISTS IDoPlanner;

CREATE TABLE IF NOT EXISTS Admins(
	adminId INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100),
	email VARCHAR(100),
	passwordHash VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Clients(
	clientId INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(100),
	email VARCHAR(100),
	phoneNumber BIGINT,
	passwordHash VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS Bookings(
	bookingId INT PRIMARY KEY AUTO_INCREMENT,
	clientId INT,
	serviceProviderId VARCHAR(50),
	bookingDate DATETIME,
	status VARCHAR(20),
	FOREIGN KEY (clientId) references Clients(clientId)
);
