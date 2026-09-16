public class Income extends Transaction {

    public Income(String description, double amount) {
        super(description, amount);
    }

    @Override
    public void displayTransaction() {
        System.out.println("Income: " + getDescription());
        System.out.println("Amount: Rs. " + getAmount());
    }
}
