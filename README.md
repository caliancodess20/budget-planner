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
The Java programming language is utilized to develop the complete application of Budget Planner. Several classes comprise the application, namely, Main, BudgetPlanner, Transaction, Income, Expense, BudgetCalculator, FileManager, and BudgetAlertThread . These classes employ Java for the purpose of acquiring user input, processing transactions, performing calculations, managing files, handling exceptions, and executing background processes for continuous budget monitoring.

### Object-oriented Programming (OOP)

The principles of OOP have been applied by organizing the application around various classes, as discussed above. For instance,
`Transaction` stores the common description and amount data of all transaction types while `Income` and `Expense` denote distinct transaction types. `BudgetPlanner` maintains the list of all transactions and the set budget limit, `BudgetCalculator` executes all calculations relating to income, expenses, and balance, while `FileManager` oversees the storage and retrieval of transaction data.

This way, the dissimilar aspects of the application have been appropriately segregated while enabling these classes to interact with one another.

### ArrayList

`ArrayList` has been employed in `BudgetPlanner` for the purpose of storing all expense and income transactions as illustrated by the following code segment.

```java

private ArrayList transactions;

```

The arraylist is instantiated when initializing the class with the following line of code.

```java

transactions = new ArrayList<>();

```

All transactions are added to the arraylist by implementing the following syntax.

```java

transactions.add(transaction);

```

The same arraylist is used for viewing, searching, deleting and calculating all transactions. Additionally, the use of `ArrayList` ensures that all expense and income transactions can be conveniently stored within the same data structure.

### Inheritance

The concept of inheritance is demonstrated by the relationship between `Transaction` and other transaction classes. This is achieved by enabling `Income` and `Expense` to extend `Transaction`, as illustrated by the following code segment.

```java

public class Income extends Transaction

```

```java

public class Expense extends Transaction

```

This way, the common attributes and methods of `Income` and `Expense` are defined once in `Transaction` instead of duplicating them.

### Polymorphism

Polymorphism is demonstrated by the fact that `ArrayList` can hold objects of type `Income` and `Expense`. Such an approach is possible due to the fact that `Income` and `Expense` are subclasses of `Transaction`. This is demonstrated by the following code segments.

```java

transactions.add(new Income(description, amount));

```

```java

transactions.add(new Expense(description, amount, category));

```

Polymorphism is also demonstrated by the override of `displayTransaction()` method in `Income` and `Expense`. As a result, when `BudgetPlanner` executes the following line of code

```java

transaction.displayTransaction();

```

it invokes the overridden method in `Income` or `Expense`, depending on the reference of `transaction`. Similar polymorphism is demonstrated by `BudgetCalculator` when it executes the following lines of code.

```java

if (transaction instanceof Income)

```

```java

if (transaction instanceof Expense)

```

### Encapsulation

Encapsulation has been demonstrated by the fact that all instance variables have been declared as `private` while public getters and setters have been defined. For instance,

```java

private String description;

private double amount;

```

in `Transaction` are not directly accessible from other classes. Rather, other classes utilize the following public getters and setters to manipulate the instance variables.

```java

public String getDescription()

public double getAmount()

```

Similarly, the following instance variables in `BudgetPlanner` are also encapsulated.

```java

private ArrayList transactions;

private double budgetLimit;

```

I found this concept very interesting since encapsulation ensures that manipulation of data is controlled and that application logic is contained within classes. This way, other classes cannot directly access instance variables of other classes.

### Enum

The concept of `enum` has been demonstrated by the fact that the categories of expenses have been encapsulated in an `enum` class as illustrated by the following code segment.

```java

public class Category {

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

}

```

As a result, the following lines of code can be used to print all expense categories.

```java

for (Category.Category category : Category.Category.values()) {

System.out.println(category);

}

```

This way, the categories of expenses cannot be manipulated by the user or other classes. Rather, when the user is required to enter an expense category, the selection is limited to the predefined categories.

### Exception Handling

The concept of exception handling is demonstrated by the fact that the application utilizes try/catch blocks to handle unexpected events or errors during execution. For instance, the following exception class, which extends the `Exception` class, is utilized to indicate instances where an invalid amount has been entered.

```java

public class InvalidAmountException extends Exception

```

The following line of code, for instance, demonstrates how this exception is triggered when a negative or zero amount is entered.

```java

if (amount <= 0) {

throw new InvalidAmountException("Amount must be greater than zero.");

}

```

This exception, alongside other exceptions such as `NumberFormatException` and a generic `Exception` handler, are caught and handled as illustrated by the following code segment in `Main.java`.

```java

catch (InvalidAmountException e)

```

### Multithreading

Multithreading is demonstrated by the implementation of a background thread, which continually monitors the budget in the background while the user interacts with the main application menu. This is achieved by the following code segment in `Main.java`.

```java

BudgetAlertThread alertThread = new BudgetAlertThread(planner);

alertThread.setDaemon(true);

alertThread.start();

```

While the main menu is running, the background thread checks if the percentage of the total expense is greater than or equal to the set budget limit in the background using the following line of code.

```java

double percentage = (totalExpense / budget) * 100;

```

The background thread then warns the user when the budget is at 80% and the budget is exceeded when the percentage reaches or exceeds 100%. Finally, the background thread waits for 10 seconds before proceeding to the next iteration of the loop as illustrated by the following line of code.

```java

Thread.sleep(10000);

```

### File I/O

File I/O is demonstrated by the fact that the application can be saved to and loaded from a file. Specifically, a file named `budget.txt` under the `data` directory is utilized to store the list of all income and expense transactions.

`FileManager` class implements the methods for saving and loading transactions. The following code segments, for instance, demonstrate how transactions are saved to the file.

```java

saveTransactions(...)

```

When the file is reloaded, the records in the file are utilized to recreate the various transactions.

### BufferedReader

`BufferedReader` is employed in `FileManager.java` for reading the content of the file containing all saved transactions. The file is initially opened using the following code segment.

```java

BufferedReader reader =

new BufferedReader(new FileReader(FILE_NAME));

```

A loop is then utilized to read the content of the file as illustrated by the following code segment.

```java

String line;

while ((line = reader.readLine()) != null) {

// process transaction data

}

```

### BufferedWriter

`BufferedWriter` is employed in `FileManager.java` for the purpose of writing transaction data to the file. A `BufferedWriter` object is instantiated using the following code segment.

```java

BufferedWriter writer =

new BufferedWriter(new FileWriter(FILE_NAME));

```

The application then utilizes the `BufferedWriter` object to write transaction information to the `budget.txt` file and move to a new line as illustrated by the following code segment.

```java

writer.write(...);

writer.newLine();

```

This is useful when saving income and expense data to the file.


### Command-line interface

Finally, the application employs the command-line interface rather than the graphical user interface (GUI). `Main.java` employs `Scanner` to read the user input as illustrated by the following line of code.

```java

Scanner scanner = new Scanner(System.in);

```

The application presents an 11-option menu as illustrated by the following code segment.

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

The user then selects an option, which is read and processed by the following line of code.

```text

int choice = Integer.parseInt(scanner.nextLine());

```

This approach is very convenient since the user can directly input the desired option from the command-line interface (CLI) without utilizing a GUI.

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
