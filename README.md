\# Budget Planner



A simple command-line Budget Planner application developed in Java.



The application allows users to record income and expenses, view transactions, search and delete expenses, calculate the remaining balance, and save/load budget data using a text file.



\## Features



\* Add income

\* Add expenses

\* Categorize expenses

\* View all transactions

\* View expenses

\* Search expenses

\* Delete expenses

\* Calculate total income

\* Calculate total expenses

\* Calculate remaining balance

\* Save data to a text file

\* Load previously saved data

\* Handle invalid amount and input errors



\## Technologies Used



\* Java

\* Object-Oriented Programming (OOP)

\* ArrayList

\* Inheritance

\* Polymorphism

\* Enum

\* Exception Handling

\* File I/O

\* BufferedReader

\* BufferedWriter

\* Command-Line Interface



\## Project Structure



```text

budget-planner/

│

├── Main.java

├── BudgetPlanner.java

├── Transaction.java

├── Income.java

├── Expense.java

├── Category.java

├── BudgetCalculator.java

├── InvalidAmountException.java

├── FileManager.java

│

├── data/

│   └── budget.txt

│

├── README.md

└── .gitignore

```



\## Class Description



\### Main.java



Contains the main method and command-line menu. It takes input from the user and calls the required operations.



\### BudgetPlanner.java



Manages the collection of transactions using `ArrayList<Transaction>`. It provides operations such as adding, viewing, searching, and deleting transactions.



\### Transaction.java



The base class for transactions. It stores common transaction information such as description and amount.



\### Income.java



Extends the `Transaction` class and represents an income transaction.



\### Expense.java



Extends the `Transaction` class and represents an expense. It also stores the expense category.



\### Category.java



An enum containing the available expense categories such as Food, Travel, Education, Shopping, Bills, Entertainment, Health, and Other.



\### BudgetCalculator.java



Contains methods for calculating total income, total expenses, and remaining balance.



\### InvalidAmountException.java



A custom exception used when the user enters an amount that is zero or negative.



\### FileManager.java



Handles saving transactions to and loading transactions from the `data/budget.txt` text file.



\## How to Run the Project



\### Step 1: Install Java



Make sure Java JDK is installed on your computer.



Check the Java version using:



```bash

java -version

```



Check the Java compiler using:



```bash

javac -version

```



\### Step 2: Open the Project Folder



Open a terminal or command prompt and navigate to the project folder.



Example:



```bash

cd budget-planner

```



\### Step 3: Compile the Java Files



Compile all Java source files using:



```bash

javac \*.java

```



\### Step 4: Run the Application



Run the program using:



```bash

java Main

```



\## Menu Options



When the application starts, the following menu is displayed:



```text

===== BUDGET PLANNER =====

1\. Add Income

2\. Add Expense

3\. View All Transactions

4\. View Expenses

5\. Search Expense

6\. Delete Expense

7\. Show Budget Summary

8\. Save Data

9\. Load Data

10\. Exit

```



Select an option by entering its corresponding number.



\## Data Storage



Budget data is stored in:



```text

data/budget.txt

```



The application creates the `data` folder automatically when the user selects the Save Data option.



The saved file contains transaction information that can be loaded again using the Load Data option.



\## Example



Example transactions:



```text

Income: Scholarship

Amount: ₹5000



Expense: Food

Amount: ₹500

Category: FOOD

```



The budget summary will display:



```text

Total Income: ₹5000.0

Total Expense: ₹500.0

Remaining Balance: ₹4500.0

Status: You are within budget.

```



\## OOP Concepts Used



The project demonstrates several Java Object-Oriented Programming concepts.



\### Encapsulation



Transaction data is kept private and accessed through methods such as getters.



\### Inheritance



`Income` and `Expense` inherit common properties and methods from the `Transaction` class.



\### Polymorphism



The application stores both `Income` and `Expense` objects in an `ArrayList<Transaction>` and uses method overriding for `displayTransaction()`.



\### Abstraction of Responsibilities



Different classes are responsible for different tasks such as transaction management, calculation, and file handling.



\## Exception Handling



The application handles invalid user input using exception handling.



A custom `InvalidAmountException` is used when an income or expense amount is less than or equal to zero.



`NumberFormatException` is also handled when the user enters an invalid numeric value.



\## Limitations



\* The application is command-line based.

\* Data is stored in a text file instead of a database.

\* Transaction descriptions should not contain commas because comma-separated data is used for file storage.



\## Future Scope



The project can be extended by adding:



\* Monthly budget limits

\* Date-wise transaction tracking

\* Monthly expense reports

\* Graphical user interface

\* Database storage using JDBC

\* Exporting reports

\* More detailed financial analysis



\## Author



SANSKRUTI PRASHANT CHANEKAR 

25BAI10603



Developed as a Java project for the Programming in Java course.



