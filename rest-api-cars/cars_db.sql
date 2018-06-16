-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 16-Jun-2018 às 18:12
-- Versão do servidor: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cars`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cars`
--

CREATE TABLE `cars` (
  `id` int(10) NOT NULL,
  `car_brand` varchar(40) NOT NULL,
  `car_model` varchar(40) NOT NULL,
  `horsepower` int(11) DEFAULT NULL,
  `car_engine` varchar(50) DEFAULT NULL,
  `fk_users` int(11) NOT NULL COMMENT 'Car ower from users table'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cars`
--

INSERT INTO `cars` (`id`, `car_brand`, `car_model`, `horsepower`, `car_engine`, `fk_users`) VALUES
(1, 'Toyota', 'Corolla', 375, 'GTI', 1),
(2, 'Ford', 'Mustang ', 375, 'V8', 3),
(3, 'Audi', 'A4', 425, 'V6', 4),
(4, 'Mercedes', 'Class E', 450, 'Turbo', 4),
(5, 'Seat', 'Ibiza', 105, '1900', 5),
(6, 'Audi', 'A5', 150, 'Turbo', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(150) NOT NULL,
  `age` int(11) NOT NULL,
  `address` varchar(250) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id`, `name`, `age`, `address`) VALUES
(1, 'Alexandre Marques', 39, 'Rua da Alegria'),
(2, 'Vasco Melo', 35, 'Rua da Felicidade'),
(3, 'Victor Oliveira', 40, 'UPTEC - Pólo tecnológico'),
(4, 'Paula Cristina', 32, 'Travessa da Poesia'),
(5, 'Nelson Silva', 35, 'Rua da Miséria');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
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
-- AUTO_INCREMENT for table `cars`
--
ALTER TABLE `cars`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
