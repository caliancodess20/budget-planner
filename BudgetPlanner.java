```java
import java.util.ArrayList;

public class BudgetPlanner {

    private ArrayList<Transaction> transactions;

    public BudgetPlanner() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("Transaction added successfully.");
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void viewTransactions() {

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        System.out.println("\n----- All Transactions -----");

        for (int i = 0; i < transactions.size(); i++) {
            System.out.println("\nTransaction " + (i + 1));
            transactions.get(i).displayTransaction();
        }
    }

    public void viewExpenses() {

        boolean found = false;

        System.out.println("\n----- Expenses -----");

        for (Transaction transaction : transactions) {

            if (transaction instanceof Expense) {
                transaction.displayTransaction();
                System.out.println("--------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found.");
        }
    }

    public void searchExpense(String keyword) {

        boolean found = false;

        for (Transaction transaction : transactions) {

            if (transaction instanceof Expense &&
                transaction.getDescription().toLowerCase()
                        .contains(keyword.toLowerCase())) {

                transaction.displayTransaction();
                System.out.println("--------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching expense found.");
        }
    }

    public void deleteExpense(int index) {

        if (index >= 0 && index < transactions.size()) {

            if (transactions.get(index) instanceof Expense) {
                transactions.remove(index);
                System.out.println("Expense deleted successfully.");
            } else {
                System.out.println(
                        "Selected transaction is not an expense."
                );
            }

        } else {
            System.out.println("Invalid transaction number.");
        }
    }

    public void loadTransactions() {
        transactions = FileManager.loadTransactions();
        System.out.println("Data loaded successfully.");
    }
}
```


