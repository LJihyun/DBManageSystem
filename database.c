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
FOREIGN KEY(wProduct_ID) REFERENCES Product (Product_ID) ON DELETE CASCADE
);

CREATE TABLE Employee(
Employee_ID VARCHAR(20) NOT NULL,
eFranchising_ID VARCHAR(20) NOT NULL,
Employee_Name VARCHAR(20) NOT NULL,
Salary INT(10) NOT NULL,
Employee_Phone VARCHAR(20) NOT NULL,
PRIMARY KEY(Employee_ID, eFranchising_ID),
FOREIGN KEY(eFranchising_ID) REFERENCES Franchising (Franchising_ID) ON DELETE CASCADE
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


/////////////////////////////////////////////////////////////////////////////////////////////////////////////

INSERT INTO Product(Product_ID, Product_Name, Price) values ('A1', 'redSnack', 2500);
INSERT INTO Product(Product_ID, Product_Name, Price) values ('A2', 'blueSnack', 2200);
INSERT INTO Product(Product_ID, Product_Name, Price) values ('B1', 'Coke', 1500);
INSERT INTO Product(Product_ID, Product_Name, Price) values ('B2', 'Pepshi', 1300);
INSERT INTO Product(Product_ID, Product_Name, Price) values ('C1', 'Jelly', 3000);

INSERT INTO Franchising(Franchising_ID, Franchising_Name, Franchising_Location, Franchising_Office_Hours, Franchising_Number, Franchising_Performance) values ('F1', 'BHC_수원', '경기도 수원시', '09:00~21:00', '031-123-4566', 'B');

INSERT INTO WareHouse(wFranchising_ID, wProduct_ID, Quantity) values ('F1', 'A1', 100);

INSERT INTO Employee(Employee_ID, eFranchising_ID, Employee_Name, Salary, Employee_Phone) values ('E1', 'F1', 'Tom', 5000, '010-1234-5678');

INSERT INTO PartTime(PartTime_ID, PartTime_Name, PartTime_Salary, PartTime_Phone, pFranchising_ID) values ('P1', 'Andy', 300, '010-5454-6565', 'F1');



