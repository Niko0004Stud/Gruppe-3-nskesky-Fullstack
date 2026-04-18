DROP DATABASE IF EXISTS WishDB;

CREATE DATABASE WishDB;

USE WishDB;


CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       firstName VARCHAR(50) NOT NULL,
                       lastName VARCHAR(50) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       tlfNumber VARCHAR(20) NOT NULL,
                       gender VARCHAR(20) NOT NULL,
                       birthDate DATE NOT NULL,
                       password VARCHAR(50) NOT NULL
);






CREATE TABLE wishlists (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           userID INT NOT NULL ,
                           FOREIGN KEY (userID) REFERENCES users(id),
                           name VARCHAR(20) NOT NULL
);



CREATE TABLE wishes (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        wishlistID INT NOT NULL ,
                        FOREIGN KEY (wishlistID) REFERENCES wishlists(id),
                        name VARCHAR(60) NOT NULL,
                        price DECIMAL NOT NULL,
                        url VARCHAR(1000) NOT NULL
);

ALTER TABLE wishlists ADD COLUMN shareToken VARCHAR(255);


CREATE TABLE reservation (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             wishId INT,
                             userId INT,

                             FOREIGN KEY (wishId) REFERENCES wishes(id),
                             FOREIGN KEY (userId) REFERENCES users(id)
);