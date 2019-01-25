DROP DATABASE IF EXISTS i_shop ;
CREATE DATABASE i_shop CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use i_shop;

CREATE TABLE product (
id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
description VARCHAR(255) NOT NULL,
price int (11) NOT NULL
);

create table user (
id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
email VARCHAR (50) NOT NULL,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
role VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL
);

create table bucket (
id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
user_id INT(11) NOT NULL,
product_id INT(11) NOT NULL,
purchase_date TIMESTAMP NOT NULL
);

ALTER TABLE bucket  ADD FOREIGN KEY (user_id) REFERENCES user (id);
ALTER TABLE bucket  ADD FOREIGN KEY (product_id) REFERENCES product (id);