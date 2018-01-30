# AppointmentSystem
This project is developer under following environments:
Java 8 , NetBeans IDE 8.2, Apache Tomcat 8.2, MySQL Workbench, JQuery, Bootstraps, Ajax. 

There are two external libraries used:
Gson - to convert Java object into JSON object and which is included in External JAR folder of this project.
mysql-connector-java - to connect Mysql Database from java program and which is included in External JAR folder of this project.

Created as a Java Web application in Netbeans IDE. 
project has followed MVC architecture. 

How to setup MySQL Database?
create database schema using query:-- CREATE SCHEMA `appointment_db`; in MySQL workbench.
I have included sql file inside folder dumps/Dump20180129 named appointment_db_appointment_info.sql that need to be imported from MySQL
Workbench which will creates table. 

Alternatively table can be created with the following query:-


CREATE TABLE `appointment_info` (
  `date_time` datetime NOT NULL,
  `description` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


Inside appointment.util package there is  DbConnection.java class which connects mysql database.

Inside  DbConnection.java class there is a connection string I have specified "root","root" as username and password. That should be same as database username and password.










