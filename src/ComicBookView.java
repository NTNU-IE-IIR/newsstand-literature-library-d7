import java.util.Scanner;

public class ComicBookView {

    public ComicBookView(){
    }

    public static void viewComicBook(ComicBook comicBook){
        String title = comicBook.getTitle();
        String publisher = comicBook.getPublisher();
        int serialNumber = comicBook.getSerialNumber();
        String publishDate = comicBook.getPublishDate();

        printInfo(title, publisher, serialNumber, publishDate);
    }

    private static void printInfo(String title, String publisher, int serialNumber, String publishDate){
        System.out.println("-------------------------------------");
        System.out.println("Title: " + title
                        + "\nPublisher: " + publisher
                        + "\nSerial number: " + serialNumber
                        + "\nPublish Date: " + publishDate);
        System.out.println("-------------------------------------");
    }

    public static Literature addComicBook(){
        Scanner reader = new Scanner(System.in);

        System.out.println("\nWhat is the title of the comic you want to add?");
        String title = reader.nextLine();

        System.out.println("\nWho published the comic?");
        String publisher = reader.nextLine();

        System.out.println("\nWhat is the serialnumber of the comic?");
        int serialNumber = 0;

        if (reader.hasNextInt()) {
            serialNumber = reader.nextInt();
            reader.nextLine();
        }

        System.out.println("\nWhat date was the comic published?");
        String publishDate = reader.nextLine();

        int errors = 0;

        if (title.length() == 0) {
            System.out.println("\nThe comic book has to have a title");
            errors += 1;
        }
        if (publisher.length() == 0) {
            System.out.println("\nThe comic book has to have a publisher");
            errors += 1;
        }
        if (serialNumber <= 0) {
            System.out.println("\nThat serial number is not valid, try again");
            errors += 1;
        }
        if (publishDate.length() == 0) {
            System.out.println("\nThe publish date is not valid, try again");
            errors += 1;
        }

        if (errors > 0) {
            System.out.println("\nYou had " + errors + " errors when adding the comic book, please try again");
            return null;
        }
        return new ComicBook(title, publisher, serialNumber, publishDate);
    }
}
