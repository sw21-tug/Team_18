-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 09, 2021 at 01:19 PM
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
(12, 'income', 38, 100, '2021-05-19', 'Privat', 'Hardware', 'Keyboard', NULL, '2021-05-19', '2021-05-19'),
(13, 'expense', 0, 300, '2021-05-18', 'private', 'party', 'chips', NULL, '2021-05-19', '2021-05-19'),
(14, 'expense', 0, 4444, '2021-05-17', 'commercial', 'office', 'mobile phones', NULL, '2021-05-19', '2021-05-19'),
(24, 'income', 0, 255, '2021-01-17', 'TU ', 'Mitschrift ', 'Analysis T1', NULL, '2021-05-19', '2021-05-19'),
(25, 'expense', 0, 30, '2021-01-12', 'TU', 'Skript', 'Analysis T1', NULL, '2021-05-19', '2021-05-19'),
(26, 'income', 0, 333, '2021-01-01', 'TU', 'Fest', 'Bierfest', NULL, '2021-05-19', '2021-05-19'),
(27, 'income', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(28, 'expense', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(29, 'income', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(30, 'expense', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(31, 'income', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(32, 'expense', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(33, 'income', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(34, 'expense', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(35, 'income', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(36, 'expense', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(37, 'income', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(38, 'expense', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-02', '2021-06-02'),
(39, 'income', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(40, 'expense', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(41, 'income', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(42, 'expense', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(43, 'income', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(44, 'expense', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(45, 'income', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(46, 'expense', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(47, 'income', 0, 123, '2020-05-31', 'aa', 'bb', 'cc\n\n', NULL, '2021-06-09', '2021-06-09'),
(48, 'income', 0, 21, '1999-05-31', 'aa', 'bb', 'cc', NULL, '2021-06-09', '2021-06-09'),
(49, 'income', 0, 123, '1999-05-31', 'aa', 'bb', 'cc', NULL, '2021-06-09', '2021-06-09'),
(50, 'income', 0, 312, '1999-05-31', 'a', 'b', 'c', NULL, '2021-06-09', '2021-06-09'),
(51, 'income', 0, 2424, '1999-05-31', 'a', 'b', 'c', NULL, '2021-06-09', '2021-06-09'),
(52, 'income', 0, 123, '1999-05-31', 'a', 'b', 'c', NULL, '2021-06-09', '2021-06-09'),
(53, 'income', 0, 234, '1999-05-31', 'a', 'b', 'c', NULL, '2021-06-09', '2021-06-09'),
(54, 'income', 0, 123123, '1999-05-31', 'abab', 'cc', 'dd', NULL, '2021-06-09', '2021-06-09'),
(55, 'income', 0, 3123, '1999-05-31', 'a', 'b', 'c', NULL, '2021-06-09', '2021-06-09'),
(56, 'income', 0, 213324, '1999-05-31', 'aa', 'b', 'c', NULL, '2021-06-09', '2021-06-09'),
(57, 'income', 0, 4124, '1999-05-31', 'aa', 'b', 'c', 'salary,gifts', '2021-06-09', '2021-06-09'),
(58, 'income', 0, 31, '1999-05-31', 'a', 'b', 'c', 'gifts,payback', '2021-06-09', '2021-06-09'),
(59, 'expense', 38, 123, '1999-05-31', 'ah', 'ok', 'c', 'car,groceries,personal hygiene,cleaning products', '2021-06-09', '2021-06-09'),
(60, 'income', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(61, 'expense', 0, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(62, 'income', 0, 1234, '2021-09-01', 'asdf', 'asdf', 'asdf', NULL, '2021-06-09', '2021-06-09'),
(63, 'income', 0, 1234, '2021-10-09', 'asdf', 'asdf', 'sdf', NULL, '2021-06-09', '2021-06-09'),
(64, 'income', 38, 1234, '2021-09-01', 'asdf', 'asdf', 'asdf', NULL, '2021-06-09', '2021-06-09'),
(65, 'expense', 38, 214324, '2021-09-01', 'asdf', 'asdf', 'asdf', NULL, '2021-06-09', '2021-06-09'),
(66, 'income', 38, 1000, '2020-01-01', 'business', 'computer', 'monitor with keyboard', NULL, '2021-06-09', '2021-06-09'),
(67, 'expense', 38, 1000, '2020-01-01', 'Расходы', 'Расходы', 'Расходы', NULL, '2021-06-09', '2021-06-09'),
(68, 'income', 38, 123, '2021-10-01', '国家队的', '分局小弟弟', '与吃饭', NULL, '2021-06-09', '2021-06-09'),
(69, 'income', 38, 1234, '2021-10-11', 'cagg', 'asdf', 'asdf', 'Payback', '2021-06-09', '2021-06-09');

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
(12, 'test', 'testi', 'test@testi.testi', 'eyJpdiI6IllycE5pMmgwNVBpd3BLVWxhMzJzVnc9PSIsInZhbHVlIjoiTU0xUE5DczI1SVZ1WDhaQVF6SEFjUT09IiwibWFjIjoiZjE5ZjQ0OTIxMTE5ZGVjOWFiNDIxOWE2ODczYzZjYjQ0MTk1NzgyNzhkZDUwNTMyNTY1YTEwMTc1NjJlMTJiMSJ9', 'RFVtYkZCR2FoNGtZS1pSaVFvYUdObDBBUFpYU2hiMW5PU2F0RktHYw==', '2021-05-04', '2021-05-04'),
(13, 'test', 'test', 'test@test.at', 'eyJpdiI6IlRpTFh2b1k2cmUxQkRTUUJGbWkyT3c9PSIsInZhbHVlIjoiVzRjNU52MUQ4dk44RUFJOHJnM3NhZz09IiwibWFjIjoiNGYxOWNlNDdjYzQyYzA0OGJjY2ViOWE0YTIwYzg0ZWIyZTQ2N2RmMTI2N2E0NjhiYjJmZjMxN2FlMWNhZGI1ZiJ9', 'ajdjRkJLOWRuY0plM095VGN3enhkbU5VQ29yQTl5NGYyNGRycGxoYQ==', '2021-05-05', '2021-05-05'),
(16, 'Müge', 'Yerli', 'myerli@gmail.com', 'eyJpdiI6IlNLQzJRUy9DMlNnVXlkbm1ka0RlYnc9PSIsInZhbHVlIjoibXVCTm01YjhEYm85ckFUNlhGdktMZz09IiwibWFjIjoiNzRlMGQyOWE5MTA3NTYyZWMzOWU1YjRmNGQ0NzhkYTY4YTQ1NmI1MDIwOWQwNzFiMjkxMWRhMzMxZjQwM2YzNyJ9', 'cmxhZHJUNjZXNmR1ckZLaE5ZWFUwdHhpcjc0UFEyTDg0TlI5RkZ1bw==', '2021-05-06', '2021-05-06'),
(18, 'Müge', 'Yerli', 'yerlimugi@gmail.com', 'eyJpdiI6ImNkTHZhNitkV2gwMk1kbThOMUxoQ0E9PSIsInZhbHVlIjoiWFlQMXY1blZEVTZ4VGdxK2wrS2tldz09IiwibWFjIjoiZGQxOTg1ODFhMDUzYzBmZThlOWI5NmFhNDNlOWIzNDI5MzlmNmM0NWU0NjkwMDZhYWE5ZTAyN2M3ZTk3ODE2YyJ9', 'UllqT25qOFZ6dnR0amJKRFhNQjJCY0g2RWVTQWhDV0tPSTZzR1hpeQ==', '2021-05-06', '2021-05-06'),
(19, 'Jakob', 'Tropper', 'JT@gmail.com', 'eyJpdiI6ImdMd1pOR3liTHJwc2xvNjYxYndhV0E9PSIsInZhbHVlIjoidnRuSjd4K2M4aEdtd1V4U3YxeWl5Zz09IiwibWFjIjoiMjhjMWZhZjJjNzA2YzUyZTZlMzExNzM0ZmE5MjQzZjQ0MGY3MDZhNDI3NWViZGRiZmQ4MGI4ODU4ZGI0MzVjNCJ9', 'RHpmNTBCSmtHbzBuc0g2eDVVTGkzOG9TQWFsaGFoRklLS21oejIzQQ==', '2021-05-12', '2021-05-12'),
(20, 'Max', 'luk', 'max@test.at', 'eyJpdiI6InY4OVpad1FwamduK0VlMWRsRVpxQ2c9PSIsInZhbHVlIjoiWUZEdzBqR3ZIa3ZlU0puelFuME02dz09IiwibWFjIjoiM2VkZGYzNTFiNDBlMTE2MjYzODgwYzY4NGViMTRhYzYxNTUwOWFiOTIyZjk3NjJlOWZlZWQ2N2U3NWI5ZWJhMCJ9', 'c1RoQWZGWUlRS1lxUUhkRlZuTGwwUHlYenlXTllHVVJKRHFDWnBuNA==', '2021-05-12', '2021-05-12'),
(36, 'Kilian', 'Weisl', 'kilian@weisl.cc', 'eyJpdiI6Ik5DeTlwMEMyaUJDMjFhc2ZpTUVKQUE9PSIsInZhbHVlIjoiaUlCT2dzQktDZXRDK00yRUZVYU5GZz09IiwibWFjIjoiYmYwNDkxMzdmNzRhZjhlNDg0MTQ2MzRlNGQ2ZWMwNzU0ZDJmZjFkODAwYWRkMDg3YTgyZDI0YmNkYTMyNDg1NSJ9', 'V21SQmhubUhqN09uOEZrQXQxdHpNckpIaHJ5bXlsaDlZaXN3UDlVUw==', '2021-05-19', '2021-05-19'),
(38, 'Jay', 'Tropper', 'root@root.at', 'eyJpdiI6IkowSUJOZENIeXZZMmZQSFBma0tmZWc9PSIsInZhbHVlIjoiazZXK0xKMTJ5czcwa1ZBMmVOUWxEQT09IiwibWFjIjoiNWE3MDJmNjZhMDVlY2M3MzhlYWY5ZjUzZjk4YmRkY2Y0Mzg5NzlmOWQyNTQzZTFlNTRmYTRjMzQwMzc0Njk0NCJ9', 'R0ljcVgxdGVPb0tSWlFXd1ZYOXdGalBBSmM5emhRNDM4Q2RNWElRRw==', '2021-05-19', '2021-05-19'),
(39, 'Max', 'Mustermann', 'max@mustermann.xxx', 'eyJpdiI6ImpRaXpDQjBvZm44T0h2eUhLUExjU3c9PSIsInZhbHVlIjoicWJ5TjVMQVZVRUJIekJROEErekp5dz09IiwibWFjIjoiMzE3YWY5OWM1OTIxMzFiMWI4OGIzMTNhY2ExYmViYTkwMmVmMWY4ZTIzZmI0YzQxM2MwMjA5MmFkNGM4ODJjOCJ9', 'NEVhc2o5RDFPcEprclFsaXRSelpRWG4yUllmMlRYdlBCaEtjMlZpSw==', '2021-06-09', '2021-06-09'),
(40, 'Max', 'Mustermann', 'max@mustermann.xxx', 'eyJpdiI6IjNxeHNiaXdUSlVSWU1wZVF6enpPcEE9PSIsInZhbHVlIjoibGRUd2NtdDBYaDJIVlZ4NlZBY2JBUT09IiwibWFjIjoiMmNkZjJlODk3OWRlZjYxNTZmYzU1YTE1MDIyNDI4MjdjMDZkY2ZiZjQ4ZDA0MDlhOWU3ZGUzMjRhNzViZjM4NyJ9', 'bmlsVHRlcHduUUNac2xLaHo1R0hXd0dNZEM5YnVHYkNhUFZzRXRFbg==', '2021-06-09', '2021-06-09'),
(41, 'Max', 'Mustermann', 'max@mustermann.xxx', 'eyJpdiI6Imo3T3JWNFVCWW0zc0xZLzhZc0lqZnc9PSIsInZhbHVlIjoiOGlpVDRyZ3ZUMmZ0b3FDbUorc01RUT09IiwibWFjIjoiOWE5NmU3ZjVhY2I0YTY1OGVhNDVlMzQ3ZDExYjA2MjNjZTUzMGVkZDQ2N2ZmZTIzOWU1ODQ0NzI2YzRlZGEyYSJ9', 'c0NMbGdzcXdmdFZyQjdzWFBnaGhOSjluM0kyQ3VWSkE1VkRuaTllSg==', '2021-06-09', '2021-06-09'),
(42, 'Max', 'Mustermann', 'max@mustermann.xxx', 'eyJpdiI6InJ5MzVyaGJUZWhzSDhnaG40NElPQkE9PSIsInZhbHVlIjoiME5FS2VROU9FM2FpWDZyR3FIZko0Zz09IiwibWFjIjoiZjJlNmRkODM4MjM3ZWM4MzVjYWRkMTk4MTI3ODNhNzIxMzY2MTEwNGJiODhkNGQ5ZWZiMjgxMzZlMjY4ZmExZiJ9', 'b0tydzZzNGRjYkZJcm5hRGRIUmNsTlVvUzhFdEpCcnp3YkMxaVJ4Qw==', '2021-06-09', '2021-06-09'),
(43, 'Max', 'Mustermann', 'max@mustermann.xxx', 'eyJpdiI6Ims3QkplRm9mSnp3ckswSUNQYklRT2c9PSIsInZhbHVlIjoibGkyL1RMbWwzMEdOWkdsUmdiWVduQT09IiwibWFjIjoiNzBiYmViMTFmN2JkN2QwMzI4YjJiYmJiOGYwOTEzNGFiNzI3NmRiMzY0YzhkM2M1NzdlZWFkYWVhNzVlZTEyZCJ9', 'a2FYQTBYVmxsQ3N3U1lxTEZ4V05RV0V2bUtwRGlsSHhXSERaaGdTdA==', '2021-06-09', '2021-06-09'),
(44, 'Max', 'Mustermann', 'max@mustermann.xxx', 'eyJpdiI6IllkMk1pdVg5VTlnNXpaQWl5dGhIQUE9PSIsInZhbHVlIjoiK2N1YXBDZ0lINVVTS3JnaVJBK21Pdz09IiwibWFjIjoiZTI3MGE4OWYyMjRhOTU0ZmY2ZmNjYWY5MTE3ZTNjMDgxZGZlMjY3ZWJmMzkwNzU0MDQxZmNhOGVlMDljZGQzNyJ9', 'N2FWYlZKa2lxeUpJOXU4cGh2eHVDN2hGRlN1c2JPQ0tLV3hSMDFJNg==', '2021-06-09', '2021-06-09'),
(45, 'Max', 'Mustermann', 'max@mustermann.xxx', 'eyJpdiI6InNxL2NLZ1Z5QTBnalVHWjZJRVJwTnc9PSIsInZhbHVlIjoiQ3lTeTFvaHd1aUtNN0xnVVZpSUV6dz09IiwibWFjIjoiODRjZTNiZDVjMjg1Nzc2YjY0MTYzNGE5Yzc3ODNhYjhiNWUzM2VkMTA0ZTEyYzRhOWZmODE0NDkyNTM5MmU0ZSJ9', 'NFdGek1zRVVTejFCSW5DOXhrcmVPdUdINjU1bWdZTndjSkxHWTl3cw==', '2021-06-09', '2021-06-09'),
(46, 'Max', 'Mustermann', 'max@mustermann.xxx', 'eyJpdiI6Ii9KcGozTW45QnFmQ2h5Y3oxNEdVN3c9PSIsInZhbHVlIjoiTHR5WDlvSFFQZWJ2eDVsTjJ5a2o4QT09IiwibWFjIjoiM2ZjYWFjOTljZjk2YjRjZDU5Nzc5YmI5ZDRjMWQ4ZmE5MDBkNDNjOTg3ZmY0ZjA0Zjc2NmQ4OWVmNzk0NGU2NyJ9', 'MDZzbUx4TERtYmFvckFIMEtHdnAzOVJoUlFiSEtTbmU0elZjbkgxdA==', '2021-06-09', '2021-06-09');

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
