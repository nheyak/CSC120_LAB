import java.util.Scanner;

/**
 * Takes input from user about the members in a family and their teeth types and then stores them to use for different operations.
 * @author Nheya Kumar
 */
//=================================================================================================
public class DentalRecords {
    //---------------------------------------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);

    //----Declaring constants
    /** Max number of people in a family is 6 */
    private static final int MAX_FAMILY_MEMBERS = 6;
    /** Max number of teeth per row is 8 */
    private static final int MAX_TEETH = 8;

    /**
     * Main method that prompts user for data about their family and then, depending on which menu item they select, runs an operation with the data collected.
     */

    //---------------------------------------------------------------------------------------------
    public static void main(String[] args) {

//----Declaring variables
        int familySize = 0; // Start with 0 members
        String[][][] familyTeeth;
        String[] familyNames;
        char outputType;

        System.out.println("Welcome to the Floridian Tooth Records");
        System.out.println("--------------------------------------");
        familySize = familySize(); //Storing the number of people in the family to use later in arrays

        // Initializing arrays
        familyTeeth = new String[familySize][][];
        familyNames = new String[familySize];

        // Getting and storing family teeth data
        for (int i = 0; i < familySize; i++) {
            familyNames[i] = getFamilyNames(familyNames, i); // Get family member's name and store it in the array
            teethData(i, familyTeeth, familyNames, familySize); // Pass familyTeeth as an argument
        }

        System.out.println();

        do {
            // Displaying the output that the user wants
            outputType = displayOutput();


            // Use outputType to determine which output method should be performed
            switch (outputType) {
                case 'P':
                    printRecords(familyNames, familyTeeth);
                    // Print new line in between menu options
                    System.out.println();
                    break;
                case 'E':
                    extractTooth(familyNames, familyTeeth, familySize);
                    // Print new line in between menu options
                    System.out.println();
                    break;
                case 'R':
                    reportRootCanals(familyTeeth);
                    // Print new line in between menu options
                    System.out.println();
                    break;
                case 'X':
                    exit();
                    // Print new line in between menu options
                    System.out.println();
                    break;
                default:
                    break; // This is because I have the error message in the displayOutput method, so the returned value can only be one of the 4 above
            }
        } while (outputType != 'X');

    } //End of main method

    /**
     * Gets the family size from the user, ensures it's a valid number, and stores it
     * @return Returns the number of people in the family
     */

    //---------------------------------------------------------------------------------------------
    public static int familySize() {
//----Declaring variables
        int numPeople;

        //Getting number of people in family
        System.out.print("Please enter number of people in the family : ");
        numPeople = keyboard.nextInt();

        //If number is out of bounds, display error and prompt to re-enter value
        while (numPeople > MAX_FAMILY_MEMBERS || numPeople < 0) {
            System.out.print("Invalid number of people, try again         : ");
            numPeople = keyboard.nextInt();
        }

        //Return number of people in family
        return (numPeople);

    } //End of familySize method

    /**
     * Gets the names of family members from the user and stores them in an array
     * @param familyNames The array that the entered names are being stored in
     * @param i Index that can be incremented in the loop in the main method
     * @return Returns the name that goes in the [i] cell of familyNames
     */

    //---------------------------------------------------------------------------------------------
    public static String getFamilyNames(String[] familyNames, int i) {

        System.out.printf("Please enter the name for family member %d   : ", (i + 1));
        familyNames[i] = keyboard.next(); // Store the entered name in the array

        return (familyNames[i]);
    }

    /**
     * Gets input from the user about each family member's teeth types and stores them in a 3D array
     * @param i Index that can be incremented in the loop in the main method
     * @param familyTeeth The array that the teeth types are being stored in
     * @param familyNames The array that holds the names of each family members
     * @param familySize The number of family members
     */

    //---------------------------------------------------------------------------------------------
    public static void teethData(int i, String[][][] familyTeeth, String[] familyNames, int familySize) {
//----Declaring variables
        String lowers;
        String uppers;
        boolean isValid;

        // Initialize the teeth data array for the family member
        familyTeeth[i] = new String[2][MAX_TEETH]; // 2 rows (uppers, lowers), max 8 teeth

        // Prompt for uppers
        System.out.printf("Please enter the uppers for %-16s: ", familyNames[i]);

        // Getting upper teeth data
        while (true) {
            uppers = keyboard.next().toUpperCase(); // Convert to uppercase

            // Validate the upper teeth data
            isValid = true; // Assume valid until proven otherwise
            for (int k = 0; k < uppers.length(); k++) {
                char tooth = uppers.charAt(k);
                if (tooth != 'I' && tooth != 'B' && tooth != 'M') {
                    isValid = false; // Found an invalid character
                    break; // Exit the loop
                }
            }

            // Check the validity and length of the teeth data
            if (isValid && uppers.length() <= MAX_TEETH) {
                // Store upper teeth data
                for (int k = 0; k < uppers.length(); k++) {
                    familyTeeth[i][0][k] = String.valueOf(uppers.charAt(k)); // Store each character at the correct index
                }
                break; // Exit the loop if valid
            } else if (!isValid) {
                System.out.print("Invalid teeth types, try again              : ");
            } else {
                System.out.print("Too many teeth, try again                   : ");
            }
        }

        // Prompt for lowers
        System.out.printf("Please enter the lowers for %-16s: ", familyNames[i]);

        // Getting lower teeth data
        while (true) {
            lowers = keyboard.next().toUpperCase(); // Convert to uppercase

            // Validate the lower teeth data
            isValid = true; // Assume valid until proven otherwise
            for (int k = 0; k < lowers.length(); k++) {
                char tooth = lowers.charAt(k);
                if (tooth != 'I' && tooth != 'B' && tooth != 'M') {
                    isValid = false; // Found an invalid character
                    break; // Exit the loop
                }
            }

            // Check the validity and length of the teeth data
            if (isValid && lowers.length() <= MAX_TEETH) {
                // Store lower teeth data
                for (int k = 0; k < lowers.length(); k++) {
                    familyTeeth[i][1][k] = String.valueOf(lowers.charAt(k)); // Store each character at the correct index
                }
                break; // Exit the loop if valid
            } else if (!isValid) {
                System.out.print("Invalid teeth types, try again              : ");
            } else {
                System.out.print("Too many teeth, try again                   : ");
            }
        }
    } // End of teethData method

    /**
     * Takes the input from the user for which menu option they want to execute
     * @return A character that is assigned to each menu option that determines what operations are run
     */

    //---------------------------------------------------------------------------------------------
    public static char displayOutput() {
//----Declaring variables
        String desiredOutput;
        char outputType;
        boolean isValid;

        // Prompt for what data the user wants
        System.out.printf("%-44s: ", "(P)rint, (E)xtract, (R)oot, e(X)it");

        // Read character and print back error message and re-prompt if entered character isn't a menu option
        do {
            desiredOutput = keyboard.next().toUpperCase();

            // Read data and return Char
            outputType = desiredOutput.charAt(0);

            // Check validity
            isValid = true; // Assume valid until proven otherwise
            if (outputType != 'P' && outputType != 'E' && outputType != 'R' && outputType != 'X') {
                isValid = false;
                System.out.printf("%-44s: ", "Invalid menu option, try again");
            }
        } while (!isValid);

        // Return the character for the type of output the user wants
        return (outputType);

    } //End of displayOutput method

    /**
     * An output method that prints the dental records for the family, or each family member's teeth types
     * @param familyNames The array that holds the names of each family member
     * @param familyTeeth The array that holds the family members' teeth types
     */

    //---------------------------------------------------------------------------------------------
    public static void printRecords(String[] familyNames, String[][][] familyTeeth) {

        // Print new line in between menu options
        System.out.println();

        for (int i = 0; i < familyNames.length; i++) {
            System.out.println(familyNames[i]); // Print family member's name with new line

            // Print Uppers
            System.out.print("  Uppers: ");
            for (int j = 0; j < familyTeeth[i][0].length; j++) {
                if (familyTeeth[i][0][j] != null) { // Only print if not null
                    System.out.printf("%d:%s  ", (j + 1), familyTeeth[i][0][j]); // Print tooth index and type
                }
            }
            System.out.println(); // New line for lowers

            // Print Lowers
            System.out.print("  Lowers: ");
            for (int j = 0; j < familyTeeth[i][1].length; j++) {
                if (familyTeeth[i][1][j] != null) { // Only print if not null
                    System.out.printf("%d:%s  ", (j + 1), familyTeeth[i][1][j]); // Print tooth index and type
                }
            }
            System.out.println(); // New line after printing lowers
        }
    } // End of printRecords method

    /**
     * Removes a tooth (changes the tooth type to Missing) from someone's mouth in the records
     * @param familyNames The array that holds the names of each family members
     * @param familyTeeth The array that holds each family members' teeth types
     * @param familySize The number of family members
     */

    //---------------------------------------------------------------------------------------------
    public static void extractTooth(String[] familyNames, String[][][] familyTeeth, int familySize) {

//----Declaring variables
        String inputName;
        boolean nameInList = false;
        boolean isValid = false;
        boolean validLayer = false;
        String layerInput;
        char extractionLayer;
        int layerIndex = -1;
        int matchedIndex = -1;
        int toothNumber = -1;

        // Prompt input name
        System.out.print("Which family member                         : ");

        do {
            inputName = keyboard.next();

            // Check input with names in array and find the matched index
            for (int j = 0; j < familySize; j++) {
                if (familyNames[j].equalsIgnoreCase(inputName)) {
                    matchedIndex = j;  // Store the matched index
                    nameInList = true; // Set foundMatch to true if a match is found
                    isValid = true;    // Mark as valid
                    break;             // Exit the loop
                }
            }

            // Print error message if not in list
            if (!nameInList) {
                System.out.print("Invalid family member, try again            : ");
                isValid = false;
            }
        } while (!isValid);

        // Prompt for tooth layer (upper or lower)
        System.out.print("Which tooth layer (U)pper or (L)ower        : ");

        // Test if input is valid, if not get new input
        do {
            layerInput = keyboard.next().toUpperCase();
            extractionLayer = layerInput.charAt(0);

            if (extractionLayer != 'U' && extractionLayer != 'L') {
                System.out.print("Invalid layer, try again                    : ");
                validLayer = false;
            } else {
                validLayer = true;
            }
        } while (!validLayer);

        // Set layerIndex based on layer selection: 0 for upper, 1 for lower
        layerIndex = (extractionLayer == 'U') ? 0 : 1;

        // Prompt for tooth number and validate
        System.out.print("Which tooth number                          : ");
        boolean validToothNumber = false;

        do {
            toothNumber = keyboard.nextInt();

            if (toothNumber < 1 || toothNumber > 8) {
                System.out.print("Invalid tooth number, try again             : ");
            } else if (familyTeeth[matchedIndex][layerIndex][toothNumber - 1] == null) {
                System.out.print("Invalid tooth number, try again             : ");
            } else if (familyTeeth[matchedIndex][layerIndex][toothNumber - 1].equals("M")) {
                System.out.print("Missing tooth, try again                    : ");
            } else {
                validToothNumber = true;
            }
        } while (!validToothNumber);

        familyTeeth[matchedIndex][layerIndex][toothNumber - 1] = "M";

    }

    /**
     * Calculates the Root Canal Indices for the entire family and displays them
     * @param familyTeeth The array that holds each family members' teeth types
     */

    //---------------------------------------------------------------------------------------------
    public static void reportRootCanals(String[][][] familyTeeth) {
//----Declaring variables
        int countI = 0;
        int countB = 0;
        int countM = 0;
        double a;
        double b;
        double c;
        double root1 = 0;
        double root2 = 0;
        double discriminant;

        // Iterate through each family member
        for (int i = 0; i < familyTeeth.length; i++) {
            // Iterate through each layer (upper and lower)
            for (int j = 0; j < familyTeeth[i].length; j++) {
                // Iterate through each tooth in the layer
                for (int k = 0; k < familyTeeth[i][j].length; k++) {
                    // Check the value in the tooth cell and increment the appropriate counter
                    if (familyTeeth[i][j][k] != null) { // Ensure the value is not null
                        switch (familyTeeth[i][j][k]) {
                            case "I":
                                countI++;
                                break;
                            case "B":
                                countB++;
                                break;
                            case "M":
                                countM++;
                                break;
                        }
                    }
                }
            }
        }

        a = (double) countI;
        b = (double) countB;
        c = (double) -(countM);

        // Calculate the discriminant
        discriminant = b * b - (4 * a * c);

        // Check if the discriminant is non-negative
        if (discriminant >= 0) {
            // Calculate the two roots
            root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            // Print the roots using printf for proper formatting
            System.out.printf("One root canal at %.2f%n", root1);
            System.out.printf("Another root canal at %.2f%n", root2);

        } else {
            System.out.println("No real roots, the discriminant is negative.");
        }
    }

    /**
     * Prints exit message
     */

    //---------------------------------------------------------------------------------------------
    public static void exit() {
        System.out.println();
        System.out.print("Exiting the Floridian Tooth Records :-)");
    } //End of exit method
    //---------------------------------------------------------------------------------------------
} // End of DentalRecords class