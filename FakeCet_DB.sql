DROP TABLE IF EXISTS ALLOTEDOPTIONS;
DROP TABLE IF EXISTS PREFERENCES;
DROP TABLE IF EXISTS Options;
DROP TABLE IF EXISTS Branches;
DROP TABLE IF EXISTS Colleges;
DROP TABLE IF EXISTS Candidates;
DROP TABLE IF EXISTS CounslingPaymentDetails;
DROP TABLE IF EXISTS MARKS;
DROP TABLE IF EXISTS Hallticket;
DROP TABLE IF EXISTS StudentApplicationDetails;
DROP TABLE IF EXISTS ExamPaymentDetails;
DROP TABLE IF EXISTS AccademicDetails;
DROP TABLE IF EXISTS StudentPersonalDetails;


CREATE TABLE StudentPersonalDetails(
	StudentId INT PRIMARY KEY IDENTITY(1,1),
	StudentName VARCHAR(30) NOT NULL,
	FatherName VARCHAR(30) NOT NULL,
	MotherName VARCHAR(30) NOT NULL,
	DateofBith DATE NOT NULL,
	Aadharnumber VARCHAR(12) UNIQUE,
	Statee VARCHAR(20),
	Caste VARCHAR(10) NOT NULL,

)

CREATE TABLE AccademicDetails(
	Id INT PRIMARY KEY IDENTITY(1,1),
	IntermediatehallticketNo VARCHAR(12) NOT NULL,
	IntermediateCGPA FLOAT NOT NULL,
	TenthhallticketNo VARCHAR(12)
)

CREATE TABLE ExamPaymentDetails(
	PaymentId INT PRIMARY KEY IDENTITY(1,1),
	PaymentReferenceId VARCHAR(12) NOT NULL,
	Amount money NOT NULL,
	DateofPayment DATE NOT NULL, 
)


CREATE TABLE StudentApplicationDetails(
	RegistrationId INT PRIMARY KEY IDENTITY(1,1),
	StudentId INT UNIQUE,
	AccademicdetailsId INT UNIQUE,
	PaymentDetailsId INT UNIQUE,
	Foreign key(StudentId) references StudentPersonalDetails(StudentId),
	Foreign Key(AccademicdetailsId) references AccademicDetails(Id),
	Foreign key(PaymentDetailsId) references ExamPaymentDetails(PaymentId)
)

CREATE TABLE Hallticket(
	RegistrationId INT,
	Hallticketnumber VARCHAR(12) PRIMARY KEY,
	ExamCenter VARCHAR(20) NOT NULL,
	DateofExam Date NOT NULL,
	Foreign Key(RegistrationId) references  StudentApplicationDetails(RegistrationId)
)

CREATE TABLE MARKS(
	MarksID INT PRIMARY KEY IDENTITY(1,1),
	HallticketNumber VARCHAR(12),
	MathsMarks INT NOT NULL,
	PhysicsMarks INT NOT NULL,
	ChemistryMarks INT NOT NULL,
	TotalMarks INT,
	Rankk INT,
	Foreign Key(HallticketNumber) references Hallticket(HallticketNumber)
)


-------------------------------------------------------------------------------------------------------

CREATE TABLE CounslingPaymentDetails(
	CounslingPaymentReferenceId INT PRIMARY KEY IDENTITY(1,1),
	--regid,
	Amount money NOT NULL,
	DateOfPayment Date NOT NULL
)

CREATE TABLE Candidates(
	RegistrationID INT PRIMARY KEY,
	CounslingPaymentID INT,
	Foreign key(RegistrationID) references StudentApplicationDetails(RegistrationId),
	Foreign Key(CounslingPaymentID) references CounslingPaymentDetails(CounslingPaymentReferenceId)
)
select * from StudentApplicationDetails


CREATE TABLE Colleges(
	CollegeID INT PRIMARY KEY IDENTITY(1,1),
	CollegeName VARCHAR(30) UNIQUE,
)

CREATE TABLE Branches(
	BranchID INT PRIMARY KEY IDENTITY(1,1),
	Branchname VARCHAR(30) UNIQUE,
	GeneralAvailableSeats INT NOT NULL,
	BCAvailableSeats INT NOT NULL,
	SCAvailableSeats INT NOT NULL,
	STAvailableSeats INT NOT NULL
)

CREATE TABLE Options(
	OptionId INT PRIMARY KEY IDENTITY(1,1),
	OptionPriority INT,
	CollegeId INT,
	BranchId INT,
	Foreign key(CollegeId) references Colleges(CollegeID),
	Foreign Key(BranchID) references Branches(BranchID)
)

CREATE TABLE ALLOTEDOPTIONS(
	AllotmentId INT PRIMARY KEY IDENTITY(1,1),
	RegistrationId INT,
	OptionId INT,
	Foreign Key(RegistrationId) references Candidates(RegistrationId),
	Foreign Key(OptionId) references Options(OptionID)
)

INSERT INTO StudentPersonalDetails (StudentName, FatherName, MotherName, DateofBith, Aadharnumber, Statee, Caste) VALUES
('Rajesh Kumar', 'Ramachandra', 'Lakshmi', '2000-05-20', '123456789012', 'Kakinada', 'General'),
('Priya Reddy', 'Narasimha', 'Sita', '2001-08-15', '123456789013', 'Bhimavaram', 'OBC'),
('Vijay Kumar', 'Krishna', 'Radha', '2002-03-10', '123456789014', 'Rajahmundry', 'SC'),
('Anjali', 'Satyanarayana', 'Gowri', '2000-12-25', '123456789015', 'Kakinada', 'ST'),
('Karthik', 'Venkat', 'Lakshmi', '2001-01-30', '123456789016', 'Bhimavaram', 'General'),
('Suresh', 'Raju', 'Madhavi', '2002-04-18', '123456789017', 'Rajahmundry', 'OBC'),
('Sneha', 'Chandra', 'Nirmala', '2000-11-05', '123456789018', 'Kakinada', 'General'),
('Ajay', 'Krishna', 'Suma', '2001-02-22', '123456789019', 'Bhimavaram', 'SC'),
('Pooja', 'Raghava', 'Savita', '2002-07-30', '123456789020', 'Rajahmundry', 'ST'),
('Ravi', 'Vijaya', 'Vani', '2001-09-12', '123456789021', 'Kakinada', 'General');


INSERT INTO AccademicDetails (IntermediatehallticketNo, IntermediateCGPA, TenthhallticketNo) VALUES
('HT123456', 9.5, 'THT987654'),
('HT123457', 8.7, 'THT987655'),
('HT123458', 7.8, 'THT987656'),
('HT123459', 6.5, 'THT987657'),
('HT123460', 9.0, 'THT987658'),
('HT123461', 8.4, 'THT987659'),
('HT123462', 9.7, 'THT987660'),
('HT123463', 7.9, 'THT987661'),
('HT123464', 6.8, 'THT987662'),
('HT123465', 8.2, 'THT987663');


INSERT INTO ExamPaymentDetails (PaymentReferenceId, Amount, DateofPayment) VALUES
('RN123456', 500.00, '2024-01-10'),
('RN123457', 500.00, '2024-01-11'),
('RN123458', 500.00, '2024-01-12'),
('RN123459', 500.00, '2024-01-13'),
('RN123460', 500.00, '2024-01-14'),
('RN123461', 500.00, '2024-01-15'),
('RN123462', 500.00, '2024-01-16'),
('RN123463', 500.00, '2024-01-17'),
('RN123464', 500.00, '2024-01-18'),
('RN123465', 500.00, '2024-01-19');

