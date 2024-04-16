USE [JWEB.P.A101]



IF NOT EXISTS(SELECT * FROM sys.tables WHERE name = 'Author')
CREATE TABLE Author(
Author_Id INT PRIMARY KEY,
Auhtor_Name NVARCHAR(50),
)

IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Book')
CREATE TABLE Book(
Book_ID INT PRIMARY KEY,
Title NVARCHAR(50),
Page_Count INT ,
Date_published DATE,
Price MONEY,
Status BIT,
Author_id INT,
CONSTRAINT Check_Book CHECK (Date_published <= GetDate()),
FOREIGN KEY (Author_Id) REFERENCES Author(Author_Id),
)

INSERT INTO Book(Book_ID,Title,Page_Count,Date_published,Price,Status,Author_id) VALUES (1,'a',1,'2011-11-11',12,1,1);

INSERT INTO Author(Author_Id,Auhtor_Name) VALUES (1,'A');

SELECT * FROM Book

SELECT * FROM Author

ALTER TABLE Book ADD Book_ID INT IDENTITY(1,1);



