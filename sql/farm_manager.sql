-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2019 at 08:03 PM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `farm_manager`
--
CREATE DATABASE IF NOT EXISTS `farm_manager` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `farm_manager`;

-- --------------------------------------------------------

--
-- Table structure for table `animal`
--

CREATE TABLE IF NOT EXISTS `animal` (
  `Animal_ID` int(17) NOT NULL AUTO_INCREMENT,
  `Tag_Number` varchar(15) NOT NULL DEFAULT '',
  `Animal_breed` varchar(15) NOT NULL DEFAULT '',
  `Animal_gender` varchar(17) NOT NULL DEFAULT '',
  `Animal_color` varchar(17) NOT NULL DEFAULT '',
  `Horn_type` varchar(17) NOT NULL DEFAULT '',
  `Age_group` varchar(17) NOT NULL DEFAULT '',
  `Animal_price` varchar(17) NOT NULL DEFAULT '',
  `Animal_Added` timestamp NOT NULL DEFAULT current_timestamp(),
  `Details_Last_Updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`Animal_ID`),
  UNIQUE KEY `Tag_Number` (`Tag_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `farm`
--

CREATE TABLE IF NOT EXISTS `farm` (
  `Farm_ID` int(17) NOT NULL AUTO_INCREMENT,
  `Farm_Name` varchar(150) NOT NULL DEFAULT '',
  `Farm_Location` varchar(150) NOT NULL DEFAULT '',
  PRIMARY KEY (`Farm_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `sales`
--

CREATE TABLE IF NOT EXISTS `sales` (
  `SalesID` int(17) NOT NULL AUTO_INCREMENT,
  `Tag_Number` varchar(15) NOT NULL DEFAULT '',
  `Buyer` varchar(30) NOT NULL DEFAULT '',
  `Buyer_Contact` varchar(30) NOT NULL DEFAULT '',
  `Amount_Paid` varchar(17) NOT NULL DEFAULT '',
  `Date_of_Sale` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`SalesID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `User_ID` varchar(17) NOT NULL DEFAULT '',
  `FirstName` varchar(30) NOT NULL DEFAULT '',
  `LastName` varchar(30) NOT NULL DEFAULT '',
  `userName` varchar(35) NOT NULL DEFAULT '',
  `userType` varchar(35) NOT NULL DEFAULT '',
  `user_password` text NOT NULL DEFAULT '',
  `user_telephone_number` varchar(15) NOT NULL DEFAULT '',
  `user_profile_picture` text DEFAULT NULL,
  `Farm_Name` varchar(150) NOT NULL DEFAULT '',
  `Account_Created` timestamp NOT NULL DEFAULT current_timestamp(),
  `Account_Last_Updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`User_ID`),
  UNIQUE KEY `User_telephone_number` (`user_telephone_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`User_ID`, `FirstName`, `LastName`, `userName`, `userType`, `user_password`, `user_telephone_number`, `user_profile_picture`, `Farm_Name`, `Account_Created`, `Account_Last_Updated`) VALUES
('2H1W3GKVFJDVF4GYX', 'Okello', 'John', 'OJ49', 'Admin', '500:5b42403263323537656234:0f12def08f8be385fd56a118db99c722a9ebe720471910df096f1c36540c4b4d49b0602edfdc2634050adb8b6c41daccb9ce4fe8e8ddc1459ffc1dbab5141636', '0756986754', NULL, 'Bugondo', '2019-11-17 11:47:24', '2019-11-17 11:47:24'),
('2YYRY14K4SD4CNUXE', 'Ejoku', 'Jireh', 'Jireh', 'User', '500:5b42403332303130656338:73dd4e14a8d0d60ab87bc48af8c42e2706183acc0f84b614bb239a177670a9849ad9b364ab94dfabe39fbdb37e70f394626011075ee937e7a146a8ee5208ecac', '07861533333', NULL, 'Bugondo', '2019-12-06 18:03:19', '2019-12-06 18:03:19'),
('MHTTAFFUFRIXG6H16', 'Nelson', 'Omagor', 'Nelson', 'Admin', '500:5b42403431646430653139:95f16c054e06f2b7f17d614a63a48953fcf072aff262c44c58bc1e25ec7407a17ac0065c8f42529b3407c8ee92aab9567262a5b607be265bf4323b5c312c6a3e', '0745638765', NULL, 'Bugondo', '2019-11-17 11:33:25', '2019-11-17 11:33:25');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
