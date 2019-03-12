
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
            BookSeriesView.viewBookSeries(b);
        } else if (literature instanceof Book) {
            Book b = (Book) literature;
            BookView.viewBook(b);
        } else if (literature instanceof Newspaper) {
            Newspaper n = (Newspaper) literature;
            NewspaperView.viewNewspaper(n);
        } else if (literature instanceof ComicBook) {
            ComicBook c = (ComicBook) literature;
            ComicBookView.viewComicBook(c);
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
        Literature newspaper = NewspaperView.addNewspaper();

        if (newspaper != null) {
            literatureRegister.addLiterature(newspaper);
        }
    }

    private void addComicBook() {
        Literature comicBook = ComicBookView.addComicBook();

        if (comicBook != null) {
            literatureRegister.addLiterature(comicBook);
        }
    }

    /**
     * Lets the user add a book to the registry through
     * input in the terminal
     */
    private void addBook() {
        Scanner reader = new Scanner(System.in);

        Boolean spellcheck = true;

        while (spellcheck) {
            System.out.println("\nIs the book part of a series? If yes type y, if no type n");
            String input = reader.nextLine();
            if (input.equalsIgnoreCase("y")) {
                Literature literature = BookSeriesView.addBookSeries();
                if (literature != null) {
                    literatureRegister.addLiterature(literature);
                    spellcheck = false;
                }
            } else if (input.equalsIgnoreCase("n")) {
                Literature literature = BookView.addBook();
                if (literature != null) {
                    literatureRegister.addLiterature(literature);
                    spellcheck = false;
                }
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
                checkLiterature(b);
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
        String[] array = BookView.convertToSeries();
        Book book = null;

        if (array != null) {
            book = literatureRegister.convertToSeries(array[0], array[1]);
        }
        if (book == null) {
            System.out.println("\nThere were no books in the registry with that title or the book is already a series, please try again");
        } else {
            System.out.println("\n" + array[0] + " was converted to a bookseries with seriestitle " + array[1]);
        }
    }
}