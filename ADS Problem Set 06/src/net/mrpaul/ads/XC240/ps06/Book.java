package net.mrpaul.ads.XC240.ps06;

/**
 * Records books and authors.
 *
 * Creates a system in which books and authors can be recorded.
 * <p>
 * ADSA PS06: Book
 * 4/21/18
 *
 * @author Sujay Swain
 */

public class Book {
    private String title;
    private String author;

    public Book() {
        title = "";
        author = "";
    }

    public Book(String title) {
        this.title = title;
        author = "";
    }

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        if (this.toString().equals(", ")) {
            this.author = author;
        }
    }

    public void setTitle(String title) {
        if (this.toString().equals(", ")) {
            this.title = title;
        }
    }

    public String toString() {
        String returnValue = title + ", " + author;
        return returnValue;
    }
}
