public class ComicBook extends Literature {
    private int serialNumber;
    private String publishDate;
    final private String type;

    ComicBook(String title, String publisher, int serialNumber, String publishDate){
        super(title, publisher);
        this.serialNumber = serialNumber;
        this.publishDate = publishDate;
        type = "Comic book";
    }

    /**
     * Returns the serial number of the comic book.
     *
     * @return The serial number of the comic book.
     */
    public int getSerialNumber(){
        return serialNumber;
    }

    /**
     * Returns the publish date of the comic book.
     *
     * @return The publish date of the comic book.
     */
    public String getPublishDate(){
        return publishDate;
    }

    /**
     * Returns the type of the comic book.
     *
     * @return The type of the comic book.
     */
    public String getType(){
        return type;
    }
}