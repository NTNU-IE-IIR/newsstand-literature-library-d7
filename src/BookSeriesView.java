import java.util.Scanner;

public class BookSeriesView {

    public BookSeriesView(){
    }

    public static void viewBookSeries(BookSeries bookSeries){
        String title = bookSeries.getTitle();
        String seriesTitle = bookSeries.getSeriesTitle();
        String author = bookSeries.getAuthor();
        String date = bookSeries.getPublishDate();
        String publisher = bookSeries.getPublisher();
        String edition = bookSeries.getEdition();

        printInfo(title, author, date, publisher, edition, seriesTitle);
    }

    private static void printInfo(String title, String author, String date, String publisher, String edition, String seriesTitle){
        System.out.println("-------------------------------------");
        System.out.println("Title: " + title
                        + "\nSeries Title: " + seriesTitle
                        + "\nAuthor: " + author
                        + "\nDate: " + date
                        + "\nPublisher: " + publisher
                        + "\nEdition: " + edition);
        System.out.println("-------------------------------------");
    }

    public static Literature addBookSeries(){
        System.out.println("\nWhat is the name of the author?");
        Scanner reader = new Scanner(System.in);
        String author = reader.nextLine();

        System.out.println("\nWhat is the title of the bookseries?");
        String title = reader.nextLine();

        System.out.println("\nWho published the bookseries?");
        String publisher = reader.nextLine();

        System.out.println("\nWhich edition of the bookseries is it?");
        String edition = reader.nextLine();

        System.out.println("\nWhat date was the bookseries published?");
        String date = reader.nextLine();

        System.out.println("\nWhat is the series title?");
        String seriesTitle = reader.nextLine();

        int errors = 0;

        if (author.length() == 0) {
            System.out.println("\nThe bookseries has to have an author");
            errors += 1;
        }
        if (title.length() == 0) {
            System.out.println("\nThe bookseries has to have a title");
            errors += 1;
        }
        if (publisher.length() == 0) {
            System.out.println("\nThe bookseries has to have a publisher");
            errors += 1;
        }
        if (edition.length() == 0) {
            System.out.println("\nYou didn't insert which edition the bookseries was");
            errors += 1;
        }
        if (date.length() == 0) {
            System.out.println("\nYou didn't insert a release date for the book");
            errors += 1;
        }
        if (seriesTitle.length()==0){
            System.out.println("\n The bookseries has to have a seriestitle");
            errors +=1;
        }

        if (errors > 0) {
            System.out.println("\nYou had " + errors + " errors when adding the bookseries, please try again");
            return null;
        }
        return new BookSeries(author, title, publisher, edition, date, seriesTitle);
    }
}