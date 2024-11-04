import java.util.ArrayList;
//======================================================================================================================
public class ExceptionalIntegers {
    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
//----Create ArrayList
        ArrayList<Integer> integerList = new ArrayList<>();

        for (String arg : args) {
            try {
                Integer intObj = convertToInt(arg);
                integerList.add(intObj);
            } catch (NumberFormatException e) {
                System.out.println("Catch block says the argument \"" + arg + "\" is ignored because " + arg);
            }
        }

        System.out.println("\nThe ArrayList contents are:");
        for (int i = 0; i < integerList.size(); i++) {
            System.out.println("Item " + i + " is " + integerList.get(i));
        }

    } //End of main method
    //------------------------------------------------------------------------------------------------------------------
    public static Integer convertToInt(String str) throws NumberFormatException {
//----Declaring the variable with parse
        int number = Integer.parseInt(str);  // Convert string to int using Integer.parseInt()

        System.out.println("Converter method says integer OK - " + number);
        return Integer.valueOf(number);  // Return Integer object
    } //End of convertToInt method
} //End of ExceptionalIntegers class
