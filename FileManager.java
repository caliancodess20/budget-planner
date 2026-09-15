import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "data/budget.txt";

    public static void saveTransactions(ArrayList<Transaction> transactions) {

        try {
            File folder = new File("data");

            if (!folder.exists()) {
                folder.mkdir();
            }

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(FILE_NAME));

            for (Transaction transaction : transactions) {

                if (transaction instanceof Income) {
                    writer.write("INCOME,"
                            + transaction.getDescription()
                            + ","
                            + transaction.getAmount());

                } else if (transaction instanceof Expense) {

                    Expense expense = (Expense) transaction;

                    writer.write("EXPENSE,"
                            + expense.getDescription()
                            + ","
                            + expense.getAmount()
                            + ","
                            + expense.getCategory());
                }

                writer.newLine();
            }

            writer.close();

            System.out.println("Data saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving data.");
        }
    }

    public static ArrayList<Transaction> loadTransactions() {

        ArrayList<Transaction> transactions = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return transactions;
        }

        try {
            BufferedReader reader =
                    new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data[0].equals("INCOME")) {

                    transactions.add(
                            new Income(
                                    data[1],
                                    Double.parseDouble(data[2])
                            )
                    );

                } else if (data[0].equals("EXPENSE")) {

                    transactions.add(
                            new Expense(
                                    data[1],
                                    Double.parseDouble(data[2]),
                                    Category.valueOf(data[3])
                            )
                    );
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Error loading data.");
        }

        return transactions;
    }
}
