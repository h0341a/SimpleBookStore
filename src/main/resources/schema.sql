CREATE TABLE user(
    username VARCHAR(8) NOT NULL UNIQUE ,
    password VARCHAR(32) NOT NULL
);

CREATE TABLE book(
    bid INT AUTO_INCREMENT PRIMARY KEY,
    book_name VARCHAR(32) NOT NULL ,
    writer VARCHAR(32) NOT NULL
);