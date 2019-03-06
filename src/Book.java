/**
 * This class can store information about different books that gets
 * added to the class.
 */
public class Book {
    /**
     * The fields for the class
     */
    private String author;
    private String title;
    private String publisher;
    private String edition;
    private String publishDate;
    private String seriesTitle;
    private boolean isSeries;

    /**
     * The constructor of the class.
     * @param author      the author
     * @param title       the title
     * @param publisher   the publisher
     * @param edition     the edition
     * @param publishDate the publish date
     */
    public Book(String author, String title, String publisher, String edition, String publishDate) {
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.edition = edition;
        this.publishDate = publishDate;
    }

    /**
     * Instantiates a new Book.
     *
     * @param author      the author
     * @param title       the title
     * @param publisher   the publisher
     * @param edition     the edition
     * @param publishDate the publish date
     * @param seriesTitle  the series title
     */
    public Book(String author, String title, String publisher, String edition, String publishDate, String seriesTitle) {
        this.author = author;
        this.title = title;
        this.seriesTitle = seriesTitle;
        this.publisher = publisher;
        this.edition = edition;
        this.publishDate = publishDate;
        this.isSeries = true;
    }

    /**
     * Return the author
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns the book-title.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the books publisher.
     *
     * @return The publisher.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Returns the edition of the book.
     *
     * @return the edition of the book.
     */
    public String getEdition() {
        return edition;
    }

    /**
     * Returns the publishing date of the book.
     *
     * @return The publishing date of the book.
     */
    public String getPublishDate() {
        return publishDate;
    }

    /**
     * Gets series title.
     *
     * @return the series title.
     */
    public String getSeriesTitle() {
        return seriesTitle;
    }


    /**
     * Convert to series.
     *
     * @param seriesTitle the series title

    private void convertToSeries(String seriesTitle) {
        if (!isSeries) {
            isSeries = true;
            this.seriesTitle = seriesTitle;
        } else {
            System.out.println("The book is already a series");
        }
    }**/

    /**
     * Is series boolean.
     *
     * @return the boolean
     */
    public boolean isSeries(){
        return isSeries;
    }
}