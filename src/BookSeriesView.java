import java.util.Scanner;

abstract public class BookSeriesView {

    public BookSeriesView() {
    }

    public static void viewBookSeries(BookSeries bookSeries) {
        String title = bookSeries.getTitle();
        String seriesTitle = bookSeries.getSeriesTitle();
        String author = bookSeries.getAuthor();
        String date = bookSeries.getPublishDate();
        String publisher = bookSeries.getPublisher();
        String edition = bookSeries.getEdition();

        printInfo(title, author, date, publisher, edition, seriesTitle);
    }

    private static void printInfo(String title, String author, String date, String publisher, String edition, String seriesTitle) {
        System.out.println("-------------------------------------");
        System.out.println("Bookseries" +
                "\nTitle: " + title
                + "\nSeries Title: " + seriesTitle
                + "\nAuthor: " + author
                + "\nDate: " + date
                + "\nPublisher: " + publisher
                + "\nEdition: " + edition);
        System.out.println("-------------------------------------");
    }

    public static Literature addBookSeries() {
        System.out.println("\nADD A NEW BOOKSERIES:");

        System.out.println("\nWhat is the name of the author?");
        Scanner reader = new Scanner(System.in);
        String author = reader.nextLine();
        while (author.isEmpty()) {
            author = reader.nextLine();
        }

        System.out.println("\nWhat is the title of the bookseries?");
        String title = reader.nextLine();
        while (title.isEmpty()) {
            title = reader.nextLine();
        }

        System.out.println("\nWho published the bookseries?");
        String publisher = reader.nextLine();
        while (publisher.isEmpty()) {
            publisher = reader.nextLine();
        }

        System.out.println("\nWhich edition of the bookseries is it?");
        String edition = reader.nextLine();
        while (edition.isEmpty()) {
            edition = reader.nextLine();
        }

        System.out.println("\nWhat date was the bookseries published?");
        String date = reader.nextLine();
        while (date.isEmpty()) {
            date = reader.nextLine();
        }

        System.out.println("\nWhat is the series title?");
        String seriesTitle = reader.nextLine();
        while (seriesTitle.isEmpty()) {
            seriesTitle = reader.nextLine();
        }

        return new BookSeries(author, title, publisher, edition, date, seriesTitle);
    }
}