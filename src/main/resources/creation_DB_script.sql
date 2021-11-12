-- --------------------------------------------------------
-- Hôte :                        127.0.0.1
-- Version du serveur:           10.6.3-MariaDB-1:10.6.3+maria~focal - mariadb.org binary distribution
-- SE du serveur:                debian-linux-gnu
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Export de la structure de la base pour default
CREATE DATABASE IF NOT EXISTS `nabilDB` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `nabilDB`;

-- Export de la structure de la table default. hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Export de données de la table default.hibernate_sequence : ~1 rows (environ)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT IGNORE INTO `hibernate_sequence` (`next_val`) VALUES
	(2);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Export de la structure de la table default. Message
CREATE TABLE IF NOT EXISTS `Message` (
  `id` bigint(20) NOT NULL,
  `creationDate` datetime(6) DEFAULT NULL,
  `texte` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfkj0bfandt6mbdmw5dim9q7nl` (`user_id`),
  CONSTRAINT `FKfkj0bfandt6mbdmw5dim9q7nl` FOREIGN KEY (`user_id`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Export de données de la table default.Message : ~1 rows (environ)
/*!40000 ALTER TABLE `Message` DISABLE KEYS */;
INSERT IGNORE INTO `Message` (`id`, `creationDate`, `texte`, `user_id`) VALUES
	(1, '2021-08-30 18:29:48.000000', 'Welcome to your local application', 1);
/*!40000 ALTER TABLE `Message` ENABLE KEYS */;

-- Export de la structure de la table default. User
CREATE TABLE IF NOT EXISTS `User` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Export de données de la table default.User : ~1 rows (environ)
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT IGNORE INTO `User` (`id`, `name`) VALUES
	(1, 'nabil');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
