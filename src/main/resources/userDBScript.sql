DROP DATABASE IF EXISTS CloudWishProject;

CREATE DATABASE CloudWishProject;

USE CloudWishProject;

-- User table
CREATE TABLE user (
        id INT AUTO_INCREMENT PRIMARY KEY,
        firstName VARCHAR(50) NOT NULL,
        lastName VARCHAR(50) NOT NULL,
        email VARCHAR(100) NOT NULL,
        tlfNumber VARCHAR(20) NOT NULL,
        gender VARCHAR(20) NOT NULL,
        birthDate DATE NOT NULL,
        password VARCHAR(50) NOT NULL
);



-- Wishlist_Collection table
# CREATE TABLE wishlistCollection (
#         id INT AUTO_INCREMENT PRIMARY KEY,
#         userID INT,
#         FOREIGN KEY (userID) REFERENCES User(id),
#         name VARCHAR(20)
# );


-- Wishlist table
CREATE TABLE wishlist (
    id INT AUTO_INCREMENT PRIMARY KEY,
    userID INT NOT NULL ,
    FOREIGN KEY (userID) REFERENCES wishlist(id),
    name VARCHAR(20) NOT NULL
);


-- Wish table
CREATE TABLE wish (
    id INT AUTO_INCREMENT PRIMARY KEY,
    wishlistID INT NOT NULL ,
    FOREIGN KEY (wishlistID) REFERENCES wishlist(id),
    name VARCHAR(60) NOT NULL,
    price DECIMAL NOT NULL,
    url VARCHAR(1000) NOT NULL
);