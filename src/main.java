import java.util.ArrayList;

/**
 * The type Main.
 */
public class main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        ApplicationUI appUI = new ApplicationUI();
        appUI.start();




        /*
        String paragraph = "------------------------------------";

        Registry registry1 = new Registry();
        registry1.fillRegistryWithDummies();
        System.out.println("Number of books: " + registry1.getNumberOfBooks());
        registry1.removeBookByTitle("bruh");
        System.out.println("Number of books: " + registry1.getNumberOfBooks());

        System.out.println(paragraph);
        System.out.println("Books by Eskil: ");
        ArrayList<Book> author = registry1.findBookByAuthor("eskil");
        for (Book b : author) {
            System.out.println(b.listAllInfo());
            System.out.println();
        }

        System.out.println(paragraph);
        registry1.listAllBooks();
        System.out.println(paragraph);
        registry1.searchBookByIndex(0);
        registry1.removeBookByIndex(8);
        registry1.listByTitle("trondheim");
        Book tjommi = registry1.findBookByTitle("Tjommi");
        tjommi.convertToSeries("Acer");

        System.out.println(paragraph);
        ArrayList<Book> publisher = registry1.findBookByPublisher("NTNU");
        for (Book b : publisher) {
            System.out.println(b.listAllInfo());
            System.out.println();
        }*/
    }
}