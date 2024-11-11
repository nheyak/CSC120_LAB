class Girl {
//----Defining variables
    String name;
    Diamond diamond;

//----Constructor
    public Girl (String girlName) {
        name = girlName;
        diamond = null;
    }

//----Convert printGirlInfo() to toString() method for Girl class
    public String toString() {
        if (diamond == null) {
            return name + "has no best friend";  // If no diamond, print this message
        } else {
            return name + " has a diamond, " + diamond;
        }
    }


//----Accept a new diamond if it's more valuable than the current one
    public void acceptDiamond(Diamond newDiamond) {
        if (diamond == null || newDiamond.getValue() > diamond.getValue()) {
            diamond = newDiamond; // Accept the new diamond
            System.out.println("Woohoo, the girl took the diamond");
        } else {
            System.out.println("Aaargh, the diamond was rejected");
        }
    }

} //End of Girl class