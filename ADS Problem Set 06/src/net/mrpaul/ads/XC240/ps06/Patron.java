package net.mrpaul.ads.XC240.ps06;
import net.mrpaul.ads.XC240.ps06.Book;
public class Patron {
    private String patron;
    private Book b1;
    private Book b2;
    private Book b3;

    public Patron() {
        this.patron = "";
        this.b1 = new Book();
        this.b2 = new Book();
        this.b3 = new Book();
    }

    public Patron(String patronName) {
        this.patron = patronName;
        this.b1 = new Book();
        this.b2 = new Book();
        this.b3 = new Book();
    }

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


    public String toString() {
        String returnString = patron + ", " + b1 + ", " + b2 + ", " + b3;
        return returnString;
    }
}
