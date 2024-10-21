import java.util.Scanner;

public class IAm {

    public static void main(String[] args) {
        String qualities = "";  // String to hold all the qualities
        Scanner keyboard = new Scanner(System.in);

        // Display prompt to enter sentences
        System.out.println("Please enter a sentence, . to end.");

        // Loop to repeatedly read input until a period is entered
        while (true) {
            String sentence = keyboard.nextLine();

            // Stop the loop if input is "."
            if (sentence.equals(".")) {
                break;
            }

            // Check if the sentence starts with "I am "
            if (sentence.startsWith("I am ")) {
                // Extract the quality (substring after "I am ")
                String quality = sentence.substring(5);

                // Append the quality to the qualities string
                if (!qualities.isEmpty()) {
                    qualities += quality + ", ";
                } else {
                    qualities = quality + ", ";
                } // End of if else
            } // End of if
        } // End of while

        // Output the final string of qualities
        System.out.println("The qualities are " + qualities);
    } // End of main method
} // End of IAm Class


