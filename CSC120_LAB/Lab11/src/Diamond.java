class Diamond {

//----Defining variables for diamond's value and carat
    private int carat;
    private int value;

//----Constructor to initialize carat and value
    public Diamond(int caratValue, int priceValue) {
        carat = caratValue;
        value = priceValue;
    }

//----Getter for carat
    public int getCarat() {
        return carat;
    }

//----Getter for value
    public int getValue() {
        return value;
    }

//----Convert printDiamondInfo() to toString() method for Diamond class
    public String toString() {
        return String.format(carat + " carats, worth $" + value);  // Format the diamond's carat and value
    }

} //End of Diamond Class