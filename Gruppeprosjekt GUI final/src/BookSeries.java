public class BookSeries extends Book{
    private String seriesTitle;
    final public String type = "Bookseries";

    public BookSeries(String author, String title, String publisher, String edition, String publishDate, String seriesTitle){
            super(author, title, publisher, edition, publishDate);
            this.seriesTitle = seriesTitle;
    }

    /**
     * Returns the seriestitle of the bookseries.
     *
     * @return The seriestitle of the bookseries.
     */
    public String getSeriesTitle(){
        return seriesTitle;
    }

    /**
     * Returns the type of the bookseries.
     *
     * @return The type of the bookseries.
     */
    public String getType(){
        return type;
    }
}