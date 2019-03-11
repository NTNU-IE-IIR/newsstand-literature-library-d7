public class BookSeriesView {
    private BookSeries bookSeries;

    public BookSeriesView(BookSeries book){
        this.bookSeries = book;
        viewBook();
    }

    private void viewBook(){
        String title = bookSeries.getTitle();
        String seriesTitle = bookSeries.getSeriesTitle();
        String author = bookSeries.getAuthor();
        String date = bookSeries.getPublishDate();
        String publisher = bookSeries.getPublisher();
        String edition = bookSeries.getEdition();

        printInfo(title, author, date, publisher, edition, seriesTitle);
    }

    private void printInfo(String title, String author, String date, String publisher, String edition, String seriesTitle){
        System.out.println("-------------------------------------");
        System.out.println("Title: " + title
                        + "\nSeries Title: " + seriesTitle
                        + "\nAuthor: " + author
                        + "\nDate: " + date
                        + "\nPublisher: " + publisher
                        + "\nEdition: " + edition);
        System.out.println("-------------------------------------");
    }
}
