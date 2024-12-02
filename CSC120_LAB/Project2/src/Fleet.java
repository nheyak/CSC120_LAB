import java.util.ArrayList;
import java.io.Serializable;

/**
 * Manages fleet of boats in the marina, adding, removing, and expensing them based on user input
 * @author Nheya Kumar
 */
//=================================================================================================
public class Fleet implements Serializable{
    //---------------------------------------------------------------------------------------------
    private ArrayList<Boat> boats;

    /**
     *Constructor Method
     * @param boatData Input from the files read in the Marina class brought to be read and converted into Boats in the Fleet
     */
    //---------------------------------------------------------------------------------------------
//----Constructor
    public Fleet(ArrayList<String[]> boatData) {
        boats = new ArrayList<>();

//----Iterate over the provided data and create Boat objects
        for (String[] data : boatData) {
//--------Assuming data format: {type, name, year, make, length, price, expenses}
            Boat.Type type = Boat.Type.valueOf(data[0].toUpperCase()); // Convert to enum
            String name = data[1];
            int year = Integer.parseInt(data[2]);
            String make = data[3];
            int length = Integer.parseInt(data[4]);
            double price = Double.parseDouble(data[5]);
            double expenses = 0.0;

//--------Create a Boat object and add it to the ArrayList
            boats.add(new Boat(type, name, year, make, length, price, expenses));
        }
    } //End of constructor

    /**
     * Adds a boat object to fleet
     * @param boat The boat being added
     */
    //---------------------------------------------------------------------------------------------
//----Add a new boat to the fleet
    public void addBoat(Boat boat) {
        boats.add(boat);
    }

    /**
     * Removes a boat from the fleet only if the given boat exists to be removed
     * @param boatName Name of the boat to be removed from the fleet
     */
    //---------------------------------------------------------------------------------------------
    public boolean removeBoat(String boatName) {
        for (Boat boat : boats) {
            if (boat.getName().equalsIgnoreCase(boatName)) { // Use getter for name
                boats.remove(boat);
                return true;
            }
        }
        return false; // Boat not found
    }

    /**
     * Finds a boat object in the fleet if it exists for expensing
     * @param boatName Name of boat to be found
     */
    //---------------------------------------------------------------------------------------------
    public Boat findBoat(String boatName) {
        for (Boat boat : boats) {
            if (boat.getName().equalsIgnoreCase(boatName)) { // Use getter for name
                return boat;
            }
        }
        return null; // Boat not found
    }

    /**
     * Prints the fleet data including type, name, year, length, cost, and expenses
     */
    //---------------------------------------------------------------------------------------------
    public void printFleet() {
        double totalPaid = 0, totalSpent = 0;

        System.out.println();
        System.out.println("Fleet report:");
        for (Boat boat : boats) {
            totalPaid += boat.getPrice(); // Use getter for price
            totalSpent += boat.getExpenses(); // Use getter for expenses
            System.out.println(boat); // Calls the Boat's toString method
        }
        System.out.printf("%-54s: Paid $%10.2f : Spent $%9.2f%n", "Total", totalPaid, totalSpent);
        System.out.println();
    }
//---------------------------------------------------------------------------------------------
}//End of Fleet Class
//=============================================================================================
