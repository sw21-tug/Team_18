-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 10, 2021 at 05:31 PM
-- Server version: 5.7.32-35-log
-- PHP Version: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `u182913db2`
--

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `test` int(11) NOT NULL,
  `text` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`id`, `test`, `text`) VALUES
(1, 10, 'testtext'),
(2, 4, 'test');

-- --------------------------------------------------------

--
-- Table structure for table `userdata`
--

CREATE TABLE `userdata` (
  `id` int(11) NOT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `amount` double NOT NULL,
  `date` date DEFAULT NULL,
  `account` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `category` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `tags` text COLLATE utf8_unicode_ci,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `userdata`
--

INSERT INTO `userdata` (`id`, `type`, `userid`, `amount`, `date`, `account`, `category`, `description`, `tags`, `created_at`, `updated_at`) VALUES
(12, 'income', 38, 100, '2021-05-19', 'Privat', 'Hardware', 'Keyboard', 'Salary', '2021-05-19', '2021-05-19'),
(59, 'expense', 38, -123, '1999-05-31', 'ah', 'ok', 'c', NULL, '2021-06-09', '2021-06-09'),
(64, 'income', 38, 1234, '2021-09-01', 'asdf', 'asdf', 'asdf', 'Salary', '2021-06-09', '2021-06-09'),
(65, 'expense', 38, -214324, '2021-09-01', 'asdf', 'asdf', 'asdf', NULL, '2021-06-09', '2021-06-09'),
(66, 'income', 38, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', 'Personal Hygiene', '2021-06-09', '2021-06-09'),
(67, 'expense', 38, -1000, '2020-01-01', 'Расходы', 'Расходы', 'Расходы', NULL, '2021-06-09', '2021-06-09'),
(68, 'income', 38, 123, '2021-10-01', '国家队的', '分局小弟弟', '与吃饭', NULL, '2021-06-09', '2021-06-09'),
(69, 'income', 38, 1234, '2021-10-11', 'cagg', 'asdf', 'asdf', 'Payback', '2021-06-09', '2021-06-09'),
(70, 'income', 38, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(71, 'expense', 38, -1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(72, 'income', 38, 2314, '2021-10-01', 'asdf', 'asdf', 'qwertz', 'Payback,Rent', '2021-06-10', '2021-06-10'),
(73, 'expense', 38, -3000, '2010-10-10', 'asdf', 'asdf', 'asdf', 'Rent', '2021-06-10', '2021-06-10'),
(74, 'income', 38, 1234, '2021-12-01', 'a', 'b', 'c', 'Payback', '2021-06-10', '2021-06-10'),
(75, 'income', 38, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', '', '2021-06-10', '2021-06-10'),
(76, 'expense', 38, -1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', '', '2021-06-10', '2021-06-10'),
(77, 'expense', 38, -1000, '2020-01-01', 'business', 'computer', 'monitor', 'Car', '2021-06-10', '2021-06-10'),
(78, 'expense', 38, -1000, '2020-01-01', 'business', 'computer', 'monitor', 'Car', '2021-06-10', '2021-06-10');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `prename` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `lastname` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `pw` text COLLATE utf8_unicode_ci NOT NULL,
  `apiKey` text COLLATE utf8_unicode_ci NOT NULL,
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `prename`, `lastname`, `email`, `pw`, `apiKey`, `created_at`, `updated_at`) VALUES
(38, 'Test', 'User', 'root@root.at', 'eyJpdiI6IkowSUJOZENIeXZZMmZQSFBma0tmZWc9PSIsInZhbHVlIjoiazZXK0xKMTJ5czcwa1ZBMmVOUWxEQT09IiwibWFjIjoiNWE3MDJmNjZhMDVlY2M3MzhlYWY5ZjUzZjk4YmRkY2Y0Mzg5NzlmOWQyNTQzZTFlNTRmYTRjMzQwMzc0Njk0NCJ9', 'R0ljcVgxdGVPb0tSWlFXd1ZYOXdGalBBSmM5emhRNDM4Q2RNWElRRw==', '2021-05-19', '2021-05-19');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `userdata`
--
ALTER TABLE `userdata`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `test`
--
ALTER TABLE `test`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `userdata`
--
ALTER TABLE `userdata`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
