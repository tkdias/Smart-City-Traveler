-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2017 at 10:50 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `chathudb`
--
DROP DATABASE IF EXISTS `chathudb`;
CREATE DATABASE IF NOT EXISTS `chathudb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `chathudb`;

-- --------------------------------------------------------

--
-- Table structure for table `hometable`
--

DROP TABLE IF EXISTS `hometable`;
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
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `username` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`) VALUES
('Admin', 'Killme'),
('User', 'xxx'),
('dias', 'dias123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hometable`
--
ALTER TABLE `hometable`
  ADD PRIMARY KEY (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
