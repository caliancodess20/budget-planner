public class BudgetAlertThread extends Thread {

    private BudgetPlanner planner;
    private boolean warningShown = false;
    private boolean exceededShown = false;

    public BudgetAlertThread(BudgetPlanner planner) {
        this.planner = planner;
    }

    @Override
    public void run() {

        while (true) {

            double totalExpense =
                    BudgetCalculator.calculateExpense(
                            planner.getTransactions()
                    );

            double budgetLimit = planner.getBudgetLimit();

            if (budgetLimit > 0) {

                double percentage =
                        (totalExpense / budgetLimit) * 100;

                if (percentage >= 80 && percentage < 100) {

                    if (!warningShown) {

                        System.out.println(
                                "\n*** BUDGET WARNING: You have used 80% or more of your budget. ***"
                        );

                        warningShown = true;
                    }

                } else if (percentage >= 100) {

                    if (!exceededShown) {

                        System.out.println(
                                "\n*** BUDGET ALERT: You have exceeded your budget! ***"
                        );

                        exceededShown = true;
                    }
                }

                if (percentage < 80) {
                    warningShown = false;
                    exceededShown = false;
                }
            }

            try {

                Thread.sleep(10000);

            } catch (InterruptedException e) {

                System.out.println(
                        "Budget alert thread interrupted."
                );

                break;
            }
        }
    }
}