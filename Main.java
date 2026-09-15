import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BudgetPlanner planner = new BudgetPlanner();

        boolean running = true;

        while (running) {

            System.out.println("\n===== BUDGET PLANNER =====");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View All Transactions");
            System.out.println("4. View Expenses");
            System.out.println("5. Search Expense");
            System.out.println("6. Delete Expense");
            System.out.println("7. Show Budget Summary");
            System.out.println("8. Save Data");
            System.out.println("9. Load Data");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            try {

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter income description: ");
                        String incomeDescription = scanner.nextLine();

                        System.out.print("Enter income amount: ₹");
                        double incomeAmount =
                                Double.parseDouble(scanner.nextLine());

                        if (incomeAmount <= 0) {
                            throw new InvalidAmountException(
                                    "Amount must be greater than zero."
                            );
                        }

                        planner.addTransaction(
                                new Income(
                                        incomeDescription,
                                        incomeAmount
                                )
                        );
                        break;

                    case 2:
                        System.out.print("Enter expense description: ");
                        String expenseDescription = scanner.nextLine();

                        System.out.print("Enter expense amount: ₹");
                        double expenseAmount =
                                Double.parseDouble(scanner.nextLine());

                        if (expenseAmount <= 0) {
                            throw new InvalidAmountException(
                                    "Amount must be greater than zero."
                            );
                        }

                        System.out.println("Select Category:");

                        Category[] categories = Category.values();

                        for (int i = 0; i < categories.length; i++) {
                            System.out.println(
                                    (i + 1) + ". " + categories[i]
                            );
                        }

                        System.out.print("Enter category number: ");
                        int categoryChoice =
                                Integer.parseInt(scanner.nextLine());

                        if (categoryChoice < 1 ||
                                categoryChoice > categories.length) {

                            System.out.println("Invalid category.");
                            break;
                        }

                        Category category =
                                categories[categoryChoice - 1];

                        planner.addTransaction(
                                new Expense(
                                        expenseDescription,
                                        expenseAmount,
                                        category
                                )
                        );
                        break;

                    case 3:
                        planner.viewTransactions();
                        break;

                    case 4:
                        planner.viewExpenses();
                        break;

                    case 5:
                        System.out.print("Enter expense to search: ");
                        String keyword = scanner.nextLine();

                        planner.searchExpense(keyword);
                        break;

                    case 6:
                        planner.viewTransactions();

                        System.out.print(
                                "\nEnter transaction number to delete: "
                        );

                        int index =
                                Integer.parseInt(scanner.nextLine());

                        planner.deleteExpense(index - 1);
                        break;

                    case 7:

                        double income =
                                BudgetCalculator.calculateIncome(
                                        planner.getTransactions()
                                );

                        double expense =
                                BudgetCalculator.calculateExpense(
                                        planner.getTransactions()
                                );

                        double balance =
                                BudgetCalculator.calculateBalance(
                                        planner.getTransactions()
                                );

                        System.out.println("\n===== BUDGET SUMMARY =====");
                        System.out.println("Total Income: ₹" + income);
                        System.out.println("Total Expense: ₹" + expense);
                        System.out.println(
                                "Remaining Balance: ₹" + balance
                        );

                        if (balance > 0) {
                            System.out.println(
                                    "Status: You are within budget."
                            );
                        } else if (balance == 0) {
                            System.out.println(
                                    "Status: Budget fully used."
                            );
                        } else {
                            System.out.println(
                                    "Status: You have exceeded your budget."
                            );
                        }

                        break;

                    case 8:
                        FileManager.saveTransactions(
                                planner.getTransactions()
                        );
                        break;

                    case 9:
                        planner.loadTransactions();
                        break;

                    case 10:
                        running = false;
                        System.out.println(
                                "Thank you for using Budget Planner!"
                        );
                        break;

                    default:
                        System.out.println(
                                "Invalid choice. Please try again."
                        );
                }

            } catch (InvalidAmountException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a valid number."
                );

            } catch (Exception e) {

                System.out.println(
                        "Something went wrong. Please try again."
                );
            }
        }

        scanner.close();
    }
}
