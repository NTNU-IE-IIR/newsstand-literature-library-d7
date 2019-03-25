public class ComicBook extends Literature {
    private int serialNumber;
    private String publishDate;

    ComicBook(String title, String publisher, int serialNumber, String publishDate) {
        super(title, publisher);
        this.serialNumber = serialNumber;
        this.publishDate = publishDate;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getPublishDate() {
        return publishDate;
    }
}