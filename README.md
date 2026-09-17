# Budget Planner

A simple command-line Budget Planner application developed in Java.

The application allows users to record income and expenses view transactions, search and delete expenses calculate the remaining balance set a budget limit with alerts and save/load budget data using a text file.

# Features

Add income
Add expenses
Categorize expenses
View all transactions
View expenses
Search expenses
expenses
Calculate total income
Calculate total expenses
Calculate remaining balance
Set a monthly budget limit
Background thread that warns when 80% of the budget is used and alerts when its exceeded
Save data to a text file
Load previously saved data
Handle invalid amount and input errors

# Technologies Used

### Java
### Object-Oriented Programming (OOP)
### ArrayList
### Inheritance
### Polymorphism
### Enum
### Exception Handling
### Multithreading
### File I/O
### BufferedReader
### BufferedWriter
### Command-Line Interface

# Project Structure

```text
budget-planner/
├── Main.java
├── BudgetPlanner.java
├── Transaction.java
├── Income.java
├── Expense.java
├── Category.java
├── BudgetCalculator.java
├── InvalidAmountException.java
├── FileManager.java
├── BudgetAlertThread.java
├── statement.md
├── docs/
│   ├── architecture.md
│   ├── use-case-diagram.md
│   ├── class-diagram.md
│   ├── sequence-diagram.md
│   ├── workflow-diagram.md
│   └── storage-design.md
├── data/
│   └── budget.txt
├── README.md
└── .gitignore
```

# Class Description

## Main.java

Contains the method and command-line menu. It takes input from the user. Calls the required operations.

## BudgetPlanner.java

Manages the collection of transactions using ArrayList<Transaction>. It provides operations such as adding, viewing, searching and deleting transactions. Holds the current budget limit.

## Transaction.java

The base class for transactions. It stores transaction information such as description and amount.

## Income.java

Extends the Transaction class. Represents an income transaction.
# Project Structure

```text
budget-planner/
├── Main.java
├── BudgetPlanner.java
├── Transaction.java
├── Income.java
├── Expense.java
├── Category.java
├── BudgetCalculator.java
├── InvalidAmountException.java
├── FileManager.java
├── BudgetAlertThread.java
├── statement.md
├── docs/
│   ├── architecture.md
│   ├── use-case-diagram.md
│   ├── class-diagram.md
│   ├── sequence-diagram.md
│   ├── workflow-diagram.md
│   └── storage-design.md
├── data/
│   └── budget.txt
├── README.md
└── .gitignore
```

## Expense.java

Extends the Transaction. Represents an expense. It also stores the expense category.

## Category.java

An enum containing the expense categories: Food, Travel, Education, Shopping, Bills, Entertainment, Health and Other.

## BudgetCalculator.java

Contains static methods for calculating total income, total expenses and remaining balance.

## InvalidAmountException.java

A custom checked exception used when the user enters an amount that's zero or negative.

## FileManager.java

Handles saving transactions to and loading transactions from the data/budget.txt text file.

## BudgetAlertThread.java

Runs as a background daemon thread alongside the program. Every 10 seconds it checks expenses against the configured budget limit and prints a warning at 80% usage and an alert at 100% or more.

# How to Run the Project

## Step 1: Install Java

Make sure the Java JDK is installed on your computer.

Check the Java version using:

```bash
java -version
```

Check the Java compiler using:

```bash
javac -version
```

## Step 2: Open the Project Folder

Open a terminal or command prompt and navigate to the project folder.

```bash
cd budget-planner
```

## Step 3: Compile the Java Files

Compile all Java source files using:

```bash
javac *.java
```

## Step 4: Run the Application

Run the program using:

```bash
java Main
```

# Menu Options

When the application starts the following menu is displayed:

```text
===== BUDGET PLANNER =====

1. Add Income

2. Add Expense

3. View All Transactions

4. View Expenses

5. Search Expense

6. Delete Expense

7. Show Budget Summary

8. Set Budget Limit

9. Save Data

10. Load Data

11. Exit
```

Select an option by entering its number.

# Data Storage

Budget data is stored in:

```text
data/budget.txt
```

The application creates the data folder automatically if it doesn't already exist. The saved file contains transaction information that can be loaded again using the Load Data option.

See docs/storage-design.md for the file format.

# Example

Example transactions:

Income: Scholarship

Amount: Rs. 5000

Expense: Food

Amount: Rs. 500

Category: FOOD

The budget summary will display:

```text
Total Income: Rs. 5000.0

Total Expense: Rs. 500.0

Remaining Balance: Rs. 4500.0
```

# Design Documentation

See the docs/ folder for:

architecture.md. System architecture diagram

use-case-diagram.md. Use case diagram

class diagram

sequence-diagram.md. Sequence diagram (add expense + budget alert flow)

workflow-diagram.md. CLI menu process flow

storage-design.md. Text-file storage format (in place of an ER diagram since no database is used)

These render as diagrams automatically when viewed on GitHub.

# OOP Concepts Used

The project demonstrates Java Object-Oriented Programming concepts.

## Encapsulation

Transaction data is kept private. Accessed through methods such as getters.

## Inheritance

Income and Expense inherit properties and methods from the Transaction class.

## Polymorphism

The application stores both Income and Expense objects in an ArrayList<Transaction> and uses method overriding for displayTransaction().

## Abstraction of Responsibilities

classes are responsible for different tasks such as transaction management, calculation, file handling and background monitoring.

# Exception Handling

The application handles user input using exception handling.

A custom InvalidAmountException is used when an income or expense amount is less than or equal to zero.

NumberFormatException is also handled when the user enters a numeric value.

# Testing

Manual testing was performed by running the compiled application and exercising each menu option: adding invalid (zero/negative) amounts, viewing and searching transactions deleting a transaction setting a budget limit below existing spend to confirm the alert thread prints a warning and saving then reloading data in a fresh run to confirm persistence.

# Limitations

The application is command-line based.

Data is stored in a text file of a database.

Transaction descriptions should not contain commas because comma-separated data is used for file storage.

# Future Scope

The project can be extended by adding:

Date-wise transaction tracking

Monthly expense reports

Graphical user interface

Database storage using JDBC

Exporting reports

detailed financial analysis

# Author

SANSKRUTI PRASHANT CHANEKAR 25BAI10603

Developed as a Java project for the Programming, in Java course.
