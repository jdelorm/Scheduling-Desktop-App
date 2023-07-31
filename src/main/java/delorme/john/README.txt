Title: Desktop Scheduling Application

Purpose: To build a scheduling application using data pulled from a database

Author : John DeLorme

Contact: jdelorm@wgu.edu

Version: 1.3

Date: 7/18/2023

IDE: Intellij 2022.2.1 Community Edition

Java: 8 (build 1.8.0_361-b09)

JDK: 17.0.4.1

MySQL Connector: 8.0.26.jar (I tried the newest version when I first started, but my program wouldn't run until I installed an older version for whatever reason)

How to run program: When starting a fresh project in intellij, there are 3 extra steps I had to perform to get my project to compile correctly.
1) Change the target bytecode to 17(is set to 18 by default). File->Settings->Build, Execution, Deployment->Compiler->Java Compiler->Target Bytecode 17
2) Add the mysql jar library. File->Project Structure-> Libraries->+ new->Java->Desktop->mysql-connector.java.8.0.25->mysql-connector-java.8.0.25.jar
3) Make the language package a directory source file. File->Project Structure->Modules->Sources->src->main->java->delorme->john->launguage. Then mark as directory resource root by highlighting the language package and then clicking the Resource tab then apply then ok.
4) Once program is started, the user will be shown the login scene where the user must input a login and username credentials to access the rest of the program

Additional report: My additional report that I chose to implement, is a text field showing the amount of appointments for the given selection of appointmentType and appointmentMonth so that you can see the program dynamically process the total number of appointments by type and month

Language: I chose French as the language to change the login page and warnings to based off of the users default locale

Lambda #1: Located in the ReportScreenController class at line 290
Lambda #2: Located in the AppointmentUpdateScreenController on line 358 and is used again on line 370