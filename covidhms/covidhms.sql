/*
SQLyog Community Edition- MySQL GUI v8.05 
MySQL - 5.1.42-community : Database - programmingtest
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`covidhms` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `covidhms`;
show tables;
select * from user;
select * from vaccine;
show columns from vaccine;


ALTER USER 'root'@'localhost' IDENTIFIED BY 'parimal@02';