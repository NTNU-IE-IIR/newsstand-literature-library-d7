
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 *
 * @author andesob
 * @version 1.0
 */
public class ApplicationUI {

    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "product" with "literature"
    // etc.
    private String[] menuItems = {
            "1. List all literature",
            "2. Add new literature",
            "3. Find a literature by title",
            "4. Find book(s) by author",
            "5. Remove literature by title",
            "6. Convert a book to a bookseries"
    };


    private Registry literatureRegister;

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() {
    }


    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() {
        this.init();

        boolean quit = false;

        while (!quit) {
            try {
                int menuSelection = this.showMenu(menuItems);
                switch (menuSelection) {
                    case 1:
                        this.listAllLiterature();
                        break;

                    case 2:
                        this.addLiterature();
                        break;

                    case 3:
                        this.findLiteratureByTitle();
                        break;

                    case 4:
                        this.findBookByAuthor();
                        break;

                    case 5:
                        this.removeLiteratureByTitle();
                        break;

                    case 6:
                        this.convertToSeries();
                        break;

                    case 7:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;
                    default:
                }
            } catch (InputMismatchException ime) {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }

    }


    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items.
     * If the user inputs anything else, an InputMismatchException is thrown.
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu(String[] menuItems) throws InputMismatchException {
        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for (String menuItem : menuItems) {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made private, since they are only used by the menu ---

    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistry-instance here
     */
    private void init() {
        literatureRegister = new Registry();
    }


    /**
     * Lists all the products/literature in the register
     */
    private void listAllLiterature() {
        ArrayList<Literature> bookArrayList = literatureRegister.getLiteratureList();

        if (bookArrayList.size() == 0) {
            System.out.println("\nThere are no literature in the registry.");
        } else {
            if (bookArrayList.size() == 1) {
                System.out.println("\nThere is 1 article in the registry");
            } else {
                System.out.println("\nThere are " + literatureRegister.getNumberOfLiterature() + " articles in the registry");
            }
            for (Literature literature : bookArrayList) {
                checkLiterature(literature);
            }
        }
    }

    private void checkLiterature(Literature literature) {
        if (literature instanceof BookSeries) {
            BookSeries b = (BookSeries) literature;
            new BookSeriesView(b);
        } else if (literature instanceof Book) {
            Book b = (Book) literature;
            new BookView(b);
        } else if (literature instanceof Newspaper) {
            Newspaper n = (Newspaper) literature;
            new NewspaperView(n);
        } else if (literature instanceof ComicBook) {
            ComicBook c = (ComicBook) literature;
            new ComicBookView(c);
        }
    }

    private void addLiterature() {
        String[] literature = {"1. Add book",
                "2. Add Newspaper",
                "3. Add Comic Book"
        };

        int menuSelection = showMenu(literature);

        try {
            if (menuSelection == 1) {
                addBook();
            } else if (menuSelection == 2) {
                addNewspaper();
            } else if (menuSelection == 3) {
                addComicBook();
            }
        } catch (InputMismatchException ime) {
            System.out.println("\nThe number you entered was not valid please try again");
        }
    }

    private void addNewspaper() {
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
            return;
        }

        if (errors > 0) {
            System.out.println("\nYou had " + errors + " errors when adding the newspaper, please try again");
            return;
        }

        literatureRegister.addLiterature(new Newspaper(title, publisher, genre, releasesPerYear));
    }

    private void addComicBook() {
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
            return;
        }

        literatureRegister.addLiterature(new ComicBook(title, publisher, serialNumber, publishDate));
    }

    /**
     * Lets the user add a book to the registry through
     * input in the terminal
     */
    private void addBook() {
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
            return;
        }

        Boolean spellcheck = true;

        while (spellcheck) {
            System.out.println("\nIs the book part of a series? If yes type y, if no type n");
            String input = reader.nextLine();
            if (input.equalsIgnoreCase("y")) {
                System.out.println("\nWhat is the series' title?");
                String seriesTitle = reader.nextLine();

                if (seriesTitle.length() == 0) {
                    System.out.println("\nThe series title can't be empty, please try again");
                } else {
                    literatureRegister.addLiterature(new BookSeries(author, title, publisher, edition, date, seriesTitle));
                    spellcheck = false;
                }

            } else if (input.equalsIgnoreCase("n")) {
                literatureRegister.addLiterature(new Book(author, title, publisher, edition, date));
                spellcheck = false;
            } else {
                System.out.println("\nPlease input either y for yes or n for no");
            }
        }
    }


    private void findLiteratureByTitle() {
        Scanner reader = new Scanner(System.in);
        System.out.println("\nWhat is the title of the literature you want to find?");
        String title = reader.nextLine();

        if (title.length() == 0) {
            System.out.println("\nYou have to enter a title, please try again");
            return;
        }

        Literature literature = literatureRegister.findLiteratureByTitle(title);

        if (literature == null) {
            System.out.println("\nTitle not found");
            return;
        }

        checkLiterature(literature);
    }

    private void findBookByAuthor() {
        Scanner reader = new Scanner(System.in);
        System.out.println("\nWho is the author of the book you want to find?");
        String author = reader.nextLine();

        if (author.length() == 0) {
            System.out.println("\nYou have to enter an author, please try again");
            return;
        }

        ArrayList<Book> authorBookList = literatureRegister.findBookByAuthor(author);
        if (authorBookList.size() == 0) {
            System.out.println("\nThere are no books by the selected author in the registry");
        } else {
            for (Book b : authorBookList) {
                if (b instanceof BookSeries) {
                    BookSeries book = (BookSeries) b;
                    new BookSeriesView(book);
                } else {
                    new BookView(b);
                }
            }
        }
    }


    private void removeLiteratureByTitle() {
        Scanner reader = new Scanner(System.in);
        System.out.println("\nWhat is the title of the literature you want to remove?");
        String title = reader.nextLine();

        if (title.length() == 0) {
            System.out.println("\nYou have to enter a title, please try again");
            return;
        }

        Literature literature = literatureRegister.removeLiteratureByTitle(title);
        if (literature == null) {
            System.out.println("\nThe literature is not in the registry");
        } else {
            System.out.println("\nYou removed " + literature.getTitle() + " from the registry!");
        }
    }

    private void convertToSeries() {
        Scanner reader = new Scanner(System.in);
        System.out.println("\nWhat is the title of the book you want to convert?");
        String title = reader.nextLine();

        if (title.length() == 0) {
            System.out.println("\nYou have to enter a title, please try again");
            return;
        }

        System.out.println("\nWhat is the seriestitle you want to use?");
        String seriesTitle = reader.nextLine();

        if (seriesTitle.length() == 0) {
            System.out.println("\nYou have to enter a seriestitle, please try again");
            return;
        }

        Book book = literatureRegister.convertToSeries(title, seriesTitle);
        if (book == null) {
            System.out.println("\nThere were no books in the registry with that title or the book is already a series, please try again");
        } else {
            System.out.println("\n" + title + " was converted to a bookseries with seriestitle " + seriesTitle);
        }
    }
}