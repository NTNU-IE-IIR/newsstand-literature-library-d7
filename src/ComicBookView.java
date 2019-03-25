import java.util.Scanner;

abstract public class ComicBookView {

    public ComicBookView() {

    }

    public static void viewComic(ComicBook comic) {
        String title = comic.getTitle();
        String publisher = comic.getPublisher();
        int serialNumber = comic.getSerialNumber();
        String publishingDate = comic.getPublishDate();

        System.out.println("-------------------------------------");
        System.out.println("Comic book"
                + "\nTitle: " + title
                + "\nDate: " + publishingDate
                + "\nPublisher: " + publisher
                + "\nSerial number: " + serialNumber);
        System.out.println("-------------------------------------");
    }

    public static Literature addComic() {
        Scanner reader = new Scanner(System.in);

        System.out.println("\nADD A NEW COMIC:");

        System.out.println("\nWhat's the title of the comic?");
        String title = reader.nextLine();
        while (title.isBlank()) {
            System.out.println("Invalid input. Please type the title of the comic");
            title = reader.nextLine();
        }

        System.out.println("\nWho's the publisher of the comic?");
        String publisher = reader.nextLine();
        while (publisher.isBlank()) {
            System.out.println("Invalid input. Please type the publisher of the comic");
            publisher = reader.nextLine();
        }


        System.out.println("\nWhat's the serial number of the comic this year?");
        int serialNumber = 0;

        while (serialNumber <= 0) {
            if (reader.hasNextInt()) {
                serialNumber = reader.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a valid serial number");
            }
                reader.nextLine();
        }


        System.out.println("\nWhat's the publish-date of the comic?");
        String publishdate = reader.nextLine();
        while (publishdate.isBlank()) {
            System.out.println("Invalid input. Please type the publish-date of the comic");
            publishdate = reader.nextLine();
        }


        Literature comic = new ComicBook(title, publisher, serialNumber, publishdate);

        System.out.println("\nComic book: " + title + " by " + publisher + " was added to the registry");

        return comic;

    }
}
