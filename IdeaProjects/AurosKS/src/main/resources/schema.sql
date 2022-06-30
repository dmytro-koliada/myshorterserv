CREATE DATABASE IF NOT EXISTS `K-PAC` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `K-PAC`;
CREATE TABLE `k_pac_sets` (
                              `id` bigint NOT NULL AUTO_INCREMENT,
                              `titles` varchar(250) NOT NULL,
                              PRIMARY KEY (`id`),
                              UNIQUE KEY `k_pac_sets_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `k_pacs` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `titles` varchar(250) DEFAULT NULL,
                          `descriptions` varchar(2000) NOT NULL,
                          `creationDate` varchar(10) NOT NULL,
                          PRIMARY KEY (`id`),
                          UNIQUE KEY `k_pac_id_uindex` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb3;
CREATE TABLE `k_pac_k_pac_sets` (
                                    `k_pac_id` bigint NOT NULL,
                                    `k_pac_set_id` bigint NOT NULL,
                                    KEY `foreign_kpac_set_idx` (`k_pac_set_id`),
                                    KEY `foreign_kpac_idx` (`k_pac_id`),
                                    CONSTRAINT `foreign_kpac` FOREIGN KEY (`k_pac_id`) REFERENCES `k_pacs` (`id`) ON DELETE CASCADE,
                                    CONSTRAINT `foreign_kpac_set` FOREIGN KEY (`k_pac_set_id`) REFERENCES `k_pac_sets` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;