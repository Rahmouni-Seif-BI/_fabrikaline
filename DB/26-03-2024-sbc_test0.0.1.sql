-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 26 Mars 2024 à 23:51
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `sbc_test`
--

-- --------------------------------------------------------

--
-- Structure de la table `account`
--

CREATE TABLE `account` (
  `id` bigint(20) NOT NULL,
  `amount_rest` double NOT NULL,
  `amountbalance` double NOT NULL,
  `amountconsumed` double NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `account`
--

INSERT INTO `account` (`id`, `amount_rest`, `amountbalance`, `amountconsumed`, `code`, `description`, `owner`) VALUES
(1, 0, 500, 0, 'IN', 'Investisement', 'Seif RAHMOUNI'),
(2, 0, 450, 0, 'SP', 'Spending', 'Seif RAHMOUNI'),
(3, 0, 450, 0, 'OB', 'Obligatoire', 'Seif RAHMOUNI');

-- --------------------------------------------------------

--
-- Structure de la table `credit_entity`
--

CREATE TABLE `credit_entity` (
  `id` bigint(20) NOT NULL,
  `amount` double NOT NULL,
  `end_date` date DEFAULT NULL,
  `interest_rate` double NOT NULL,
  `start_date` date DEFAULT NULL,
  `creditor_account_id` bigint(20) DEFAULT NULL,
  `debtor_account_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `credit_entity`
--

INSERT INTO `credit_entity` (`id`, `amount`, `end_date`, `interest_rate`, `start_date`, `creditor_account_id`, `debtor_account_id`) VALUES
(1, 555, NULL, 5, NULL, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `credit_status`
--

CREATE TABLE `credit_status` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `credit_status`
--

INSERT INTO `credit_status` (`id`, `code`, `description`) VALUES
(1, 'Annuler', 'Annuler'),
(2, 'Bech  nekhou', 'Bech  nekhou'),
(3, 'Khdhit', 'Khdhit');

-- --------------------------------------------------------

--
-- Structure de la table `deposite`
--

CREATE TABLE `deposite` (
  `id` bigint(20) NOT NULL,
  `action_date` datetime DEFAULT NULL,
  `amount_to_deposite` float NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `deposite`
--

INSERT INTO `deposite` (`id`, `action_date`, `amount_to_deposite`, `code`, `notes`, `account_id`) VALUES
(8, '2024-03-24 00:23:29', 500, '684', NULL, 1),
(7, '2024-03-24 00:22:58', 500, '563', NULL, 1),
(6, '2024-03-24 00:22:45', 10, '883', NULL, 1),
(9, '2024-03-24 00:23:42', 500, '806', NULL, 1),
(10, '2024-03-24 00:24:03', 500, '8', NULL, 1),
(11, '2024-03-24 00:25:02', 400, '220', NULL, 1),
(12, '2024-03-24 00:26:56', 500, '168', NULL, 1),
(13, '2024-03-24 00:27:18', 650, '247', NULL, 1),
(14, '2024-03-24 00:29:38', 300, '57', NULL, 1),
(15, '2024-03-24 00:29:46', 800, '188', NULL, 1),
(16, '2024-03-24 00:30:01', 350, '264', NULL, 1),
(17, '2024-03-24 00:30:14', 500, '921', NULL, 1),
(18, '2024-03-24 00:31:04', 1400, '369', NULL, 1),
(19, '2024-03-24 00:31:24', 300, '646', NULL, 1),
(20, '2024-03-24 00:31:34', 500, '11', NULL, 1),
(21, '2024-03-24 00:31:44', 350, '472', NULL, 1),
(22, '2024-03-24 00:32:19', 800, '642', NULL, 1),
(23, '2024-03-24 00:32:31', 750, '546', NULL, 1),
(24, '2024-03-24 00:32:38', 500, '473', NULL, 1),
(25, '2024-03-24 00:41:23', 259.236, '823', 'INTERET (FOR DONATION) ', 1),
(26, '2024-03-01 01:02:15', 450, '859', '01/03/2024 ', 2),
(27, '2024-03-01 01:02:29', 450, '324', '01/03/2024', 3);

-- --------------------------------------------------------

--
-- Structure de la table `purpose`
--

CREATE TABLE `purpose` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `default_price` double NOT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `purpose`
--

INSERT INTO `purpose` (`id`, `code`, `default_price`, `description`) VALUES
(1, 'CO', 2, 'Coffe'),
(2, 'HJ', 6, 'Hjema'),
(3, 'Au', 0, 'Autres'),
(4, 'AF25', 22.5, 'Achat forfait 25 GO'),
(5, 'LV', 20, 'Liquide vape'),
(6, 'MA', 0, 'Masrouf'),
(7, 'ES', 10, 'Essence voiture'),
(8, 'CT', 1.25, 'Charge mobile 1 TD'),
(9, 'CT', 5.7, 'Charge mobile 5 TD');

-- --------------------------------------------------------

--
-- Structure de la table `repayment_entity`
--

CREATE TABLE `repayment_entity` (
  `id` bigint(20) NOT NULL,
  `amount_repaid` double NOT NULL,
  `repayment_date` date DEFAULT NULL,
  `creditor_account_id` bigint(20) DEFAULT NULL,
  `debtor_account_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `spending`
--

CREATE TABLE `spending` (
  `id` bigint(20) NOT NULL,
  `action_date` datetime DEFAULT NULL,
  `amount_to_spend` float NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `account_id` bigint(20) DEFAULT NULL,
  `credit_status_id` bigint(20) DEFAULT NULL,
  `purpose_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `spending`
--

INSERT INTO `spending` (`id`, `action_date`, `amount_to_spend`, `code`, `notes`, `account_id`, `credit_status_id`, `purpose_id`) VALUES
(5, '2024-03-24 00:35:48', 2000, '651', 'jbedet 2000 TND lel moteur mte3 karhba w raja3t menhom 1400 TND', 1, 3, 3),
(4, '2024-03-24 00:34:55', 110, '698', 'awel mara jbedet mn nabeul masrouf', 1, 3, 3),
(6, '2024-03-24 00:38:21', 400, '236', 'Tasli7 avant train karhba (300dt + 60dt main d\'oeuvre)', 1, 3, 3),
(7, '2024-03-24 01:09:15', 160, '969', 'total essence lel karhba', 3, 3, 7),
(8, '2024-03-24 01:14:28', 22.5, '747', NULL, 3, 3, 4),
(9, '2024-03-24 01:16:46', 90, '281', 'Achat Karcher lavage', 3, 3, 3),
(10, '2024-03-25 21:55:21', 30, '43', NULL, 3, 3, 7),
(11, '2024-03-25 21:59:04', 20, '141', NULL, 2, 3, 5),
(12, '2024-03-25 21:59:25', 20, '358', NULL, 2, 3, 5),
(13, '2024-03-25 22:00:23', 90, '484', NULL, 2, 3, 6),
(14, '2024-03-25 22:02:13', 70, '904', NULL, 2, 3, 6),
(15, '2024-03-25 22:02:51', 22.5, '986', NULL, 2, 3, 4),
(16, '2024-03-25 22:03:27', 200, '74', 'matsarfouch  kol  mazel menhom f kachmir', 2, 3, 6),
(17, '2024-03-25 22:07:06', 5.7, '700', 'sabit 5dt lel puce orange', 2, 3, 9),
(18, '2024-03-25 22:10:28', 27.02, '723', 'Chrit champoing + Gran d\'or + Salami chat + perfum', 2, 3, 6);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `credit_entity`
--
ALTER TABLE `credit_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK3f2mk5cv5g60qys58jmjg9dnq` (`creditor_account_id`),
  ADD KEY `FK3ih8yrdwkihoj10smnnecnsou` (`debtor_account_id`);

--
-- Index pour la table `credit_status`
--
ALTER TABLE `credit_status`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `deposite`
--
ALTER TABLE `deposite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmgeu16sxvxd0kxmmslisfl49i` (`account_id`);

--
-- Index pour la table `purpose`
--
ALTER TABLE `purpose`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `repayment_entity`
--
ALTER TABLE `repayment_entity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK53ve4r1r9ibq03em5unym2oyt` (`creditor_account_id`),
  ADD KEY `FK70gp3rj3n5r6p8k5sl0te4kij` (`debtor_account_id`);

--
-- Index pour la table `spending`
--
ALTER TABLE `spending`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjik2jv7tn58j0nega59cdot7j` (`account_id`),
  ADD KEY `FK2iba0h4ea6mntn6e092801ow4` (`credit_status_id`),
  ADD KEY `FK3a98vob97nij32bkajajvwosr` (`purpose_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `account`
--
ALTER TABLE `account`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `credit_entity`
--
ALTER TABLE `credit_entity`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `credit_status`
--
ALTER TABLE `credit_status`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `deposite`
--
ALTER TABLE `deposite`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT pour la table `purpose`
--
ALTER TABLE `purpose`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `repayment_entity`
--
ALTER TABLE `repayment_entity`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `spending`
--
ALTER TABLE `spending`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
