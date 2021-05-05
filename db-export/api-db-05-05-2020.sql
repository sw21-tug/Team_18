-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 05, 2021 at 09:40 AM
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
  `created_at` date NOT NULL,
  `updated_at` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `userdata`
--

INSERT INTO `userdata` (`id`, `type`, `userid`, `amount`, `date`, `account`, `category`, `description`, `created_at`, `updated_at`) VALUES
(1, 'income', 0, 3, NULL, 'privat', 'shopping', NULL, '2021-05-05', '2021-05-05'),
(2, 'income', 0, 10, '2001-01-20', 'business', 'office', NULL, '2021-05-05', '2021-05-05'),
(3, 'income', 0, 200, '2021-01-01', 'whatever', 'office', 'printer', '2021-05-05', '2021-05-05'),
(4, 'income', 0, 200, '2020-01-01', 'whatever', 'office', 'printer', '2021-05-05', '2021-05-05'),
(5, 'expense', 0, 300, '2020-01-01', 'privat', 'computer', 'monitor', '2021-05-05', '2021-05-05'),
(6, 'income', 0, 1000, '2020-01-01', 'privat', 'bitcoin', 'dogecoin', '2021-05-05', '2021-05-05'),
(7, 'income', 0, 1000, '2020-01-01', 'public', 'state', 'corruption', '2021-05-05', '2021-05-05'),
(8, 'expense', 0, 10, '2020-01-01', 'private', 'fuatgehn', 'vodi', '2021-05-05', '2021-05-05');

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
(2, 'Kilian', 'Weisl', 'kilian@weisl.cc', 'test', 'dkxkdDh5V2RyY2txOWhJbnNHWjV1Q1VCZVNUNFI4NEJPTW9nVUh5Mg==', '2021-04-25', '2021-04-25'),
(10, 'Kilian', 'Weisl', 'kilian@weisl.cc', 'eyJpdiI6ImdyODU2Q3crQVhRV0M5OEt0eUdaZ3c9PSIsInZhbHVlIjoiY0V1MVJSU3JlaTFoRjdTWktMRStsUT09IiwibWFjIjoiNjg3YjUyZjA5MTZhMDdkNjEzNDg5MjJmMTI1ZWExZTI3NTYyOTcyMmI2YjBmYjkzYzAxNzZlZWE3ZDYwYjJkZCJ9', 'MDduWWN1endvTkJPd0duQlQ3aVVqbWhyQ3VIdnd1clo2clYyMmNreQ==', '2021-05-04', '2021-05-04'),
(11, 'Kilian', 'Weisl', 'asdf@asdf.com', 'eyJpdiI6IkNvb1grSDNvVFlodTlpTjQ3dGVqRVE9PSIsInZhbHVlIjoiUEVPK2F2aktBSGwzLzhkTmxRM1NnUT09IiwibWFjIjoiMmJiMWZhNmE3ZmVlOTc3MDY1ZTUxNWI3YWU4NjA5ZWQyOTU3ZWQ2Yjk5MWZhYzZjOGZkNWVkZWZiZmUyZmRiZiJ9', 'Mjc0dldjTVhEMXBQazN2WXdQUDRYRkJQbmZLSVBsWlk3dGN5VG8yZg==', '2021-05-04', '2021-05-04'),
(12, 'test', 'testi', 'test@testi.testi', 'eyJpdiI6IllycE5pMmgwNVBpd3BLVWxhMzJzVnc9PSIsInZhbHVlIjoiTU0xUE5DczI1SVZ1WDhaQVF6SEFjUT09IiwibWFjIjoiZjE5ZjQ0OTIxMTE5ZGVjOWFiNDIxOWE2ODczYzZjYjQ0MTk1NzgyNzhkZDUwNTMyNTY1YTEwMTc1NjJlMTJiMSJ9', 'RFVtYkZCR2FoNGtZS1pSaVFvYUdObDBBUFpYU2hiMW5PU2F0RktHYw==', '2021-05-04', '2021-05-04'),
(13, 'test', 'test', 'test@test.at', 'eyJpdiI6IlRpTFh2b1k2cmUxQkRTUUJGbWkyT3c9PSIsInZhbHVlIjoiVzRjNU52MUQ4dk44RUFJOHJnM3NhZz09IiwibWFjIjoiNGYxOWNlNDdjYzQyYzA0OGJjY2ViOWE0YTIwYzg0ZWIyZTQ2N2RmMTI2N2E0NjhiYjJmZjMxN2FlMWNhZGI1ZiJ9', 'ajdjRkJLOWRuY0plM095VGN3enhkbU5VQ29yQTl5NGYyNGRycGxoYQ==', '2021-05-05', '2021-05-05'),
(14, 'Max', 'Mustermann', 'max@mustermann.xxx', 'eyJpdiI6IndGR1gvTHFkMnFwUnM4ekozU2xaZlE9PSIsInZhbHVlIjoicDhjalRHbWVvQmdNbVE5QTI1ajExdz09IiwibWFjIjoiMjA0MWZkYTI0NDM3NmY0YzczNTUzZjE3MDc3NzU5N2I1NGVjYzY4ZmQzZjllOWY1YTFhMGU2ZTQwNGNmNmZhMyJ9', 'OHRsbmNJOUo3TnRxWk0wOG54eklKeTFrNTlZZjByZVRwQnZpQTVQYQ==', '2021-05-05', '2021-05-05'),
(15, 'Max', 'Mustermann', 'max@mustermann.xxx', 'eyJpdiI6IlNPY2tlVWNlbSs1SHZ6TkF2alRxV2c9PSIsInZhbHVlIjoiKzVXMzRyRUVXd2YvMVgvRW1QbVRXZz09IiwibWFjIjoiZTliZGExMmI3ZTE0YzFiOGNkMTZhM2RhMDVkNDM5MzM5ZWY4YjViOTk1OTRhOGQzN2ExZmE2ZWU1MmEzNzcxMCJ9', 'UHEyZzZDQnBpVmY5UmdYNEZIZ1d3VHdEZGJMOEpnc0U5RU1VZXhGMw==', '2021-05-05', '2021-05-05');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
