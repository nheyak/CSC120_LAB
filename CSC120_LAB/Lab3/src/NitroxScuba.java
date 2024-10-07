import java.util.Scanner;

//=============================================================================
public class NitroxScuba {
    //-------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //----Declaring constants
    private static final double FEET_PER_ATMOSPHERE = 33;
    private static final double MAX_O2_PRESSURE = 1.4;
    private static final double CONTINGENCY_O2_PRESSURE = 1.6;

    //-------------------------------------------------------------------------
    public static void main(String[] args) {

        //----Variables to hold
        double depth;
        double percentageO2;
        double ambientPressure;
        double oxygenPressure;
        char opgGroup;
        boolean exceedsContingency;
        boolean exceedsMaximal;

//----Gathering data
        System.out.print("Enter depth and percentage O2 : ");
        depth = keyboard.nextDouble();
        percentageO2 = keyboard.nextDouble();

//----Computing PPO2
        ambientPressure = (depth / FEET_PER_ATMOSPHERE) + 1;
        oxygenPressure = (percentageO2 / 100) * ambientPressure;

//----Does it exceed the maximum?

        exceedsMaximal = oxygenPressure > MAX_O2_PRESSURE;

        exceedsContingency = oxygenPressure > CONTINGENCY_O2_PRESSURE;

//----Display warnings – OPG groups
        opgGroup = (char) ((int) (oxygenPressure * 10) + (int) 'A');

//----Display results

        System.out.println("Ambient pressure : " + ambientPressure);
        System.out.println("O2 pressure : " + oxygenPressure);
        System.out.println("O2 group : " + opgGroup);
        System.out.println("Exceeds maximal O2 pressure : " + exceedsMaximal);
        System.out.println("Exceeds contingency O2 pressure : " + exceedsContingency);

    } // end of main method
} // end of class NitroxScuba
//-----------------------------------------------------------------------------
//=============================================================================