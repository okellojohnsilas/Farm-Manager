CREATE DATABASE IF NOT EXISTS farm;
USE farm;

CREATE TABLE IF NOT EXISTS animal(
  Animal_ID int(17) NOT NULL AUTO_INCREMENT,
  Tag_Number VARCHAR(17) NOT NULL DEFAULT '',
  Animal_breed TEXT NOT NULL DEFAULT '',
  Animal_gender TEXT NOT NULL DEFAULT '',
  Animal_color TEXT NOT NULL DEFAULT '',
  Animal_type TEXT NOT NULL DEFAULT '',
  Horn_type TEXT NOT NULL DEFAULT '',
  Age_group TEXT NOT NULL DEFAULT '',
  Animal_price TEXT NOT NULL DEFAULT '',
  Animal_picture TEXT,
  Animal_Added timestamp NOT NULL DEFAULT current_timestamp(),
  Details_Last_Updated timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY(Animal_ID),
  UNIQUE KEY(Tag_Number)
  );

CREATE TABLE IF NOT EXISTS farm(
   Farm_ID int(17) NOT NULL AUTO_INCREMENT,
   Farm_Name varchar(150) NOT NULL DEFAULT '',
   Farm_Location varchar(150) NOT NULL DEFAULT '',
  PRIMARY KEY (Farm_ID)
  );

CREATE TABLE IF NOT EXISTS sales(
   SalesID int(17) NOT NULL AUTO_INCREMENT,
   Tag_Number varchar(15) NOT NULL DEFAULT '',
   Buyer varchar(30) NOT NULL DEFAULT '',
   Buyer_Contact varchar(30) NOT NULL DEFAULT '',
   Amount_Paid varchar(17) NOT NULL DEFAULT '',
   Date_of_Sale timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (SalesID)
  );
