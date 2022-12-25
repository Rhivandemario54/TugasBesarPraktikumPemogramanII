-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 25, 2022 at 09:18 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.0.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pp2_pesawat_tubes`
--

-- --------------------------------------------------------

--
-- Table structure for table `jumlah`
--

CREATE TABLE `jumlah` (
  `id` varchar(255) NOT NULL,
  `jumlahpen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jumlah`
--

INSERT INTO `jumlah` (`id`, `jumlahpen`) VALUES
('3e73735a-c688-4ef2-bb86-f2122ed9970a', '23'),
('4cea54bd-7f94-4c94-b908-93fa19ccf9de', '10');

-- --------------------------------------------------------

--
-- Table structure for table `pendaftaran`
--

CREATE TABLE `pendaftaran` (
  `id` varchar(255) NOT NULL,
  `jumlahpen_id` varchar(255) DEFAULT NULL,
  `tujuanpen_id` varchar(255) DEFAULT NULL,
  `namauser` varchar(255) DEFAULT NULL,
  `tgl_penerbangan` varchar(255) DEFAULT NULL,
  `kelaspen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `tujuan`
--

CREATE TABLE `tujuan` (
  `id` varchar(255) NOT NULL,
  `tujuanpen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tujuan`
--

INSERT INTO `tujuan` (`id`, `tujuanpen`) VALUES
('1c71ea62-5d17-48e0-ac32-3907e8e45594', 'Jakarta'),
('2ba5e961-aa27-4779-8d0f-3df3b99d838b', 'Bandung'),
('a1b25271-257f-4776-8577-dcc4d4624bdb', 'Surabaya'),
('a9abb110-5105-4504-b67f-14b41ecab3be', NULL),
('be0d3c62-7558-4fae-bcdb-3b2b830d8cfa', NULL),
('cbb90b9c-056d-4d76-8f49-c8ba03ac8184', NULL),
('f9986ca8-b10e-43bb-b5d0-379714c7f340', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jumlah`
--
ALTER TABLE `jumlah`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pendaftaran`
--
ALTER TABLE `pendaftaran`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tujuan`
--
ALTER TABLE `tujuan`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
