public class Expense extends Transaction {

    private Category category;

    public Expense(String description, double amount, Category category) {
        super(description, amount);
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public void displayTransaction() {
        System.out.println("Expense: " + getDescription());
        System.out.println("Amount: ₹" + getAmount());
        System.out.println("Category: " + category);
    }
}
