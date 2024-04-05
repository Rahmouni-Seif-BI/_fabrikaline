-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 25 Mars 2024 à 21:44
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `sbc`
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
-- Structure de la table `attachment`
--

CREATE TABLE `attachment` (
  `id` bigint(20) NOT NULL,
  `attached_file` longtext,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `extension` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `attachmentcategory_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `attachment_category`
--

CREATE TABLE `attachment_category` (
  `id` bigint(20) NOT NULL,
  `code` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `city`
--

CREATE TABLE `city` (
  `id` bigint(20) NOT NULL,
  `code` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `country_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `claim`
--

CREATE TABLE `claim` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `complaintcategory_id` bigint(20) NOT NULL,
  `complainttype_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `complaint_category`
--

CREATE TABLE `complaint_category` (
  `id` bigint(20) NOT NULL,
  `code` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `complaint_type`
--

CREATE TABLE `complaint_type` (
  `id` bigint(20) NOT NULL,
  `code` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `complaintcategory_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `country`
--

CREATE TABLE `country` (
  `id` bigint(20) NOT NULL,
  `code` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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
-- Structure de la table `item`
--

CREATE TABLE `item` (
  `id` bigint(20) NOT NULL,
  `availability` bit(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `itemcategory_id` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `item_category`
--

CREATE TABLE `item_category` (
  `id` bigint(20) NOT NULL,
  `code` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `order_line`
--

CREATE TABLE `order_line` (
  `id` bigint(20) NOT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `total_price` double NOT NULL,
  `item_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `order_status`
--

CREATE TABLE `order_status` (
  `id` bigint(20) NOT NULL,
  `code` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

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

-- --------------------------------------------------------

--
-- Structure de la table `test`
--

CREATE TABLE `test` (
  `montant` decimal(10,0) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `test`
--

INSERT INTO `test` (`montant`, `id`) VALUES
('10', 1);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `age` varchar(255) DEFAULT NULL,
  `contact_number` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `zipcode` bigint(20) DEFAULT NULL,
  `city_id` bigint(20) NOT NULL,
  `country_id` bigint(20) NOT NULL,
  `usergender_id` bigint(20) NOT NULL,
  `userstatus_id` bigint(20) NOT NULL,
  `usertype_id` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user_gender`
--

CREATE TABLE `user_gender` (
  `id` bigint(20) NOT NULL,
  `code` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user_status`
--

CREATE TABLE `user_status` (
  `id` bigint(20) NOT NULL,
  `code` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user_type`
--

CREATE TABLE `user_type` (
  `id` bigint(20) NOT NULL,
  `code` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Index pour les tables exportées
--

--
-- Index pour la table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `attachment`
--
ALTER TABLE `attachment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKij0pty0vudjknvcaqw32r80ry` (`attachmentcategory_id`);

--
-- Index pour la table `attachment_category`
--
ALTER TABLE `attachment_category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrpd7j1p7yxr784adkx4pyepba` (`country_id`);

--
-- Index pour la table `claim`
--
ALTER TABLE `claim`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKemepdpbmnc1cobo5ed2dgrme9` (`complaintcategory_id`),
  ADD KEY `FKo3x4ni8ntmkht8vy8a85axbb1` (`complainttype_id`),
  ADD KEY `FK518jnubg07iv569n9i61nvfmy` (`user_id`);

--
-- Index pour la table `complaint_category`
--
ALTER TABLE `complaint_category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `complaint_type`
--
ALTER TABLE `complaint_type`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKeh1hbroksdbltdcq3lbhmqpnt` (`complaintcategory_id`);

--
-- Index pour la table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`);

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
-- Index pour la table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK8baqvq4535sfmo6irqkap52kr` (`itemcategory_id`);

--
-- Index pour la table `item_category`
--
ALTER TABLE `item_category`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `order_line`
--
ALTER TABLE `order_line`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK5jxg54d3o4jelac6w147o2p8p` (`item_id`);

--
-- Index pour la table `order_status`
--
ALTER TABLE `order_status`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `purpose`
--
ALTER TABLE `purpose`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `spending`
--
ALTER TABLE `spending`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKjik2jv7tn58j0nega59cdot7j` (`account_id`),
  ADD KEY `FK2iba0h4ea6mntn6e092801ow4` (`credit_status_id`),
  ADD KEY `FK3a98vob97nij32bkajajvwosr` (`purpose_id`);

--
-- Index pour la table `test`
--
ALTER TABLE `test`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK29eqyw0gxw5r4f1ommy11nd9i` (`city_id`),
  ADD KEY `FKge8lxibk9q3wf206s600otk61` (`country_id`),
  ADD KEY `FKqqu6aue32xrm62r9fvjb80h9v` (`usergender_id`),
  ADD KEY `FK6vt2tdeu93ggkyfv0ufqibpht` (`userstatus_id`),
  ADD KEY `FK4nc7vu5h8yfxgq1sxpf8n96ic` (`usertype_id`);

--
-- Index pour la table `user_gender`
--
ALTER TABLE `user_gender`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_status`
--
ALTER TABLE `user_status`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user_type`
--
ALTER TABLE `user_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `account`
--
ALTER TABLE `account`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `attachment`
--
ALTER TABLE `attachment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `attachment_category`
--
ALTER TABLE `attachment_category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `city`
--
ALTER TABLE `city`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `claim`
--
ALTER TABLE `claim`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `complaint_category`
--
ALTER TABLE `complaint_category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `complaint_type`
--
ALTER TABLE `complaint_type`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `country`
--
ALTER TABLE `country`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
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
-- AUTO_INCREMENT pour la table `item`
--
ALTER TABLE `item`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `item_category`
--
ALTER TABLE `item_category`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `order_line`
--
ALTER TABLE `order_line`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `order_status`
--
ALTER TABLE `order_status`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `purpose`
--
ALTER TABLE `purpose`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `spending`
--
ALTER TABLE `spending`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT pour la table `test`
--
ALTER TABLE `test`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user_gender`
--
ALTER TABLE `user_gender`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user_status`
--
ALTER TABLE `user_status`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `user_type`
--
ALTER TABLE `user_type`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
