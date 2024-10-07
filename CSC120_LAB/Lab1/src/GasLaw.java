import java.util.Scanner;
//=============================================================================
public class GasLaw {
    //-----------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);
    //----The gas constant in Joules/mole/K
    private static final double GAS_CONSTANT = 8.3143;

    //-----------------------------------------------------------------------------
    public static void main(String[] args) {

//----Variables to hold system values
        double volume, moles, temperature;
        double pressure;

//----Gathering data
        System.out.print("Enter volume, moles, temperature : ");
        volume = keyboard.nextDouble();
        moles = keyboard.nextDouble();
        temperature = keyboard.nextDouble();

//----Calculations
        pressure = moles * GAS_CONSTANT * temperature / volume;

//----Display results
        System.out.println("Pressure is " + pressure);
    } // end of main method
} // end of class GasLaw
//-----------------------------------------------------------------------------
//=============================================================================