-- phpMyAdmin SQL Dump
-- version 3.3.9.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Jun 13, 2012 as 02:36 PM
-- Versão do Servidor: 5.5.17
-- Versão do PHP: 5.3.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `na_hora`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `comentario`
--

CREATE TABLE IF NOT EXISTS `comentario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) DEFAULT NULL,
  `texto` text,
  `id_novidade` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Extraindo dados da tabela `comentario`
--

INSERT INTO `comentario` (`id`, `nome`, `texto`, `id_novidade`) VALUES
(5, 'Kaléu.!', 'meu primeiro comentário na aula.', 1),
(6, 'João', 'Meu segundo comentário', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `informacoes`
--

CREATE TABLE IF NOT EXISTS `informacoes` (
  `titulo` int(11) NOT NULL AUTO_INCREMENT,
  `texto` text NOT NULL,
  `resumo` varchar(256) NOT NULL,
  `imagem` varchar(100) DEFAULT NULL,
  `link` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `informacoes`
--


-- --------------------------------------------------------

--
-- Estrutura da tabela `novidades`
--

CREATE TABLE IF NOT EXISTS `novidades` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(60) NOT NULL,
  `texto` text NOT NULL,
  `resumo` varchar(256) NOT NULL,
  `data` date NOT NULL,
  `link` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Extraindo dados da tabela `novidades`
--

INSERT INTO `novidades` (`id`, `titulo`, `texto`, `resumo`, `data`, `link`) VALUES
(1, 'Material Prova Amanhã', 'Olá pessoal. Segue em anexo o material de prova que devem estudar para amanhã.\r\n\r\nOs tópicos principais são:\r\n\r\n* Tópico 1\r\n* Tópico 2\r\n* Tópico 3\r\n\r\nBoa sorte e..até breve.', 'Vejam aqui o material e tópicos que devem ser estudados para a prova de amanhã', '2012-06-05', 'www.caelum.com.br'),
(2, 'Avaliação disciplina', 'Olá pessoal, gostaria que me ajudassem a melhorar a disciplina para os próximos semestres.\r\n\r\nDeixe nos comentários sua avaliação sobre o nosso trabalho.', 'ajude a melhorar a disciplina com a sua avaliação', '2012-06-05', NULL),
(3, 'Título da novidade', 'null', 'esta novidade blá blá', '2012-06-05', 'http://www.google.com.br');
