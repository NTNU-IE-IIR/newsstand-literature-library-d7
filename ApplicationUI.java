
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 *
 * @author asty
 * @version 1.0
 */
public class ApplicationUI {


    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems = {
            "1. List all products",
            "2. Add new product",
            "3. Find a product by name",
            "4. Remove book by title"
    };

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
                int menuSelection = this.showMenu();
                switch (menuSelection) {
                    case 1:
                        this.listAllProducts();
                        break;

                    case 2:
                        this.addNewProduct();
                        break;

                    case 3:
                        this.findProductByName();
                        break;

                    case 4:
                        this.removeBookByTitle();
                        break;

                    case 5:
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
    private int showMenu() throws InputMismatchException {
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
    // ------ All these methods are made privat, since they are only used by the menu ---

    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistrer-instance here
     */
    Registry registry1 = new Registry();

    private void init() {
        System.out.println("init() was called");
    }

    /**
     * Lists all the products/literature in the register
     */
    private void listAllProducts() {
        Iterator<Book> it = registry1.getIterator();
        while (it.hasNext()) {
            Book b = it.next();
            System.out.println(getAllInfo(b));
        }
    }


    /**
     * Add a new product/literature to the register.
     * In this method you have to add code to ask the
     * user for the necessary information you need to
     * create an instance of the product, which you
     * then send as a parameter to the addNewspaper()-
     * method of the register.
     * Remember to also handle invalid input from the
     * user!!
     */
    private void addNewProduct() {
        System.out.println("Title of the book");
        Scanner reader = new Scanner(System.in);
        String title = reader.nextLine();

        System.out.println("Author of the book");
        String author = reader.nextLine();

        System.out.println("Edition of the book");
        String edition = reader.nextLine();

        System.out.println("Publisher of the book");
        String publisher = reader.nextLine();

        System.out.println("Publish date of the book");
        String publishDate = reader.nextLine();

        System.out.println("Is book part of a series? if yes type y");
        String series = reader.nextLine();

        if (series.equalsIgnoreCase("y")) {
            System.out.println("Title of the series");
            String seriesTitle = reader.nextLine();

            registry1.addBook(new Book(title, author, edition, publisher, publishDate, seriesTitle));
        } else registry1.addBook(new Book(title, author, edition, publisher, publishDate));


    }

    /**
     * Find and display a product based om name (title).
     * As with the addNewProduct()-method, you have to
     * ask the user for the string (name/title/publisher)
     * to search for, and then use this string as input-
     * parameter to the method in the register-object.
     * Then, upon return from the register, you need
     * to print the details of the found item.
     */
    private void findProductByName() {
        System.out.println("Search by the title of the book");
        Scanner reader = new Scanner(System.in);
        String title = reader.nextLine();

        Book book = registry1.findBookByTitle(title);

        System.out.println(getAllInfo(book));

    }

    private void removeBookByTitle() {
        System.out.println("Search by the title of the book");
        Scanner reader = new Scanner(System.in);
        String title = reader.nextLine();
        System.out.println("Are you sure, if so type y");
        String affirm = reader.nextLine();

        if(affirm.equalsIgnoreCase("y")) {
            registry1.removeBookByTitle(title);

            System.out.println("Book is removed");
        }

        else System.out.println("Book has not been removed");

           }





    private String getAllInfo(Book book) {
        String title = book.getTitle();
        String author = book.getAuthor();
        String edition = book.getEdition();
        String publisher = book.getPublisher();
        String publishDate = book.getPublishDate();

        if (book.isSeries()) {
            String seriesTitle = book.getSeriesTitle();
            return "Title: " + title + "\n Author: " + author + "\n Edition: " + edition + "\n Publisher: " + publisher + "\n Publish Date: " + publishDate + "\n Series Title: " + seriesTitle;

        } else
            return "Title: " + title + "\n Author: " + author + "\n Edition: " + edition + "\n Publisher: " + publisher + "\n Publish Date: " + publishDate;


    }


}

