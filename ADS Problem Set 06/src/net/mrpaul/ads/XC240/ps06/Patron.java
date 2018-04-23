package net.mrpaul.ads.XC240.ps06;

/**
 * Creates patrons
 * Creates a patron class for book holders
 * <p>
 * ADSA PS06: Patron
 * 4/21/18
 *
 * @author Sujay Swain
 */
public class Patron {
    //Declaration of variables
    private String patron;
    private Book b1;
    private Book b2;
    private Book b3;

    /**
     * Creates Patron object
     * Creates and initialization of a Patron object
     * <p>
     * @author Sujay Swain
     */
    public Patron() {
        this.patron = "";
        this.b1 = new Book();
        this.b2 = new Book();
        this.b3 = new Book();
    }

    /**
     * Creates Patron object with info
     * Creates and initialization of a Patron object with a name
     * <p>
     * @author Sujay Swain
     */
    public Patron(String patronName) {
        this.patron = patronName;
        this.b1 = new Book();
        this.b2 = new Book();
        this.b3 = new Book();
    }

    /**
     * Borrows a book
     * Checks out a book to a patron, but prevents checking out book if three are already checked out
     * <p>
     * @author Sujay Swain
     * @param title
     * @return boolean
     */
    public boolean borrow(String title) {
        if (this.b1.getTitle().equals("")) {
            this.b1 = new Book(title);
            return true;
        }
        else if (this.b2.getTitle().equals("")) {
            this.b2 = new Book(title);
            return true;
        }
        else if (this.b3.getTitle().equals("")) {
            this.b3 = new Book(title);
            return true;
        }
        else {
            return false;
        }

    }

    /**
     * Checks book status
     * Checks to see if a patron has a book checked out
     * <p>
     * @author Sujay Swain
     * @param title
     * @return boolean
     */
    public boolean checkedOut(String title) {
        if (this.b1.getTitle().equals(title)) {
            return true;
        }
        else if (this.b2.getTitle().equals(title)) {
            return true;
        }
        else if (this.b3.getTitle().equals(title)) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks in a book
     * Checks in a book to a patron
     * <p>
     * @author Sujay Swain
     * @param title
     * @return boolean
     */
    public boolean checkIn(String title) {
        if (this.b1.getTitle().equals("")) {
            this.b1.setTitle(title);
            return true;
        }
        else if (this.b2.getTitle().equals("")) {
            this.b2.setTitle(title);
            return true;
        }
        else if (this.b3.getTitle().equals("")) {
            this.b3.setTitle(title);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Returns info as a string
     * Returns patron and book info as a string
     * <p>
     * @author Sujay Swain
     * @return returnString
     */
    public String toString() {
        String returnString = patron + ", " + b1 + ", " + b2 + ", " + b3;
        return returnString;
    }
}
