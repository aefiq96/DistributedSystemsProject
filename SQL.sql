Create DATABASE HIRE;
use HIRE;


CREATE TABLE IF NOT EXISTS Orders (
    OrderID int NOT NULL AUTO_INCREMENT,
	Date DATE Not Null,
    CustID int Not Null,
	CarID int Not Null,
	UNIQUE(OrderID),
    PRIMARY KEY (OrderID),
    FOREIGN KEY (CustID) REFERENCES Customers(CustID),
	FOREIGN KEY (CarID) REFERENCES CAR(CarID)
);


CREATE TABLE IF NOT EXISTS Customers (
    CustID int NOT NULL AUTO_INCREMENT,
    FirstName VARCHAR(255) NOT NULL,
	LastName VARCHAR(255) NOT NULL,
    PRIMARY KEY (CustID)
);

CREATE TABLE IF NOT EXISTS CAR(
	CarID int NOT NULL AUTO_INCREMENT,
	CarBrand VARCHAR(255) NOT NULL,
	CarModel VARCHAR(255) NOT NULL,
	PRIMARY KEY (CarID)
);



INSERT INTO Customers (FirstName, LastName)
VALUES ('Adam','Manion'),
	   ('Adam','Sandler'),
	   ('Jerry','Storm');

	   
	
INSERT INTO CAR (CarBrand, CarModel)
VALUES ('Ford','Opel'),
	   ('BMW ','I8'),
	   ('Nissan','Skiline');

INSERT INTO Orders (Date, CustID, CarID)
VALUES (CURDATE(),1,1),
	   (CURDATE(),2,2),
	   (CURDATE(),3,3);