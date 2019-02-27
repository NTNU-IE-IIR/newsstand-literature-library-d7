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
    private boolean isSerie;

    /**
     * <ul>
     * The constructor of the class.
     * <li> @param author The author of the book.</li>
     * <li> @param title The title of the book.</li>
     * <li> @param edition The volume/edition of the book</li>
     * <li> @param publishDate The date the book was published.</li>
     * <li> @param publisher The publisher of the book</li>
     * </ul>
     *
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
     * @param serieTitle  the serie title
     */
    public Book(String author, String title, String publisher, String edition, String publishDate, String serieTitle) {
        this.author = author;
        this.title = title;
        this.seriesTitle = serieTitle;
        this.publisher = publisher;
        this.edition = edition;
        this.publishDate = publishDate;
        this.isSerie = true;
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
     * @return The publiser.
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
     * Gets serie number.
     *
     * @return the serie title.
     */
    public String getSeriesTitle() {
        return seriesTitle;
    }


    /**
     * Convert to series.
     *
     * @param seriesTitle the series title
     */
    public void convertToSeries(String seriesTitle) {
        if (!isSerie) {
            isSerie = true;
            this.seriesTitle = seriesTitle;
        } else {
            System.out.println("The book is already a series");
        }
    }

    public boolean isSeries(){
        return isSerie;
    }
}