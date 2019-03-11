import java.util.Scanner;

public class NewspaperView {

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
        System.out.println("Title: " + title
                + "\nPublisher: " + publisher
                + "\nGenre: " + genre
                + "\nReleases: " + releases);
        System.out.println("-------------------------------------");
    }

    public static Literature addNewspaper(){
        Scanner reader = new Scanner(System.in);

        System.out.println("\nWhat is the title of the newspaper you want to add?");
        String title = reader.nextLine();

        System.out.println("\nWho published the newspaper?");
        String publisher = reader.nextLine();

        System.out.println("\nWhat is the genre of the newspaper?");
        String genre = reader.nextLine();

        int releasesPerYear = 0;
        System.out.println("\nHow many releases per year has the newspaper?");
        if (reader.hasNextInt()) {
            releasesPerYear = reader.nextInt();
        }

        int errors = 0;

        if (title.length() == 0) {
            System.out.println("\nThe newspaper has to have a title");
            errors += 1;
        }
        if (publisher.length() == 0) {
            System.out.println("\nThe newspaper has to have a publisher");
            errors += 1;
        }
        if (genre.length() == 0) {
            System.out.println("\nThat newspaper has to have a genre");
            errors += 1;
        }

        if (releasesPerYear == 0) {
            System.out.println("\nThe number for releases per year is not valid, please try again");
            errors += 1;
        }

        if (errors > 0) {
            System.out.println("\nYou had " + errors + " errors when adding the newspaper, please try again");
            return null;
        }
         return new Newspaper(title, publisher, genre, releasesPerYear);
    }
}
