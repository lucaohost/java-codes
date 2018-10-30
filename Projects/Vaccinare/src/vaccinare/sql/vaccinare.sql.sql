-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 14-Dez-2017 às 00:52
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aluno_vaccinare`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETECRIANCA` (IN `pid` INT(3))  NO SQL
BEGIN
DELETE FROM criancas where id = pid;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETEVACINA` (IN `pid` INT(5))  NO SQL
BEGIN
DELETE FROM vacinas where id = pid;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `DELETEVACINACAO` (IN `PID` INT(5))  NO SQL
BEGIN
DELETE FROM vacinacoes where id = pid;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERTCRIANCA` (IN `pnome` VARCHAR(100), IN `pidade` INT(2), IN `pSexo` VARCHAR(20), IN `ppartoNatural` BOOLEAN, IN `pnomeMae` VARCHAR(100), IN `petnia` VARCHAR(20))  NO SQL
begin
INSERT INTO criancas (nome,idade,sexo,parto_natural,nome_mae,etnia) VALUES (pnome,pidade,pSexo,ppartoNatural,pnomeMae,petnia);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERTVACINA` (IN `pnumeroLote` BIGINT(10), IN `pnomeVacina` VARCHAR(50), IN `pdataValidade` DATE, IN `pfornecedor` VARCHAR(50))  NO SQL
begin
INSERT INTO vacinas (numero_lote,nome_vacina,data_validade,fornecedor) VALUES (pnumeroLote,pnomeVacina,pdataValidade,pfornecedor);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `INSERTVACINACAO` (IN `pvacinaId` INT(5), IN `pdataAplicacao` DATE, IN `paplicadorId` INT(5), IN `pcriancaId` INT(5))  NO SQL
begin
INSERT INTO vacinacoes (vacina_id, data_aplicacao, aplicador_id, crianca_id) VALUES (pvacinaId,pdataAplicacao,paplicadorId,pcriancaId);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECTATTRIBUTESCRIANCA` (IN `pid` INT(3))  NO SQL
BEGIN
SELECT * FROM criancas WHERE id = pid;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECTATTRIBUTESVACINA` (IN `pid` INT)  NO SQL
BEGIN
SELECT * FROM vacinas WHERE id = pid;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECTATTRIBUTESVACINACAO` (IN `pid` INT(5))  NO SQL
BEGIN
SELECT v.id as vacinacao_id, c.id as crianca_id, vac.id as vacina_id, u.id as user_id, vac.nome_vacina, v.data_aplicacao,
u.login, c.nome FROM vacinacoes v
JOIN criancas c ON v.crianca_id = c.id
JOIN usuarios u ON v.aplicador_id = u.id
JOIN vacinas vac ON v.vacina_id = vac.id
WHERE v.id = pid;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECTCRIANCA` (IN `pnome` VARCHAR(100))  NO SQL
BEGIN
SELECT * FROM criancas WHERE nome LIKE pnome ORDER BY nome ASC ;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECTUSUARIO` (IN `plogin` VARCHAR(100))  NO SQL
BEGIN
SELECT * FROM usuarios WHERE login LIKE plogin;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECTVACINA` (IN `pnomeVacina` VARCHAR(50))  NO SQL
BEGIN
SELECT * FROM vacinas WHERE nome_vacina like pnomeVacina;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `SELECTVACINACOES` (IN `pnome` VARCHAR(100))  NO SQL
BEGIN
SELECT  vacinacoes.id, criancas.nome, usuarios.login FROM vacinacoes JOIN criancas ON vacinacoes.crianca_id = criancas.id JOIN usuarios ON vacinacoes.aplicador_id = usuarios.id WHERE criancas.nome LIKE pnome;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATECRIANCA` (IN `pnome` VARCHAR(100), IN `pidade` INT(2), IN `psexo` VARCHAR(20), IN `pparto_natural` BOOLEAN, IN `pnomeMae` VARCHAR(100), IN `petnia` VARCHAR(20), IN `pid` INT(5))  NO SQL
BEGIN
UPDATE criancas SET nome = pnome, idade = pidade, sexo = psexo, parto_natural = pparto_natural, nome_mae = pnomeMae, etnia = petnia WHERE id = pid;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `UPDATEVACINA` (IN `pnomeVacina` VARCHAR(100), IN `pnumeroLote` BIGINT(10), IN `pdataValidade` DATE, IN `pfornecedor` VARCHAR(100), IN `pid` INT(5))  NO SQL
BEGIN
UPDATE vacinas SET nome_vacina = pnomeVacina, numero_lote = pnumeroLote, data_validade = pdataValidade,  fornecedor = pfornecedor WHERE id = pid;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `criancas`
--

CREATE TABLE `criancas` (
  `id` int(5) NOT NULL,
  `nome` varchar(100) CHARACTER SET latin1 NOT NULL,
  `idade` int(2) NOT NULL,
  `sexo` varchar(20) CHARACTER SET latin1 NOT NULL,
  `parto_natural` tinyint(1) NOT NULL,
  `nome_mae` varchar(100) CHARACTER SET latin1 NOT NULL,
  `etnia` varchar(20) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `criancas`
--

INSERT INTO `criancas` (`id`, `nome`, `idade`, `sexo`, `parto_natural`, `nome_mae`, `etnia`) VALUES
(1, 'Lucas', 7, 'Masculino', 1, 'Neiva', 'Branca');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(5) NOT NULL,
  `login` varchar(100) CHARACTER SET latin1 NOT NULL,
  `senha` varchar(100) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `login`, `senha`) VALUES
(1, 'admin', 'admin'),
(2, 'root', 'root');

-- --------------------------------------------------------

--
-- Estrutura da tabela `vacinacoes`
--

CREATE TABLE `vacinacoes` (
  `id` int(5) NOT NULL,
  `vacina_id` int(5) NOT NULL,
  `data_aplicacao` date NOT NULL,
  `aplicador_id` int(5) NOT NULL,
  `crianca_id` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vacinacoes`
--

INSERT INTO `vacinacoes` (`id`, `vacina_id`, `data_aplicacao`, `aplicador_id`, `crianca_id`) VALUES
(1, 2, '2017-12-13', 1, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vacinas`
--

CREATE TABLE `vacinas` (
  `id` int(5) NOT NULL,
  `numero_lote` bigint(10) NOT NULL,
  `nome_vacina` varchar(50) NOT NULL,
  `data_validade` date NOT NULL,
  `fornecedor` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `vacinas`
--

INSERT INTO `vacinas` (`id`, `numero_lote`, `nome_vacina`, `data_validade`, `fornecedor`) VALUES
(2, 123433, 'Vacina do Mal', '1999-04-27', ''),
(3, 123456, 'Trembolona', '2018-04-27', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `criancas`
--
ALTER TABLE `criancas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vacinacoes`
--
ALTER TABLE `vacinacoes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `vacina_id` (`vacina_id`),
  ADD KEY `aplicador_id` (`aplicador_id`),
  ADD KEY `crianca_id` (`crianca_id`);

--
-- Indexes for table `vacinas`
--
ALTER TABLE `vacinas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `criancas`
--
ALTER TABLE `criancas`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `vacinacoes`
--
ALTER TABLE `vacinacoes`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `vacinas`
--
ALTER TABLE `vacinas`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `vacinacoes`
--
ALTER TABLE `vacinacoes`
  ADD CONSTRAINT `fk_vacinacoes_aplicador_id` FOREIGN KEY (`aplicador_id`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `fk_vacinacoes_vacina_id` FOREIGN KEY (`vacina_id`) REFERENCES `vacinas` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
