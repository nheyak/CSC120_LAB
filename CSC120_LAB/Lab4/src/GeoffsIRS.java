import java.util.Scanner;
//=================================================================
public class GeoffsIRS {
    //-------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);

    //----Declaring constants
    private static final double STINKING_RICH = 500000;
    private static final double QUITE_RICH = 200000;
    private static final double MIAMI_POOR = 100000;
    private static final double AVERAGE = 50000;
    private static final double REALISTIC = 20000;
    private static final double HIGH_TAX_RATE = 0.25;
    private static final double MEDIUM_TAX_RATE = 0.10;
    private static final double LOW_TAX_RATE = 0.03;

    //-----------------------------------------------------------------
    public static void main(String[] Args) {
//----Declaring variables
        double income = 0;
        double deduction = 0;
        double input;
        double taxableIncome;
        char taxGroup;
        double tax;

//----Get inputs
        do {                                                   //1. Input income and deduction
            System.out.print("Enter next amount : ");          //1.1.1 Prompt user
            input = keyboard.nextDouble();                     //1.1.2 Input value
            if (input < 0) {                                   //1.1.4 If negative
                deduction += Math.abs(input);                  //1.1.4.1 Add (absolute) to deduction
            } else if (input > 0) {                            //1.1.3 If positive
                income += input;                               //1.1.3.1 Add to income
            }
        } while (input != 0);                                  //1.1 Repeatedly until 0.0 is entered

//----Run methods
        taxableIncome = computeTaxableIncome(income, deduction);
        taxGroup = chooseTaxGroup(taxableIncome);
        tax = computeTax(taxableIncome, taxGroup);
        displayOutput(income, deduction, taxableIncome, taxGroup, tax);

    } // End of main method--------------------------------------------

    //-----------------------------------------------------------------
    public static double computeTaxableIncome(double income, double deduction) {
        double taxableIncome;

//----2.1 & 2.2 Compute taxable income if/else
        if (income >= deduction) {                             //2.1 If income >= deduction then taxable is income - deduction, else
            taxableIncome = income - deduction;
        } else {
            taxableIncome = 0.0;                               //2.2 Taxable is 0.0
        }
        return taxableIncome;
    } //End of computing taxable income--------------------------------

    //-----------------------------------------------------------------
    public static char chooseTaxGroup(double taxableIncome) {
        char taxGroup;

        if (taxableIncome >= STINKING_RICH) {          //3.1 If taxable >= 500000
            taxGroup = 'S';                            //3.1.1 Group is S, else
        } else if (taxableIncome >= QUITE_RICH) {      //3.2 If taxable >= 200000
            taxGroup = 'Q';                            //3.2.1 Group is Q, else
        } else if (taxableIncome >= MIAMI_POOR) {      //3.3 If taxable >= 100000
            taxGroup = 'M';                            //3.3.1 Group is M, else
        } else if (taxableIncome >= AVERAGE) {         //3.4 If taxable >= 50000
            taxGroup = 'A';                            //3.4.1 Group is A, else
        } else if (taxableIncome >= REALISTIC) {       //3.5 If taxable >= 20000
            taxGroup = 'R';                            //3.5.1 Group is R, else
        } else {                                       //3.6 Group is P
            taxGroup = 'P';
        }

        return taxGroup;
    } //End of tax group method----------------------------------------

    //-----------------------------------------------------------------
    public static double computeTax(double taxableIncome, char taxGroup) {
        double tax;

        switch (taxGroup) {                             //4.1 Depending on the group
            case 'S':                                   //4.1.1 For S and Q
            case 'Q':
                tax = taxableIncome * HIGH_TAX_RATE;    //4.1.1.1 Tax is 25% of taxable
                break;

            case 'M':                                   //4.1.2 For M
                tax = taxableIncome * MEDIUM_TAX_RATE;  // 4.1.2.1 Tax is 10% of taxable
                break;

            case 'A':                                   //4.1.3 For A and R
            case 'R':
                tax = taxableIncome * LOW_TAX_RATE;     //4.1.3.1 Tax is 3% of taxable
                break;

            case 'P':                                   //4.1.4 For P
                tax = 0.0;                              //4.1.4.1 Tax is 0.0
                break;

            default:                                    //4.1.5 For other groups
                System.out.println("Error: No tax group matched");
                tax = 0.0;                              //4.1.5.1 Error!
        }
        return tax;
    } //End of computing tax method------------------------------------

    //-----------------------------------------------------------------
    public static void displayOutput(double income, double deduction, double taxableIncome, char taxGroup, double tax) {
        System.out.println();
        System.out.println("Income = $" + income);                   //5.1 Display income
        System.out.println("Deductions = $" + deduction);            //5.2 Display deduction
        System.out.println("Taxable income = $" + taxableIncome);    //5.3 Display taxable
        System.out.println("Tax group = " + taxGroup);               //5.4 Display group
        System.out.println("Tax owed = $" + tax);                    //5.5 Display tax
    } //End of display method------------------------------------------
} //End of class-------------------------------------------------------
//=====================================================================