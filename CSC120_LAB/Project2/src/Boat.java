//=================================================================================================
public class Boat {
    //---------------------------------------------------------------------------------------------
//----Defining enum class for type of boat
    public enum Type {
        SAILING, POWER
    }

//----Declaring variables
    Type type;
    String name;
    int year;
    String make;
    int length;
    double price;
    double expenses;
    //---------------------------------------------------------------------------------------------
//----Constructor
    public Boat(Type type, String name, int year, String make, int length, double price, double expenses) {
        this.type = type;
        this.name = name;
        this.year = year;
        this.make = make;
        this.length = length;
        this.price = price;
        this.expenses = expenses;
    }
    //---------------------------------------------------------------------------------------------
//----toString method
    public String toString() {
        return String.format("%-8s %-21s %-4d %-12s %2d'  : Paid $%10.2f : Spent $%9.2f", type, name, year, make, (length), price, expenses);
    }
    //---------------------------------------------------------------------------------------------
    private void addExpense() {

    }
//-------------------------------------------------------------------------------------------------
}//End of Boat Class
//=================================================================================================



/*
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Marina {
    // Method to read data from a CSV file and parse it into an ArrayList of String arrays
    public static ArrayList<String[]> getInputFromCSV(String fileName) {
        ArrayList<String[]> boatData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into an array of strings based on commas
                String[] data = line.split(",");
                boatData.add(data);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return boatData;
    }

    // Main method to run the Marina system
    public static void main(String[] args) {
        // Check if the user provided the file name as a command-line argument
        if (args.length < 1) {
            System.err.println("Usage: java Marina <CSV file name>");
            return; // Exit the program if no file name is provided
        }

        String fileName = args[0]; // Get the file name from the command-line arguments

        // Read the CSV file and get the boat data
        ArrayList<String[]> boatData = getInputFromCSV(fileName);

        if (boatData.isEmpty()) {
            System.err.println("The file is empty or could not be read.");
            return; // Exit if no data could be loaded
        }

        // Initialize the Fleet with the parsed boat data
        Fleet fleet = new Fleet(boatData);

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Main menu loop
        while (true) {
            System.out.println("\n(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "P": // Print the fleet inventory
                    fleet.printFleet();
                    break;

                case "A": // Add a new boat
                    System.out.println("Please enter the new boat CSV data:");
                    String[] newBoatData = scanner.nextLine().split(",");
                    try {
                        Boat.Type type = Boat.Type.valueOf(newBoatData[0].toUpperCase());
                        String name = newBoatData[1];
                        int year = Integer.parseInt(newBoatData[2]);
                        String make = newBoatData[3];
                        int length = Integer.parseInt(newBoatData[4]);
                        double price = Double.parseDouble(newBoatData[5]);
                        double expenses = Double.parseDouble(newBoatData[6]);

                        // Create and add the new boat
                        fleet.addBoat(new Boat(type, name, year, make, length, price, expenses));
                        System.out.println("Boat added successfully.");
                    } catch (Exception e) {
                        System.err.println("Invalid input. Please ensure the data is in the correct format.");
                    }
                    break;

                case "R": // Remove a boat
                    System.out.println("Which boat do you want to remove?");
                    String removeName = scanner.nextLine();
                    if (fleet.removeBoat(removeName)) {
                        System.out.println("Boat removed.");
                    } else {
                        System.out.println("Cannot find boat " + removeName);
                    }
                    break;

                case "E": // Add expenses to a boat
                    System.out.println("Which boat do you want to spend on?");
                    String expenseName = scanner.nextLine();
                    Boat expenseBoat = fleet.findBoat(expenseName);
                    if (expenseBoat == null) {
                        System.out.println("Cannot find boat " + expenseName);
                    } else {
                        System.out.println("How much do you want to spend?");
                        try {
                            double amount = Double.parseDouble(scanner.nextLine());
                            if (expenseBoat.expenses + amount > expenseBoat.price) {
                                System.out.printf("Expense not permitted, only $%.2f left to spend.%n",
                                        (expenseBoat.price - expenseBoat.expenses));
                            } else {
                                expenseBoat.expenses += amount;
                                System.out.printf("Expense authorized, $%.2f spent.%n", expenseBoat.expenses);
                            }
                        } catch (Exception e) {
                            System.err.println("Invalid amount. Please enter a valid number.");
                        }
                    }
                    break;

                case "X": // Exit the program
                    System.out.println("Exiting the Fleet Management System.");
                    scanner.close();
                    return;

                default: // Invalid menu option
                    System.out.println("Invalid menu option, try again.");
            }
        }
    }
}

 */