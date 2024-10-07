import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;
//=================================================================

/**
 * Gets input on the number of houses on a street, the number of people living in each house, and the age of each person to add them up and find the total age of the street.
 * @author Nheya Kumar
 */
//=================================================================
public class StreetAge {


    //-------------------------------------------------------------
    private static final Scanner keyboard = new Scanner(System.in);

    /**
     * Main method that takes inputs on the number of houses, number of people in each house, and ages of those people to then calculate the total combined age of each house and the total combined age of the street.
     */

    //-------------------------------------------------------------
    public static void main(String[] Args) {

//----Declaring private variables in the class to be used in the main method
        int numHouses = 0;        // Total number of houses
        int[] houseNumbers = new int[numHouses];    // Array for house numbers
        int[][] houseAges = new int[numHouses][]; // 2D Array for ages of people in houses

        //----Getting num of houses
        System.out.print("How many houses in the street? : ");
        numHouses = keyboard.nextInt();
        System.out.println();

//----Initializing variables after seeing number of houses
        houseNumbers = new int[numHouses];
        houseAges = new int[numHouses][];

//----Getting house numbers
        for (int i = 0; i < numHouses; i++) {
            System.out.print("What is the next house number? : ");
            houseNumbers[i] = keyboard.nextInt();
        }
        System.out.println();

        for (int i=0; i<numHouses; i++) {
            System.out.print("How many people live in number " + houseNumbers[i] + "? : ");
            int numPeople = keyboard.nextInt();

//--------Columns in the array
            houseAges[i] = new int[numPeople];

//--------Get each person's age
            for (int j = 0; j < numPeople; j++) {
                System.out.print("What is the age of person " + (j + 1) + " in house " + (i + 1) + ": ");
                houseAges[i][j] = keyboard.nextInt();
            }
            System.out.println();
        }

//----Declaring more variables
        int[] houseSum = new int[numHouses];
        int streetSum = 0;

//----Loop through each house (row in houseAges)
        for (int i = 0; i < numHouses; i++) {
//--------Loop through each person's age in the current house (row)
            for (int j = 0; j < houseAges[i].length; j++) {
                houseSum[i] += houseAges[i][j];  // Add each person's age to the sum
            }

//--------Print the total age for the current house
            System.out.println("House " + houseNumbers[i] + " has a total age of : " + houseSum[i]);
        }

        for (int i = 0; i < numHouses; i++) {
            for (int j = 0; j < houseAges[i].length; j++) {
                streetSum += houseAges[i][j];
            }
        }
        System.out.println();
        System.out.println("The street has a total age of : " + streetSum);

    } //End of main method
    //-------------------------------------------------------------
} // End of class
