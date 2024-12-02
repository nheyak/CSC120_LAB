import java.util.ArrayList;
//=================================================================================================
public class Fleet {
    //---------------------------------------------------------------------------------------------
    private ArrayList<Boat> boats;
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
    //---------------------------------------------------------------------------------------------
//----Add a new boat to the fleet
    public void addBoat(Boat boat) {
        boats.add(boat);
    }
    //---------------------------------------------------------------------------------------------
    public ArrayList<Boat> getBoats() {
        return boats;
    }
    //---------------------------------------------------------------------------------------------
    public boolean removeBoat(String boatName) {
        for (Boat boat : boats) {
            if (boat.name.equalsIgnoreCase(boatName)) {
                boats.remove(boat);
                return true;
            }
        }
        return false; // Boat not found
    }
    //---------------------------------------------------------------------------------------------
    public Boat findBoat(String boatName) {
        for (Boat boat : boats) {
            if (boat.name.equalsIgnoreCase(boatName)) {
                return boat;
            }
        }
        return null; // Boat not found
    }
    //---------------------------------------------------------------------------------------------
    public void printFleet() {
        double totalPaid = 0, totalSpent = 0;

        System.out.println();
        System.out.println("Fleet report:");
        for (Boat boat : boats) {
            totalPaid += boat.price;
            totalSpent += boat.expenses;
            System.out.println(boat); // Calls the Boat's toString method
        }
        System.out.printf("%-54s: Paid $%10.2f : Spent $%9.2f%n", "Total", totalPaid, totalSpent);
        System.out.println();
    }
//---------------------------------------------------------------------------------------------
}//End of Fleet Class
//=============================================================================================