import java.util.Scanner;

public class BookView {

    public BookView(){
    }

    public static void viewBook(Book book){
        String title = book.getTitle();
        String author = book.getAuthor();
        String date = book.getPublishDate();
        String publisher = book.getPublisher();
        String edition = book.getEdition();

        printInfo(title, author, date, publisher, edition);
    }

    private static void printInfo(String title, String author, String date, String publisher, String edition){
        System.out.println("-------------------------------------");
        System.out.println("Title: " + title
                        + "\nAuthor: " + author
                        + "\nDate: " + date
                        + "\nPublisher: " + publisher
                        + "\nEdition: " + edition);
        System.out.println("-------------------------------------");
    }

    public static Literature addBook(){
        System.out.println("\nWhat is the name of the author?");
        Scanner reader = new Scanner(System.in);
        String author = reader.nextLine();

        System.out.println("\nWhat is the title of the book?");
        String title = reader.nextLine();

        System.out.println("\nWho published the book?");
        String publisher = reader.nextLine();

        System.out.println("\nWhich edition of the book is it?");
        String edition = reader.nextLine();

        System.out.println("\nWhat date was the book published?");
        String date = reader.nextLine();

        int errors = 0;

        if (author.length() == 0) {
            System.out.println("\nThe book has to have an author");
            errors += 1;
        }
        if (title.length() == 0) {
            System.out.println("\nThe book has to have a title");
            errors += 1;
        }
        if (publisher.length() == 0) {
            System.out.println("\nThe book has to have a publisher");
            errors += 1;
        }
        if (edition.length() == 0) {
            System.out.println("\nYou didn't insert which edition the book was");
            errors += 1;
        }
        if (date.length() == 0) {
            System.out.println("\nYou didn't insert a release date for the book");
            errors += 1;
        }

        if (errors > 0) {
            System.out.println("\nYou had " + errors + " errors when adding the book, please try again");
            return null;
        }
        return new Book(author, title, publisher, edition, date);
    }
}