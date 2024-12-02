import java.io.Serializable;

/**
 * Holds and assigns each characteristic for each boat in the fleet.
 * @author Nheya Kumar
 */
//=================================================================================================
public class Boat implements Serializable{
    //---------------------------------------------------------------------------------------------
//----Defining enum class for type of boat

    /**
     * Stores the types of boats in the fleet (sailing or power).
     */
    protected enum Type { //Protected so it's not global
        SAILING, POWER
    }

//----Declaring variables (Non-global because they're private)
    /**
     * What type of boat it is (sailing or power)
     */
    private final Type type;
    /**
     * The name of the boat
     */
    private final String name;
    /**
     * The year the boat was made
     */
    private final int year;
    /**
     * The make of the boat
     */
    private final String make;
    /**
     * The length of the boat
     */
    private final int length;
    /**
     * The price of the boat
     */
    private final double price;
    /**
     * The money expensed/spent on the boat
     */
    private double expenses;

    /**
     * Takes parameters and constructs a boat object in the fleet.
     * @param type Whether it is a sailing boat or power boat
     * @param name The name of the boat
     * @param year What year the boat was made
     * @param make What the make of the boat is
     * @param length How long the boat is
     * @param price How much the boat cost
     * @param expenses How much has been spent on a boat (initially zero)
     */
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

    /**
     * Gets the name of the boat for use in the Fleet Class.
     * @return Returns name of the boat as a String
     */
    //---------------------------------------------------------------------------------------------
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the boat for use in the Fleet Class.
     * @return Returns price of the boat as a double
     */
    //---------------------------------------------------------------------------------------------
    public double getPrice() {
        return price;
    }

    /**
     * Gets the expenses of the boat for use in the Fleet Class.
     * @return Returns the expenses of the boat as a double
     */
    //---------------------------------------------------------------------------------------------
    public double getExpenses() {
        return expenses;
    }

    /**
     * Adds expenses to the expense amount for the Boat.
     * @param amount The amount of money trying to be expensed on the boat
     */
    //---------------------------------------------------------------------------------------------
    public void addExpenses(double amount) {
        this.expenses += amount;
    }

    /**
     * Prints each boat's data.
     * @return String containing all the boat's information formatted uniformly
     */
    //---------------------------------------------------------------------------------------------
//----toString method
    public String toString() {
        return String.format("%-8s %-21s %-4d %-12s %2d'  : Paid $%10.2f : Spent $%9.2f", type, name, year, make, (length), price, expenses);
    }
//-------------------------------------------------------------------------------------------------
}//End of Boat Class
//=================================================================================================