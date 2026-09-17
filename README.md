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

## Technologies Used

### Programming Language

* **Java** — Used to develop the complete Budget Planner application.

### Core Java Concepts

* **Object-Oriented Programming (OOP)** — Classes, objects, encapsulation, inheritance, and polymorphism.
* **ArrayList** — Used to store income and expense transactions.
* **Enum** — Used for predefined expense categories.
* **Exception Handling** — Used for invalid amounts and invalid numeric input.
* **Multithreading** — Used for background budget monitoring and alerts.

### File Handling

* **Java File I/O** — Used to save and load transaction data.
* **BufferedReader** — Used to read saved transaction data from `data/budget.txt`.
* **BufferedWriter** — Used to write transaction data to `data/budget.txt`.

### User Interface

* **Command-Line Interface (CLI)** — Used to interact with the application through the terminal.

### Development Tools

* **JDK (Java Development Kit)** — Used to compile and run the Java source code.
* **Git & GitHub** — Used for source-code version control and project submission.
``
# Java Concepts Used

### Java

Java is the programming language used for the entire Budget Planner application. The program is built using classes such as `Main` `BudgetPlanner` `Transaction` `Income` `Expense` `BudgetCalculator` `FileManager` and `BudgetAlertThread`.

The application uses Java for receiving user input, processing transactions performing calculations handling files managing errors and running background tasks like budget monitoring.

---
### Object-Oriented Programming (OOP)

The project follows object-oriented programming principles by organizing the code into classes based on what they do.

For example:

* The `Transaction` class holds data like description and amount.

* The `Income` and `Expense` classes represent types of transactions.

* The `BudgetPlanner` class manages the list of transactions and the budget limit.

* The `BudgetCalculator` class handles income, expense and balance calculations.

* The `FileManager` class takes care of saving and loading data.

This design keeps the code clean. Makes it easier for the classes to work together.

---
### ArrayList

An `ArrayList` is used in the `BudgetPlanner` class to store all transactions.

```java

ArrayList<Transaction> transactions;

```

The list is created in the constructor like this:

```java

transactions = new ArrayList<>();

```

When a new transaction is added it is stored using:

```java

transactions.add(transaction);

```

This same list is used when viewing, searching, deleting or calculating transactions.

Using `ArrayList<Transaction>` allows both `Income` and `Expense` objects to be stored in the collection.

---

### Inheritance

Inheritance is used to build a hierarchy between the `Transaction` class and its specialized versions.

The `Income` class extends `Transaction`:

```java

public class Income extends Transaction

```

Similarly the `Expense` class extends `Transaction`:

```java

public class Expense extends Transaction

```

The shared properties like `description` and `amount` are defined once in `Transaction`. The `Income` and `Expense` classes add their specific details.

This avoids writing the code multiple times.

---

### Polymorphism

Polymorphism is used by storing types of transactions in a single list:

```java

ArrayList<Transaction>

```

Both `Income` and `Expense` objects can be added to this list as if they were `Transaction` objects.

For example:

```java

Income(description amount));

```

and:

```java

transactions.add(new Expense(description, amount, category));

```

The `displayTransaction()` method is overridden in both `Income` and `Expense`.

When the `BudgetPlanner` calls:

```java

transaction.displayTransaction();

```

the version of the method runs based on the actual object type.

The `BudgetCalculator` also checks the type of transaction using:

```java

if (transaction instanceof Income)

```

or:

```java

if (transaction instanceof Expense)

```

---

### Encapsulation

Encapsulation is used to keep a class’s data private and allow access through methods.

For example the `Transaction` class defines:

```

private String description;

private double amount;

```

These fields cannot be accessed directly from other classes. Instead they are accessed through methods like:

```java

public String getDescription()

double getAmount()

```

Similarly the `BudgetPlanner` class keeps its transaction list and budget limit private:

```java

private ArrayList<Transaction> transactions;

private double budgetLimit;

```

Getter and setter methods are used to read or change these values.

This was one of the concepts that took some time to understand during development because it separates the data from the operations that work on that data.

---

### Enum

An enum is used to define the list of expense categories.

The `Category` class includes:

```java

public enum Category {

FOOD,

TRAVEL,

EDUCATION,

SHOPPING,

BILLS,

ENTERTAINMENT,

HEALTH,

OTHER

}

```

When an expense is added the user picks one of these options.

The program also uses:

```java

Category.values()

```

to show the categories to the user.

Using an enum makes sure only valid categories are used and prevents typos or invalid entries.

---

### Exception Handling

Exception handling is used to deal with user input and avoid crashes.

The project includes a custom exception:

```java

public class InvalidAmountException extends Exception

```

It is thrown when an amount is less than or equal to zero.

For example:

```java

if (amount <= 0) {

throw InvalidAmountException("Amount must be greater than zero.");

}

```

In `Main.java` the exception is caught using:

```java

catch (InvalidAmountException e)

```

The program also handles `NumberFormatException` when the input cannot be converted into a number.

There is also a Exception` catch for any other unexpected issues.

---

### Multithreading

Multithreading is used for budget monitoring.

A class called:

```java

public class BudgetAlertThread extends Thread

```

runs in the background while the main program is running.

In `Main.java` the thread is. Started like this:

```java

BudgetAlertThread alertThread = new BudgetAlertThread(planner);

alertThread.setDaemon(true);

alertThread.start();

```

The background thread periodically checks the expenses against the budget limit.

It calculates the usage percentage using:

```

double percentage = (totalExpense / budget) * 100;

```

It shows a warning when spending reaches 80% of the budget and a full alert when spending hits or exceeds 100%.

The thread waits 10 seconds between checks:

```java

Thread.sleep(10000);

```

This allows the budget monitoring to run without interrupting the menu.

---

### File I/O

File I/O is used to save transaction data to a file and load it back when needed.

The program uses a file named:

```text

data/budget.txt

```

The `FileManager` class has methods:

```java

saveTransactions(...)

```

and:

```java

loadTransactions()

```

When saving the application writes each transaction to the file.

When loading it reads the saved lines. Creates the proper `Income` and `Expense` objects.

This gives persistence without using a database.

---

### BufferedReader

`BufferedReader` is used in `FileManager.java` when reading saved transaction data.

The file is opened like this:

```java

BufferedReader reader =

BufferedReader(new FileReader(FILE_NAME));

```

The program reads the file line by line:

```java

String line;

while ((line = reader.readLine()) != null) {

// process transaction data

}

```

Each line is split into its parts. Used to rebuild a transaction object.

---

### BufferedWriter

`BufferedWriter` is used in `FileManager.java` when saving transaction data.

The writer is created with:

```java

BufferedWriter writer =

BufferedWriter(new FileWriter(FILE_NAME));

```

The application writes transaction details to the file and moves to the next line using:

```java

writer.write(...);

writer.newLine();

```

This is used to store both income and expense records in `data/budget.txt`.

---

### Command-Line Interface

The Budget Planner uses a command-line interface of a graphical user interface.

The `Main.java` class uses `Scanner` to get input from the user:

```java

Scanner scanner = Scanner(System.in);

```

The application shows a menu, with 11 options:

```text

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

The user’s choice is. Used to run the correct function.

This keeps the application simple. Lets users control everything directly from the terminal.

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
