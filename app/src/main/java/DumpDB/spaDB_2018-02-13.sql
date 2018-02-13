# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.1.30-MariaDB)
# Database: spaDB
# Generation Time: 2018-02-13 14:52:55 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table acquisto
# ------------------------------------------------------------

DROP TABLE IF EXISTS `acquisto`;

CREATE TABLE `acquisto` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `FK_utente` int(11) unsigned DEFAULT NULL,
  `FK_offerta` int(11) unsigned DEFAULT NULL,
  `data` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_utente` (`FK_utente`),
  KEY `FK_offerta` (`FK_offerta`),
  CONSTRAINT `FK_offerta` FOREIGN KEY (`FK_offerta`) REFERENCES `offerta` (`id`),
  CONSTRAINT `FK_utente` FOREIGN KEY (`FK_utente`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



# Dump of table offerta
# ------------------------------------------------------------

DROP TABLE IF EXISTS `offerta`;

CREATE TABLE `offerta` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `dataInizio` varchar(10) DEFAULT NULL,
  `dataFine` varchar(10) DEFAULT NULL,
  `descrizione` varchar(350) DEFAULT NULL,
  `prezzo` varchar(11) DEFAULT NULL,
  `immagine` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `offerta` WRITE;
/*!40000 ALTER TABLE `offerta` DISABLE KEYS */;

INSERT INTO `offerta` (`id`, `nome`, `dataInizio`, `dataFine`, `descrizione`, `prezzo`, `immagine`)
VALUES
	(13,'Sauna di coppia','2018-01-31','2018-06-30','Percorso Hammam di coppia, ideale per condividere con il proprio partner o con una persona amica un momento di relax e cura del proprio benessere. -Kit in dotazione: accappatoio, ciabattine, telo sauna.  -Dotarsi di costume da bagno, eventualmente acquistabile presso la SPA.','65','Functions/immaginiOfferta/sauna.jpg'),
	(14,'Massaggio corpo uomo-donna','2018-02-01','2018-02-28','Dopo una giornata lavorativa un massaggio Ã¨ proprio quello ci vuole. Concediti un massaggio corpo rilassante, decontratturante e tonificante nella nostra SPA. -Durata del massaggio 60â€™','30','Functions/immaginiOfferta/massaggioCorpo.jpg'),
	(15,'Entrata giornaliera piscina interna','2018-01-01','2018-06-30','Lasciati coccolare dalla nostra lussuosaÂ piscina conÂ  acqua calda. Postazioni idromassaggio, geyser, musica subacquea e cromoterapia. Un ampio salotto in acqua per rilassarsi negli appositi angoli idromassaggio e la cromoterapia subacquea, due angoli dedicati con chaiselongue per rilassarsi in acqua calda arricchita di sale.','15','Functions/immaginiOfferta/piscinaSPA.jpg'),
	(16,'Massaggio viso donna','2018-01-01','2018-12-31','Desiderate un trattamento viso che vi regali tutti i benefici di unÂ massaggio antirugheÂ e che, al tempo stesso, sia piacevole come unÂ massaggio rilassante? La risposta ai vostri sogni esiste, ed Ã¨ ilÂ massaggio facciale. Portatore naturale di numerosi benefici al volto, questoÂ massaggio al visoÂ Ã¨ in grado di distendere la pelle dellâ€™ovale.','25','Nessun inserimento'),
	(17,'Massaggio viso uomo','2018-01-01','2018-12-31','Massaggiare il viso fa molto bene alla pelle in tutte le sue funzionalitÃ , con ampi benefici.  Il motivo? Anche nel viso, come nel resto del corpo, ci sono molti muscoli che bisogna allenare per dare un sostegno naturale alla pelle. Anche se sembra incredibile, dopo un mese si notano i miglioramenti, in particolare sulle rughe dâ€™espressione.','20','Functions/immaginiOfferta/visoUomo.jpg');

/*!40000 ALTER TABLE `offerta` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table utente
# ------------------------------------------------------------

DROP TABLE IF EXISTS `utente`;

CREATE TABLE `utente` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cognome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `is_admin` int(11) DEFAULT '0',
  `newsletter` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;

INSERT INTO `utente` (`id`, `nome`, `cognome`, `email`, `username`, `password`, `is_admin`, `newsletter`)
VALUES
	(2,'Vanni','Di Campli','admin@villasalus.it','admin','189bbbb00c5f1fb7fba9ad9285f193d1',1,0),
	(3,'Vanni','Di Campli','user@villasalus.it','user','189bbbb00c5f1fb7fba9ad9285f193d1',0,1);

/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
