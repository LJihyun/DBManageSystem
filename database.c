CREATE TABLE Product(
Product_ID VARCHAR(20) NOT NULL,
Product_Name VARCHAR(30) NOT NULL,
Price INT(10) NOT NULL,
PRIMARY KEY(Product_ID)
);

CREATE TABLE Franchising(
Franchising_ID VARCHAR(20) NOT NULL,
Franchising_Name VARCHAR(30) NOT NULL,
Franchising_Location VARCHAR(50) NOT NULL,
Franchising_Office_Hours VARCHAR(50) NOT NULL,
Franchising_Number VARCHAR(50) NOT NULL,
Franchising_Performance VARCHAR(50) NOT NULL,
PRIMARY KEY(Franchising_ID)
);

CREATE TABLE WareHouse(
wFranchising_ID VARCHAR(20) NOT NULL,
wProduct_ID VARCHAR(20) NOT NULL,
Quantity INT(10) NOT NULL DEFAULT 0,
PRIMARY KEY(wFranchising_ID, wProduct_ID),
FOREIGN KEY(wFranchising_ID) REFERENCES Franchising (Franchising_ID) ON DELETE CASCADE,
FOREIGN KEY(wProduct_ID) REFERENCES Product (Product_ID)
);

CREATE TABLE Manager(
Employee_ID VARCHAR(20) NOT NULL,
Employee_Name VARCHAR(20) NOT NULL,
Salary INT(10) NOT NULL,
Phone_Number VARCHAR(20) NOT NULL,
mFranchising_ID VARCHAR(20) NOT NULL,
PRIMARY KEY(Employee_ID),
FOREIGN KEY(mFranchising_ID) REFERENCES Franchising (Franchising_ID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE PartTime(
PartTime_ID VARCHAR(20) NOT NULL,
PartTime_Name VARCHAR(20) NOT NULL,
PartTime_Salary INT(10) NOT NULL,
PartTime_Phone VARCHAR(20) NOT NULL,
pFranchising_ID VARCHAR(20) NOT NULL,
PRIMARY KEY(PartTime_ID),
FOREIGN KEY(pFranchising_ID) REFERENCES Franchising (Franchising_ID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE Performance(
pfProduct_ID VARCHAR(20) NOT NULL,
pfFranchising_ID VARCHAR(20) NOT NULL,
Month DATE NOT NULL,
Take INT(10) DEFAULT NULL,
Cost INT(10) DEFAULT NULL,
Net_Profit INT (10) DEFAULT NULL,
PRIMARY KEY(pfProduct_ID, pfFranchising_ID, Month),
FOREIGN KEY(pfProduct_ID) REFERENCES Product (Product_ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
FOREIGN KEY(pfFranchising_ID) REFERENCES Franchising (Franchising_ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);


/////////////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO Product(Product_ID, Product_Name, Price) values ('A1', 'redSnack', 2500);
INSERT INTO Product(Product_ID, Product_Name, Price) values ('A2', 'blueSnack', 2200);
INSERT INTO Product(Product_ID, Product_Name, Price) values ('B1', 'Coke', 1500);
INSERT INTO Product(Product_ID, Product_Name, Price) values ('B2', 'Pepshi', 1300);
INSERT INTO Product(Product_ID, Product_Name, Price) values ('C1', 'Jelly', 3000);

INSERT INTO Franchising(Franchising_ID, Franchising_Name, Franchising_Location, Franchising_Office_Hours, Franchising_Number, Franchising_Performance) values ('F1', 'BHC_수원', '경기도 수원시', '09:00~21:00', '031-123-4566', 'B');


INSERT INTO Manager(Employee_ID, Employee_Name, Salary, Phone_Number, mFranchising_ID) values ('E1', 'Tom', 5000, '01012345678', 'F1');
INSERT INTO Manager(Employee_ID, Employee_Name, Salary, Phone_Number, mFranchising_ID) values ('E2', 'Alice', 4000, '01098765432', 'F2');
INSERT INTO Manager(Employee_ID, Employee_Name, Salary, Phone_Number, mFranchising_ID) values ('E3', 'Tony', 5500, '01055558888', 'F5');
INSERT INTO Manager(Employee_ID, Employee_Name, Salary, Phone_Number, mFranchising_ID) values ('E4', 'Wohwa', 50000, '01078976546', 'F4');
INSERT INTO Manager(Employee_ID, Employee_Name, Salary, Phone_Number, mFranchising_ID) values ('E5', 'Tom', 6000, '01036985214', 'F3');

INSERT INTO PartTime(PartTime_ID, PartTime_Name, PartTime_Salary, PartTime_Phone, pFranchising_ID) values ('P1', 'Andy', 300, '01054546565', 'F1');
INSERT INTO PartTime(PartTime_ID, PartTime_Name, PartTime_Salary, PartTime_Phone, pFranchising_ID) values ('P2', 'Pole', 230, '01021653254', 'F1');
INSERT INTO PartTime(PartTime_ID, PartTime_Name, PartTime_Salary, PartTime_Phone, pFranchising_ID) values ('P3', 'Hoon', 230, '01098563652', 'F3');
INSERT INTO PartTime(PartTime_ID, PartTime_Name, PartTime_Salary, PartTime_Phone, pFranchising_ID) values ('P4', 'Mina', 250, '01098564712', 'F4');
INSERT INTO PartTime(PartTime_ID, PartTime_Name, PartTime_Salary, PartTime_Phone, pFranchising_ID) values ('P5', 'Gayoung', 200, '01032549177', 'F2');

INSERT INTO Delivery(dHEAD_Office_Name, dProduct_ID, Quantity) values ();
INSERT INTO Delivery(dHEAD_Office_Name, dProduct_ID, Quantity) values ();
INSERT INTO Delivery(dHEAD_Office_Name, dProduct_ID, Quantity) values ();
INSERT INTO Delivery(dHEAD_Office_Name, dProduct_ID, Quantity) values ();
INSERT INTO Delivery(dHEAD_Office_Name, dProduct_ID, Quantity) values ();
