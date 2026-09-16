# Budget Planner

A simple command-line Budget Planner built using Java. The project helps users manage income and expenses, calculate their remaining balance, search and delete expenses, save and load data, and receive budget alerts.

## Features

* Add income
* Add expenses
* Categorize expenses
* View all transactions
* View expenses separately
* Search expenses
* Delete expenses
* Calculate total income, total expenses, and remaining balance
* Set a budget limit
* Receive automatic budget warnings
* Save transaction data to a file
* Load previously saved transaction data
* Handle invalid user input and invalid amounts

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* ArrayList
* Inheritance
* Polymorphism
* Enum
* Exception Handling
* Multithreading
* File I/O

## Project Structure

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
├── BudgetAlertThread.java
│
├── data/
│   └── budget.txt
│
├── README.md
└── Project_Report.pdf
```

## Class Description

### Main.java

Contains the main method and provides the command-line menu through which the user interacts with the application.

### BudgetPlanner.java

Manages the collection of transactions and provides operations such as adding, viewing, searching, deleting, and loading transactions.

### Transaction.java

Acts as the base class for transactions and contains common properties such as description and amount.

### Income.java

Extends `Transaction` and represents income records.

### Expense.java

Extends `Transaction` and represents expense records. It also stores the expense category.

### Category.java

An enum containing predefined expense categories such as Food, Travel, Education, Shopping, Bills, Entertainment, Health, and Other.

### BudgetCalculator.java

Calculates total income, total expenses, and remaining balance.

### InvalidAmountException.java

A custom exception used to handle invalid or non-positive transaction amounts.

### FileManager.java

Handles saving transaction data to `data/budget.txt` and loading it back into the application.

### BudgetAlertThread.java

Runs a separate thread that periodically checks the total expenses against the budget limit and displays a warning when spending reaches 80% or more and an alert when the budget is exceeded.

## How to Run

### Step 1: Install Java

Make sure Java JDK is installed on your computer.

Check the installation using:

```bash
java -version
javac -version
```

### Step 2: Clone the Repository

```bash
git clone https://github.com/caliancodess20/budget-planner.git
```

### Step 3: Open the Project Folder

```bash
cd budget-planner
```

### Step 4: Compile the Java Files

On Windows PowerShell:

```powershell
javac (Get-ChildItem *.java).Name
```

On Command Prompt/Linux/macOS:

```bash
javac *.java
```

### Step 5: Run the Program

```bash
java Main
```

No GUI or additional software is required to run the application.

## Menu Options

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

## Data Storage

Transaction data is stored in:

```text
data/budget.txt
```

The application automatically creates the `data` folder when saving data if it does not already exist.

The current implementation stores transaction records in a text-file format. The budget limit itself is not persisted between program restarts.

## Example

```text
Enter income description: Scholarship
Enter income amount: ₹10000

Transaction added successfully.

Enter expense description: Food
Enter expense amount: ₹200

Select Category:
1. FOOD
2. TRAVEL
3. EDUCATION
4. SHOPPING
5. BILLS
6. ENTERTAINMENT
7. HEALTH
8. OTHER

Enter category number: 1

Transaction added successfully.
```

The budget summary displays:

```text
===== BUDGET SUMMARY =====

Total Income: ₹10000.0
Total Expense: ₹200.0
Remaining Balance: ₹9800.0
Status: You are within budget.
```

## Object-Oriented Programming Concepts Used

### Encapsulation

Private variables are used inside classes and accessed through methods such as getters.

### Inheritance

`Income` and `Expense` inherit common properties and methods from `Transaction`.

### Polymorphism

The application stores different transaction objects using:

```java
ArrayList<Transaction>
```

The overridden `displayTransaction()` method behaves differently for `Income` and `Expense`.

### Abstraction

Common transaction-related properties and operations are placed in the base `Transaction` class.

## Exception Handling

The project uses exception handling to prevent the program from terminating because of invalid input.

A custom exception called `InvalidAmountException` is used when the user enters an amount less than or equal to zero.

`NumberFormatException` is also handled when the user enters invalid numeric input.

## Multithreading

The project uses a separate `BudgetAlertThread` to monitor expenses periodically.

The thread:

* Checks total expenses every 10 seconds.
* Compares expenses with the user-defined budget limit.
* Displays a warning when 80% or more of the budget is used.
* Displays an alert when the budget is exceeded.
* Avoids repeatedly displaying the same warning or alert.

## File Handling

Java File I/O is used to store and retrieve transaction data.

The project uses:

* `File`
* `FileWriter`
* `BufferedWriter`
* `FileReader`
* `BufferedReader`

This allows transaction data to remain available after the program is closed and reopened.

## Architecture

```text
                Transaction
                /         \
            Income       Expense
                            |
                         Category

                BudgetPlanner
                       |
              ArrayList<Transaction>
                       |
                BudgetCalculator
                       |
                  File I/O
```

### Budget Alert

```text
Main Thread
     |
User interacts with menu
     |
BudgetAlertThread
     |
Checks expenses every 10 seconds
     |
Budget warning / alert
```

## Challenges Faced

* **Handling different transaction types:** Managing both income and expense records using a common `Transaction` reference required proper use of inheritance and polymorphism.

* **Input validation:** Invalid or negative amounts had to be handled using a custom `InvalidAmountException`.

* **File handling:** Saving and loading transaction data from a text file required proper use of Java I/O classes such as `BufferedWriter` and `BufferedReader`.

* **Data restoration:** The program had to recreate `Income` and `Expense` objects correctly when loading previously saved data.

* **Budget monitoring:** Implementing the budget alert feature required a separate thread to periodically check total expenses against the budget limit.

* **Menu-based interaction:** The command-line menu had to handle different user choices and invalid inputs without terminating the program unexpectedly.

* **Data organization:** Maintaining transactions in an `ArrayList<Transaction>` made it easier to manage multiple transaction types while demonstrating Java Collections.

## Testing

The application was tested for the following cases:

| Test Case                   | Expected Result                         |
| --------------------------- | --------------------------------------- |
| Add valid income            | Income added successfully               |
| Add valid expense           | Expense added successfully              |
| Enter negative amount       | Custom error message displayed          |
| Enter invalid numeric input | Input error displayed                   |
| View transactions           | All stored transactions displayed       |
| Search expense              | Matching expenses displayed             |
| Delete expense              | Selected expense removed                |
| Calculate summary           | Income, expense, and balance calculated |
| Save data                   | Data stored in `budget.txt`             |
| Load data                   | Saved transactions restored             |
| Reach 80% budget usage      | Budget warning displayed                |
| Exceed budget               | Budget alert displayed                  |

## Limitations

* The application uses a command-line interface instead of a graphical interface.
* Transaction descriptions containing commas may not be handled correctly because the current file format uses commas as separators.
* The budget limit is not saved to the data file and resets when the application is restarted.
* Data is stored in a text file instead of a database.
* The application does not provide user authentication.

## Future Scope

The project can be further improved by adding:

* GUI using JavaFX or Swing
* Database integration using JDBC
* Monthly and yearly expense reports
* Graphical charts for spending analysis
* User login and authentication
* Export to CSV or PDF
* Recurring expense management
* More advanced budget recommendations

## Learning Outcomes

Through this project, the following Java concepts were implemented:

* Classes and objects
* Constructors
* Inheritance
* Method overriding
* Polymorphism
* Encapsulation
* Enum
* ArrayList
* Exception handling
* Custom exceptions
* Multithreading
* File I/O
* Command-line application development

## Conclusion

The Budget Planner is a simple Java-based application designed to help users manage their income and expenses from the command line. The project demonstrates important Java programming concepts including OOP, collections, exception handling, multithreading, and file handling.

The project provides a practical example of applying Java concepts to a simple real-world problem while keeping the application easy to understand and operate.

## Author

**Sanskruti Chanekar**
**25BAI10603**

B.Tech – Artificial Intelligence and Machine Learning

VIT Bhopal University

## License

This project is developed for academic/educational purposes.
