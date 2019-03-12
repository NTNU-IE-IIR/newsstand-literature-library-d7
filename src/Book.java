/**
 * This class can store information about different books that gets
 * added to the class.
 */
public class Book extends Literature {
    /**
     * The fields for the class
     */
    protected String author;
    protected String edition;
    protected String publishDate;
    protected String seriesTitle;
    protected boolean isSeries;

    /**
     * The constructor of the class.
     *
     * @param author      the author
     * @param title       the title
     * @param publisher   the publisher
     * @param edition     the edition
     * @param publishDate the publish date
     */
    public Book(String author, String title, String publisher, String edition, String publishDate) {
        super(title, publisher);
        this.author = author;
        this.title = title;
        this.edition = edition;
        this.publishDate = publishDate;
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
     */

    public Book convertToSeries(String seriesTitle) {
        Book book = null;
        if (!(this instanceof BookSeries)) {
            book = new BookSeries(author, title, publisher, edition, publishDate, seriesTitle);
        }
        return book;
    }

    /**
     * Is series boolean.
     *
     * @return the boolean
     */
    public boolean isSeries() {
        return isSeries;
    }
}