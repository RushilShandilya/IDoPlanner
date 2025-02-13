DROP DATABASE IF EXISTS IDoPlanner;

CREATE DATABASE IF NOT EXISTS IDoPlanner;

USE IDoPlanner;

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

CREATE TABLE IF NOT EXISTS Services(
     serviceId INT PRIMARY KEY AUTO_INCREMENT,
     serviceName VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS ServiceProviders(
    spId INT PRIMARY KEY AUTO_INCREMENT,
    spName VARCHAR(20),
    spEmail VARCHAR(20),
    spPasswordHash VARCHAR(255),
    spNumber INT,
    serviceId INT,

    FOREIGN KEY(serviceId) references Services(serviceId)
);

CREATE TABLE IF NOT EXISTS Bookings(
	bookingId INT PRIMARY KEY AUTO_INCREMENT,
	clientId INT,
	spId INT,
	bookingDate DATETIME,
	status VARCHAR(20),
	FOREIGN KEY (clientId) references Clients(clientId),
    FOREIGN KEY (spId) references ServiceProviders(spId)
);
