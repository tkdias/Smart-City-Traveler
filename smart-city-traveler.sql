-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2019 at 09:36 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chathudb`
--

-- --------------------------------------------------------

--
-- Table structure for table `district`
--

CREATE TABLE `district` (
  `District_ID` varchar(5) NOT NULL,
  `District_Name` varchar(50) NOT NULL,
  `Province_Name` varchar(50) NOT NULL,
  `Date_Added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `district`
--

INSERT INTO `district` (`District_ID`, `District_Name`, `Province_Name`, `Date_Added`) VALUES
('1059', 'Gampaha', 'Western Province', '2019-09-29 22:08:45'),
('1496', 'Galle', 'Southern Province', '2019-09-29 22:10:21'),
('1568', 'Hambantota', 'Southern Province', '2019-09-29 22:11:22'),
('1936', 'Matale', 'Central Province', '2019-09-30 06:46:27'),
('2274', 'Kalutara', 'Western Province', '2019-09-29 22:09:06'),
('2587', 'Trincomalee', 'Eastern Province', '2019-09-30 06:48:50'),
('3099', 'Batticaloa', 'Eastern Province', '2019-09-29 22:14:09'),
('3513', 'Mannar', 'Northern Province', '2019-09-30 06:44:15'),
('357', 'Kegalle', 'Sabaragamuwa Province', '2019-09-30 06:48:09'),
('3623', 'Ampara', 'Eastern Province', '2019-09-29 22:13:35'),
('4349', 'Vavuniya', 'Northern Province', '2019-09-30 06:44:49'),
('4362', 'Mullaitivu', 'Northern Province', '2019-09-30 06:44:32'),
('4740', 'Matara', 'Southern Province', '2019-09-29 22:10:40'),
('492', 'Kilinochchi', 'Northern Province', '2019-09-30 06:44:01'),
('5226', 'Nuwara Eliya', 'Central Province', '2019-09-30 06:47:29'),
('6118', 'Ratnapura', 'Sabaragamuwa Province', '2019-09-30 06:48:30'),
('6778', 'Kurunegala', 'North Western Province', '2019-09-30 06:45:43'),
('7281', 'Kandy', 'Central Province', '2019-09-30 06:46:43'),
('8077', 'Anuradhapura', 'North Central Province', '2019-09-29 22:19:42'),
('8172', 'Polonnaruwa', 'North Central Province', '2019-09-29 22:20:11'),
('8510', 'Puttalam', 'North Western Province', '2019-09-30 06:45:25'),
('9186', 'Colombo', 'Western Province', '2019-09-29 22:07:20'),
('970', 'Jaffna', 'Northern Province', '2019-09-30 06:43:46');

-- --------------------------------------------------------

--
-- Table structure for table `hometable`
--

CREATE TABLE `hometable` (
  `ID` int(11) NOT NULL,
  `Name` varchar(40) NOT NULL,
  `Date` date NOT NULL,
  `Checkbox` varchar(5) NOT NULL,
  `Gender` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hometable`
--

INSERT INTO `hometable` (`ID`, `Name`, `Date`, `Checkbox`, `Gender`) VALUES
(1001, 'Tharindu', '2017-05-12', 'true', 'Male'),
(1002, 'Rajitha', '2016-04-05', 'true', 'Male'),
(1003, 'Chathu', '2017-05-02', 'true', 'Female'),
(1004, 'Chamo', '2017-05-20', 'true', 'Female'),
(1994, 'Dias', '2017-05-03', 'false', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `Location_ID` varchar(5) NOT NULL,
  `Location_Name` varchar(50) NOT NULL,
  `District_Name` varchar(50) NOT NULL,
  `Location_URL` varchar(200) NOT NULL,
  `Date_Added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`Location_ID`, `Location_Name`, `District_Name`, `Location_URL`, `Date_Added`) VALUES
('1575', 'Alawala Pre-Historic Archeolical Site', 'Gampaha', 'https://goo.gl/maps/jgL1rbNixEqZwV1GA', '2019-09-30 09:28:18'),
('3468', 'Henarathgoda Botanical Garden', 'Gampaha', 'https://goo.gl/maps/eN6Av1PG62e9Fg6a8', '2019-09-30 09:20:53'),
('9228', 'Water World Lanka', 'Gampaha', 'https://goo.gl/maps/WyJ7vDezDjZDWJm19', '2019-09-30 09:25:19');

-- --------------------------------------------------------

--
-- Table structure for table `province`
--

CREATE TABLE `province` (
  `Province_ID` varchar(5) NOT NULL,
  `Province_Name` varchar(50) NOT NULL,
  `Date_Added` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `province`
--

INSERT INTO `province` (`Province_ID`, `Province_Name`, `Date_Added`) VALUES
('3268', 'Western Province', '2019-09-29 15:21:09'),
('3645', 'North Central Province', '2019-09-29 21:15:19'),
('3882', 'Eastern Province', '2019-09-29 21:10:46'),
('5097', 'Northern Province', '2019-09-29 21:14:10'),
('5294', 'Uva Province', '2019-09-29 21:15:34'),
('5386', 'Sabaragamuwa Province', '2019-09-29 21:15:47'),
('7985', 'Southern Province', '2019-09-29 21:14:40'),
('9148', 'North Western Province', '2019-09-29 21:14:57'),
('9197', 'Central Province', '2019-09-29 21:13:31');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` varchar(5) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `username` varchar(20) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `first_name`, `last_name`, `username`, `email`, `password`, `phone`, `dob`, `address`) VALUES
('1001', 'Tharindu', 'Dias', 'tkdias', 'tkdias7@gmail.com', 'qqq', '713633892', '1992-01-16', 'sacfcvwsv'),
('1002', 'Jithmal', 'Bandara', 'jithmal', 'jithmal.92@gmail.com', 'Pwd@123', '713633892', '1992-01-16', 'sacfcvwsv');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `district`
--
ALTER TABLE `district`
  ADD PRIMARY KEY (`District_ID`);

--
-- Indexes for table `hometable`
--
ALTER TABLE `hometable`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`Location_ID`);

--
-- Indexes for table `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`Province_ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
