import java.util.Scanner;

abstract public class NewspaperView {

    public NewspaperView() {
    }

    public static void viewNewspaper(Newspaper newspaper) {
        String title = newspaper.getTitle();
        String publisher = newspaper.getPublisher();
        String genre = newspaper.getGenre();
        int releases = newspaper.getReleasesPerYear();

        printInfo(title, publisher, genre, releases);
    }

    private static void printInfo(String title, String publisher, String genre, int releases) {
        System.out.println("-------------------------------------");
        System.out.println("Newspaper" +
                "\nTitle: " + title
                + "\nPublisher: " + publisher
                + "\nGenre: " + genre
                + "\nReleases: " + releases);
        System.out.println("-------------------------------------");
    }

    public static Literature addNewspaper() {
        System.out.println("\nADD A NEW NEWSPAPER:");

        Scanner reader = new Scanner(System.in);

        System.out.println("\nWhat is the title of the newspaper you want to add?");
        String title = reader.nextLine();
        while (title.isEmpty()) {
            title = reader.nextLine();
        }

        System.out.println("\nWho published the newspaper?");
        String publisher = reader.nextLine();
        while (publisher.isEmpty()) {
            publisher = reader.nextLine();
        }

        System.out.println("\nWhat is the genre of the newspaper?");
        String genre = reader.nextLine();
        while (genre.isEmpty()) {
            genre = reader.nextLine();
        }

        int releasesPerYear = 0;
        System.out.println("\nHow many releases per year has the newspaper?");
        while (releasesPerYear <= 0) {
            if (reader.hasNextInt()) {
                releasesPerYear = reader.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a valid number of releases per year");
            }
            reader.nextLine();
        }
        return new Newspaper(title, publisher, genre, releasesPerYear);
    }
}
