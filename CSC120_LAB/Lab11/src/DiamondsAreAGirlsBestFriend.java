import java.util.Scanner;
//======================================================================================================================
public class DiamondsAreAGirlsBestFriend {

//----------------------------------------------------------------------------------------------------------------------
    public static final Scanner keyboard = new Scanner(System.in);

//----------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

//----Declaring variables
        int caratValue;
        int priceValue;
        String girlName;

//----Ask for girl's name
        System.out.print("Enter the name of the girl : ");
        girlName = keyboard.next();

//----Create the Girl object and set the girl's name
        Girl girl = new Girl(girlName);

//----Display initial diamond information
        System.out.println(girl);


//----Repeatedly ask for carats and value
        do {
            System.out.print("Enter carats and value     : ");
            caratValue = keyboard.nextInt();
            priceValue = keyboard.nextInt();

//----Create a new diamond and try to give it to the girl
            Diamond newDiamond = new Diamond(caratValue, priceValue);
            girl.acceptDiamond(newDiamond);

//----Display information about the girl and her current diamond
            System.out.println(girl);
            //System.out.println(newDiamond);  // Calls the toString() method of Girl object

        } while (caratValue != 0 && priceValue != 0);
    }
} //End of driver class

