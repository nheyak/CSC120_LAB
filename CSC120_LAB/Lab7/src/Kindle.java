public class Kindle {
    //---------------------------------------------------------------------------------------------
    private int currentPage;
    private int totalPages;

    //---------------------------------------------------------------------------------------------
    public Kindle(int numberOfPages){
        currentPage = 1;
        totalPages = numberOfPages;
    }

    public void turnPages(int numberOfPages) {
        if (currentPage + numberOfPages > totalPages) {
            System.out.println("You were on                : " + toString());
            System.out.println("Turning " + numberOfPages + " pages would take you past the last page.");
            currentPage = totalPages; // Move to the last page
            System.out.println("You are now on             : " + toString());
        } else {
            currentPage += numberOfPages; // Increment the current page by the amount
        }
    }

    public void turnPages(){
        turnPages(1);
    }

    public String toString() {
        return "Page " + currentPage + " of " + totalPages + ".";
    }
}