import java.util.Scanner;
import java.io.*; // Imports all because I needed like 4 of them
import java.util.ArrayList;

/**
 * Manages Fleet of boats taking input from the user to add and remove inventory and track and approve expenses for each boat and overall costs.
 * @author Nheya Kumar
 */
//=================================================================================================
public class Marina {
    //---------------------------------------------------------------------------------------------
    public static final Scanner keyboard = new Scanner(System.in);

    /** Name of file that database will save to for when program is reopened so progress is saved */
    public static final String SAVE_FILE_NAME = "FleetData.db";

    /**
     * Main method that takes the data from CSV file and does one of five menu options using the data and modifying it along the way.
     */
    //---------------------------------------------------------------------------------------------
    public static void main(String[] args){

//----Declare fleet
        Fleet fleet;

//----Load a fleet if there is one
        fleet = loadFleet();

        if (fleet == null) {
//--------If no save file exists, proceed with loading CSV file
            if (args.length < 1) {
                System.err.println("Usage: java Marina <CSV file name>");
                return;
            }
            String fileName = args[0];
            ArrayList<String[]> boatData = getInput(fileName);
            if (boatData.isEmpty()) {
                System.err.println("The file is empty or could not be read.");
                return;
            }
            fleet = new Fleet(boatData);
        }

//----Print Welcome Message
        System.out.println("Welcome to the Fleet Management System");
        System.out.println("--------------------------------------");
        System.out.println();

//----Loop for user output (Main Menu)
        while (true) {
            System.out.print("(P)rint, (A)dd, (R)emove, (E)xpense, e(X)it : ");
            String choice = keyboard.next().toUpperCase(); // Upper case to make it case-insensitive

//--------Switch for different menu options
            switch (choice) {
                case "P":
                    fleet.printFleet();
                    break;

                case "A":
                    System.out.printf("%-44s: ","Please enter the new boat CSV data");
                    String[] newBoatData = keyboard.next().split(",");

                    try {

//--------------------Reading the new CSV Input
                        Boat.Type type = Boat.Type.valueOf(newBoatData[0]);
                        String name = newBoatData[1];
                        int year = Integer.parseInt(newBoatData[2]);
                        String make = newBoatData[3];
                        int length = Integer.parseInt(newBoatData[4]);
                        double price = Double.parseDouble(newBoatData[5]);
                        double expenses = 0;

//--------------------Creating and adding the new boat to the fleet using the factory method
                        fleet.addBoat(new Boat(type, name, year, make, length, price, expenses));
                        System.out.println();
                    } catch (Exception e) {
                        System.err.println("Invalid input. please ensure the data is in the correct format.");
                    }
                    break;

                case "R":
                    System.out.printf("%-44s: ","Which boat do you want to remove?");

//----------------Clearing the input buffer in case there's a newline there that would mess up the input
                    keyboard.nextLine();

//----------------Reading the input to see which boat to remove
                    String removedBoatName = keyboard.nextLine();

                    if (fleet.removeBoat(removedBoatName)) {
                        System.out.println();
                    } else {
                        System.out.println("Cannot find boat " + removedBoatName);
                        System.out.println();
                    }

                    break;

                case "E":
                    System.out.printf("%-44s: ","Which boat do you want to spend on ?");

//----------------Clearing the input buffer in case there's a newline there that would mess up the input
                    keyboard.nextLine();

//----------------Reading the input to see which boat to expense
                    String expensedBoatName = keyboard.nextLine();

//----------------Creates expensedBoat variable for the named boat
                    Boat expensedBoat = fleet.findBoat(expensedBoatName); //If boat exists, it finds it in ArrayList

                    if (expensedBoat == null) {
                        System.out.println("Cannot find boat " + expensedBoatName);
                        System.out.println();
                    } else {
                        System.out.printf("%-44s: ","How much do you want to spend?");

                        try {
                            double amount = Double.parseDouble(keyboard.next());

//------------------------Checks whether there's money left to spend and either expenses it or rejects request
                            if (expensedBoat.getExpenses() + amount > expensedBoat.getPrice()) { // Use getters
                                System.out.printf("Expense not permitted, only $%.2f left to spend.%n", (expensedBoat.getPrice() - expensedBoat.getExpenses()));
                                System.out.println();
                            } else {
                                expensedBoat.addExpenses(amount); // Use setter
                                System.out.printf("Expense authorized, $%.2f spent.%n", expensedBoat.getExpenses());
                                System.out.println();
                            }
                        } catch (Exception e) {
                            System.out.printf("Expense authorized, $%.2f spent.%n", expensedBoat.getExpenses());
                        }
                    }
                    break;

                case "X":
                    System.out.println();
                    try {
                        saveFleet(fleet);
                    } catch (Exception e) {
                        System.err.println("Error saving fleet data: " + e.getMessage());
                    } finally {
                        keyboard.close();
                        System.out.println("Exiting the Fleet Management System.");
                        return;
                    }


                default:
                    System.out.println("Invalid menu option, try again.");

            } //End of switch
        } //End of While loop
    } //End of main method

    /**
     * Reads and returns data from CSV file
     * @param fileName Name of file to be read given in the command line
     * @return Returns the data of boats in the fleet in an ArrayList to be read in the main method
     */
    //---------------------------------------------------------------------------------------------
    public static ArrayList<String[]> getInput(String fileName) {
        ArrayList<String[]> boatData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
//--------Split the line into an array of strings based on commas
                String[] data = line.split(",");
                boatData.add(data);
            }
            br.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }


        return boatData;
    }

    /**
     * Saves Fleet with all changes as file type given above
     * @param fleet Fleet object that holds Boat objects to be saved in the file for later reference
     */
    //---------------------------------------------------------------------------------------------
    private static void saveFleet(Fleet fleet) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE_NAME))) {
            oos.writeObject(fleet);
            oos.close();
        } catch (IOException e) {
            System.err.println("Error saving fleet data: " + e.getMessage());
        }
    }

    /**
     * Loads data to be read into fleet from file above if it exists
     * @return Returns Fleet object that uses the data that is read with the constructor to put all boats in the fleet
     */
    //---------------------------------------------------------------------------------------------
//----Method to load the Fleet object from a file
    private static Fleet loadFleet() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE_NAME))) {
            return (Fleet) ois.readObject();
        } catch (FileNotFoundException e) {
            // No save file found; return null
            return null;
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
//-------------------------------------------------------------------------------------------------
} //End of Marina class
//=================================================================================================
