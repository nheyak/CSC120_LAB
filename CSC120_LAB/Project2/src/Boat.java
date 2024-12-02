import java.io.Serializable;
//=================================================================================================
public class Boat implements Serializable{
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