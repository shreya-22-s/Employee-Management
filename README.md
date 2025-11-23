# Employee-Management
🚀 Employee Management System

A complete Java-based desktop application built using Swing UI and MySQL database, designed to manage employee information, attendance, salary, and department details efficiently.
📌 Project Overview

The Employee Management System (EMS) helps organizations digitize and streamline employee-related tasks.
The system allows admins to:

Add, update, and delete employee records

Manage attendance and payroll

View employee lists

Store and retrieve data from MySQL

Automated calculations for salary and leave

This project removes manual paperwork, improves efficiency, and ensures secure storage of employee data.
🛠️ Tech Stack Used
Frontend (UI)

Java Swing (JFrame, JPanel, JTable, JTextField, JButton)

AWT for UI components

Backend

Java (Core + OOPs)

JDBC for database connectivity

Database

MySQL

📂 Project Structure
Employee-Management/
│── src/
│   ├── AddEmployee.java
│   ├── RemoveEmployee.java
│   ├── ViewEmployee.java
│   ├── UpdateEmployee.java
│   ├── SplashScreen.java
│   ├── Home.java
│   ├── Conn.java (DB Connection file)
│── images/
│── README.md

🧩 Key Features
✔️ Employee Management

Add new employees

Edit existing employee details

Delete employee records

View all employees in table format

✔️ Attendance Module

Mark employee attendance

Track presence & absence

Store daily attendance in MySQL

✔️ Payroll System

Auto calculate employee salary

Store salary records

Generate salary slip

✔️ Database Integration

Secure MySQL connectivity using JDBC

Clean modular code for CRUD operations

✔️ User-Friendly Interface

Attractive Swing-based UI

Easy form navigation

Search and filter options

🔧 How to Run the Project
1️⃣ Clone the repository
git clone https://github.com/shreya-22-s/Employee-Management.git

2️⃣ Import into IDE

Open IntelliJ IDEA / Eclipse / NetBeans

Load as a Java project
3️⃣ Setup MySQL Database

Run the following commands in MySQL:
CREATE DATABASE employeemanagement;

USE employeemanagement;

CREATE TABLE employee (
    name VARCHAR(50),
    fname VARCHAR(50),
    age VARCHAR(3),
    dob VARCHAR(20),
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(50),
    education VARCHAR(30),
    designation VARCHAR(30),
    aadhar VARCHAR(12),
    empId VARCHAR(10)
);
4️⃣ Update database credentials in Conn.java
String url = "jdbc:mysql://localhost:3306/employeemanagement";
String user = "root";
String password = "your_password";
5️⃣ Run the application

Run the SplashScreen.java or Home.java file.
🧑‍💻 Author
Shreya Singh
GitHub: https://github.com/shreya-22-s

⭐ Support
If you like this project, don’t forget to ⭐ star the repository!
