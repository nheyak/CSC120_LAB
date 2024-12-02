import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
//=================================================================================================
public class Marina {
    //---------------------------------------------------------------------------------------------
    public static final String SAVE_FILE_NAME = "FleetData.db";
    public static final Scanner keyboard = new Scanner(System.in);
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
                        Boat.Type type = Boat.Type.valueOf(newBoatData[0].toUpperCase()); //Making this and enum uppercase makes it case-insensitive
                        String name = newBoatData[1];
                        int year = Integer.parseInt(newBoatData[2]);
                        String make = newBoatData[3];
                        int length = Integer.parseInt(newBoatData[4]);
                        double price = Double.parseDouble(newBoatData[5]);
                        double expenses = 0;

//--------------------Creating and adding the new boat to the fleet
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
                            if (expensedBoat.expenses + amount > expensedBoat.price) {
                                System.out.printf("Expense not permitted, only $%.2f left to spend.%n", (expensedBoat.price - expensedBoat.expenses));
                                System.out.println();
                            } else {
                                expensedBoat.expenses += amount;
                                System.out.printf("Expense authorized, $%.2f spent.%n", expensedBoat.expenses);
                                System.out.println();
                            }
                        } catch (Exception e) {
                            System.out.printf("Expense authorized, $%.2f spent.%n", expensedBoat.expenses);
                        }
                    }
                    break;

                case "X":
                    saveFleet(fleet);
                    System.out.println();
                    System.out.println("Exiting the Fleet Management System.");
                    return;

                default:
                    System.out.println("Invalid menu option, try again.");

            }
        }
    }
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
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return boatData;
    }
    //---------------------------------------------------------------------------------------------
    private static void saveFleet(Fleet fleet) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SAVE_FILE_NAME))) {
            oos.writeObject(fleet);
        } catch (IOException e) {
            System.err.println("Error saving fleet data: " + e.getMessage());
        }
    }
    //---------------------------------------------------------------------------------------------
    // Method to load the Fleet object from a file
    private static Fleet loadFleet() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(SAVE_FILE_NAME))) {
            return (Fleet) ois.readObject();
        } catch (FileNotFoundException e) {
            // No save file found; return null
            return null;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading fleet data: " + e.getMessage());
            return null;
        }
    }
//-------------------------------------------------------------------------------------------------
} //End of Marina class
//=================================================================================================


