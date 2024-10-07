import java.util.Scanner;
//===================================================================================
/**
 * Gets a sequence of numbers and determines whether each number is a Prime or Fibonacci number.
 * @author Nheya Kumar
 */
public class FascinatingNumbers {


    //-------------------------------------------------------------------------------
    public static final Scanner keyboard = new Scanner(System.in);

    //----Declaring constants
    public static final int MAX_INTEGERS = 10;
    /**
     * Main method that takes inputs and tests them individually and then prints whether the numbers are Prime or Fibonacci
     */
    //-------------------------------------------------------------------------------
    public static void main(String[] Args) {



//----Declaring variables
        int[] numbers = new int[MAX_INTEGERS];
        int i;
        boolean isFibonacci;
        boolean isPrime;
        int count;

//----Taking inputs and bringing them into main method

        count = getInputs(numbers);
        System.out.println ("Integers entered: " + (count-1));

//----Testing each number in a for loop and printing the results
        for (i = 0; i < count - 1; i++){
           isFibonacci = isFibonnaci(numbers[i]);
           System.out.println(numbers[i] + " is Fibonacci: " + isFibonacci);
           isPrime = isPrime(numbers[i]);
           System.out.println(numbers[i] + " is Prime: " + isPrime);
        }

    } // end of main method

    //-------------------------------------------------------------------------------

    /**
     * Gets the inputs from the user and stores them in the array
     * @param numbers From the user
     * @return Returns the number of integers entered by the user and stored in the array
     */

    public static int getInputs(int[] numbers) {
//----Gets inputs and puts them into array
        int index = 0;
        int count;

    //----Gather inputs
        System.out.print ("Input numbers (0 to stop): ");
        do {
            numbers[index] = keyboard.nextInt();
            index++;
        } while (numbers[index - 1] != 0 && index < MAX_INTEGERS);

    //----Count how many integers entered

        count = index;
        return count;
    }

    //------------------------------------------------------------------------------

    /**
     * Tests whether the number being tested is a Fibonacci number
     * @param number From the user
     * @return Returns a true or false value for whether the number is Fibonacci or not
     */

    public static boolean isFibonnaci (int number) {
//----Tests if number is Fibonacci

        long previous = 1;
        long current = 0;
        long next;

        while (current < number) {
            next = current + previous;
            previous = current;
            current = next;
        }

        return (current == number);
    }

    //--------------------------------------------------------------------------------

    /**
     * Tests whether the number being tested is a Prime number
     * @param number From the user
     * @return Returns a true or false value for whether the number is Prime or not
     */

    public static boolean isPrime (int number) {
        long divisor = 2;

        while (divisor <= Math.sqrt(number)) {
            if (number % divisor == 0) {
                return(false);
            }
            divisor++;
        }
        return(true);
    }
}
