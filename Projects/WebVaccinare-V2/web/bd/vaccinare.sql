-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 13-Set-2018 às 15:57
-- Versão do servidor: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vaccinare`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `crianca`
--

CREATE TABLE `crianca` (
  `id` int(11) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `idade` int(3) NOT NULL,
  `sexo` char(1) NOT NULL,
  `parto` tinyint(1) NOT NULL,
  `etnia` char(1) NOT NULL,
  `nome_mae` varchar(80) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefone` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `crianca`
--

INSERT INTO `crianca` (`id`, `nome`, `idade`, `sexo`, `parto`, `etnia`, `nome_mae`, `email`, `telefone`) VALUES
(2, 'Aninha Lemos2222', 2, 'F', 1, 'N', 'Luiza Lemos2', 'luiz2a@gmail.com', '(51) 34517896'),
(4, 'Juca Bala2', 3, 'F', 0, 'P', 'Laurinha Juca3', 'laura3@gmail.com', '33445563'),
(5, 'Mauricio Covolan Rosito2', 2, 'F', 1, 'P', 'Luiza Lemos Rocha', 'a@a.com', '34553200');

-- --------------------------------------------------------

--
-- Estrutura da tabela `crianca_vacina`
--

CREATE TABLE `crianca_vacina` (
  `id_crianca` int(11) NOT NULL,
  `id_vacina` int(11) NOT NULL,
  `lote` varchar(10) NOT NULL,
  `data` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `crianca_vacina`
--

INSERT INTO `crianca_vacina` (`id_crianca`, `id_vacina`, `lote`, `data`) VALUES
(2, 1, 'AEEEE', '2018-09-13 00:00:00'),
(2, 2, '222', '2018-09-10 00:00:00'),
(4, 2, 'AEEEE', '2018-09-09 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(30) NOT NULL,
  `token` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `nome`, `email`, `senha`, `token`) VALUES
(1, 'Administrador', 'admin@gmail.com', 'nova', ''),
(2, 'Usuário', 'user@gmail.com', 'user', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vacina`
--

CREATE TABLE `vacina` (
  `id` int(11) NOT NULL,
  `nome` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vacina`
--

INSERT INTO `vacina` (`id`, `nome`) VALUES
(1, 'Febre amarela'),
(2, 'Tétano');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `crianca`
--
ALTER TABLE `crianca`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `crianca_vacina`
--
ALTER TABLE `crianca_vacina`
  ADD PRIMARY KEY (`id_crianca`,`id_vacina`),
  ADD KEY `FK_vacina_id` (`id_vacina`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vacina`
--
ALTER TABLE `vacina`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `crianca`
--
ALTER TABLE `crianca`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `vacina`
--
ALTER TABLE `vacina`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `crianca_vacina`
--
ALTER TABLE `crianca_vacina`
  ADD CONSTRAINT `FK_crianca_id` FOREIGN KEY (`id_crianca`) REFERENCES `crianca` (`id`),
  ADD CONSTRAINT `FK_vacina_id` FOREIGN KEY (`id_vacina`) REFERENCES `vacina` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
