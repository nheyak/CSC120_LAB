import java.util.Scanner;
//=================================================================================================
public class KillingKangaroos {
    //---------------------------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //----Roadkill Probability Constant is 1.47
    private static final double ROADKILL_PROBABILITY_CONSTANT = 1.47;
    //----Road width is 10m (0.01 km)
    private static final double ROAD_WIDTH = 0.01;
//-------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold
        double squareSide;
        double roadsLength;
        double numRoos;
        double rooDensity;
        double parcelSize;
        double surfaceArea;
        double numKills;
        double numInjuries;

//----Get data
        System.out.print ("Enter side of square in km : ");
        squareSide = keyboard.nextDouble();
        System.out.print("Enter roads length in km : ");
        roadsLength = keyboard.nextDouble();
        System.out.print("Enter number of 'roos : ");
        numRoos = keyboard.nextDouble();

//----Calculate
        parcelSize = (squareSide * squareSide);
        rooDensity = numRoos / parcelSize;
        surfaceArea = roadsLength * ROAD_WIDTH;
        numKills = (rooDensity * surfaceArea * ROADKILL_PROBABILITY_CONSTANT);
        numInjuries = (numKills % 1);

//----Display results
        if (numInjuries > 0) {
            System.out.println ("Expected number of kills is : " + (int)numKills);
            System.out.println ("Expected number of injuries is : 1");
        } else if (numInjuries == 0) {
            System.out.println ("Expected number of kills is : " + (int)numKills);
            System.out.println ("Expected number of injuries is : 0");
        }
    } // end of main method
} // end of class KillingKangaroos
//----------------------------------------------------------------------------------------------
//==============================================================================================
