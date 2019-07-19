CREATE DATABASE IF NOT EXISTS `j2ee-web`;

USE `j2ee-web`;

DROP TABLE IF EXISTS `j2ee-web`.`alumnos`;
CREATE TABLE `alumnos` (
  `alumno_id` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(45) NOT NULL default '',
  `apellido` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`alumno_id`)
);