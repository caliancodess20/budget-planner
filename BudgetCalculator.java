import java.util.ArrayList;

public class BudgetCalculator {

    public static double calculateIncome(ArrayList<Transaction> transactions) {
        double totalIncome = 0;

        for (Transaction transaction : transactions) {
            if (transaction instanceof Income) {
                totalIncome += transaction.getAmount();
            }
        }

        return totalIncome;
    }

    public static double calculateExpense(ArrayList<Transaction> transactions) {
        double totalExpense = 0;

        for (Transaction transaction : transactions) {
            if (transaction instanceof Expense) {
                totalExpense += transaction.getAmount();
            }
        }

        return totalExpense;
    }

    public static double calculateBalance(ArrayList<Transaction> transactions) {
        return calculateIncome(transactions) - calculateExpense(transactions);
    }
}
