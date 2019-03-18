import java.util.Scanner;

abstract public class ComicBookView {

    public ComicBookView() {

    }

    public static void viewComic(ComicBook comic) {
        String title = comic.getTitle();
        String publisher = comic.getPublisher();
        int serialNumber = comic.getSerialNumber();
        String publishingDate = comic.getPublishDate();

        System.out.println("Title: " + title + "\nDate: " + publishingDate + "\nPublisher: "
                + publisher + "\nSerial number: " + serialNumber);
    }

    public static Literature addComic() {
        Scanner reader = new Scanner(System.in);

        System.out.println("ADD A NEW COMIC:");

        System.out.println("What's the title of the comic?");
        String title = reader.nextLine();
        while (title.isBlank()) {
            System.out.println("Invalid input. Please type the title of the comic");
            title = reader.nextLine();
        }

        System.out.println("Who's the publisher of the comic?");
        String publisher = reader.nextLine();
        while (publisher.isBlank()) {
            System.out.println("Invalid input. Please type the publisher of the comic");
            title = reader.nextLine();
        }


        // The "nextInt will throw an exception if it's not an Integer. Add a catch to this method.

        System.out.println("What's the serial number of the comic this year?");
        int serialNumber = 0;

        while(serialNumber <= 0){
            if (reader.hasNextInt()) {
                serialNumber = reader.nextInt();
                reader.nextLine();
            }
        }


        System.out.println("What's the publish-date of the comic?");
        String publishdate = reader.nextLine();
        while (publishdate.isBlank()) {
            System.out.println("Invalid input. Please type the publish-date of the comic");
            publishdate = reader.nextLine();
        }


        Literature comic = new ComicBook(title, publisher, serialNumber, publishdate);

        System.out.println("Newspaper: " + title + ". By " + publisher + " was added to the registry");

        return comic;

    }
}
