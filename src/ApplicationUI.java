
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
public class ApplicationUI
{

   
    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "product" with "literature"
    // etc.
    private String[] menuItems = {
        "1. List all books",
        "2. Add new book",
        "3. Find a book by title",
        "4. Remove a book by title"
    };


    private Registry bookRegister;

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI()
    {
        bookRegister = new Registry();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start()
    {
        this.init();

        boolean quit = false;

        while (!quit) 
        {
            try 
            {
                int menuSelection = this.showMenu();
                switch (menuSelection) 
                {
                    case 1:
                        this.listAllBooks();
                        break;

                    case 2:
                        this.addNewBook();
                        break;

                    case 3:
                        this.findBookByTitle();
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
            } 
            catch (InputMismatchException ime) 
            {
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
    private int showMenu() throws InputMismatchException 
    {
        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for ( String menuItem : menuItems )
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) 
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
    
    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made private, since they are only used by the menu ---
    
    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistrer-instance here
     */
    private void init()
    {
        System.out.println("init() was called");
    }

    /**
     * Lists all the products/literature in the register
     */
    private void listAllBooks()
    {
        ArrayList<Book> bookArrayList = bookRegister.getBookList();
        for (Book book: bookArrayList){
            System.out.println(bookInfo(book));
            System.out.println("\n");
        }
        System.out.println("listAllBooks() was called");
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
    private void addNewBook()
    {
        System.out.println("What is the name of the author?");
        Scanner reader = new Scanner(System.in);
        String author = reader.nextLine();

        System.out.println("What is the title of the book?");
        String title = reader.nextLine();

        System.out.println("Who published the book?");
        String publisher = reader.nextLine();

        System.out.println("Which edition of the book is it?");
        String edition = reader.nextLine();


        System.out.println("What date was the book published?");
        String date = reader.nextLine();

        System.out.println("Is the book part of a series? If yes type y, if no type n");
        if (reader.nextLine().equalsIgnoreCase("y")){
            System.out.println("What is the series' title?");
            String seriesTitle = reader.nextLine();
            bookRegister.addBook(new Book(author, title, publisher, edition, date, seriesTitle));
        }
        else{
            bookRegister.addBook(new Book(author, title, publisher, edition, date));
        }


        System.out.println("addNewProduct() was called");
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
    private void findBookByTitle()
    {
        Scanner reader = new Scanner(System.in);
        System.out.println("What is the title of the book?");
        String title = reader.nextLine();

        Book book = bookRegister.findBookByTitle(title);

        if(book == null){
            System.out.println("Title not found");
            return;
        }

        System.out.println(bookInfo(book));

        System.out.println();
        System.out.println("findBookByName() was called");
    }


    private void removeBookByTitle(){
        Scanner reader = new Scanner(System.in);
        System.out.println("What is the title of the book you want to remove?");
        String title = reader.nextLine();

        bookRegister.removeBookByTitle(title);
    }

    private String bookInfo(Book book){
        String title = book.getTitle();
        String author = book.getAuthor();
        String date = book.getPublishDate();
        String publisher = book.getPublisher();
        String edition = book.getEdition();

        if(book.isSeries()){
            String seriesTitle = book.getSeriesTitle();
            return "Title: " + title + "\nSeries title: " + seriesTitle + "\nAuthor: " + author + "\nDate: " + date + "\nPublisher: " + publisher + "\nEdition: " + edition;
        }
        else {
            return "Title: " + title + "\nAuthor: " + author + "\nDate: " + date + "\nPublisher: " + publisher + "\nEdition: " + edition;
        }
    }
}
