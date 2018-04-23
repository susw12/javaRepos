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
    //Variable declaration
    private String title;
    private String author;

    /**
     * Initializes Book object
     *
     * Initializes an empty book object
     * <p>
     * @author Sujay Swain
     */
    public Book() {
        title = "";
        author = "";
    }

    /**
     * Initializes Book object with title
     *
     * Initializes a book object with a title, but no author
     * <p>
     * @author Sujay Swain
     *
     * @param title
     */
    public Book(String title) {
        this.title = title;
        author = "";
    }

    /**
     * Initializes Book, title and author
     *
     * Initializes a book object with a title, but no author
     * <p>
     * @author Sujay Swain
     *
     * @param author
     * @param title
     */
    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    /**
     * Gets author value
     * Gets value for author
     * <p>
     * @author Sujay Swain
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets title value
     * Gets value for title
     * <p>
     * @author Sujay Swain
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets author value
     * Sets value for author
     * <p>
     * @author Sujay Swain
     *
     * @param author
     *
     */
    public void setAuthor(String author) {
        if (this.toString().equals(", ")) {
            this.author = author;
        }
    }

    /**
     * Sets title value
     * Sets value for title
     * <p>
     * @author Sujay Swain
     * @param title
     *
     */
    public void setTitle(String title) {
        if (this.toString().equals(", ")) {
            this.title = title;
        }
    }

    /**
     * Return the string version
     * Returns the title and author as a string
     * <p>
     * @author Sujay Swain
     *
     * @return string value
     */
    public String toString() {
        String returnValue = title + ", " + author;
        return returnValue;
    }
}
