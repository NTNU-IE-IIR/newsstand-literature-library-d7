import java.util.ArrayList;
import java.util.Iterator;

/**
 * The registry for the project. The registry provides different types of searching- and remove functions.
 */
public class Registry {
    /**
     * The fields for this class
     */
    private ArrayList<Book> bookList;

    /**
     * Instantiates a new Registry.
     */
    public Registry() {
        this.bookList = new ArrayList<>();
    }

    /**
     * Adds a book to the registry.
     * If the book already exsists...
     *
     * @param book the book
     */
    public void addBook(Book book) {
        this.bookList.add(book);
    }

    /**
     * Return the number of books in the collection.
     *
     * @return The number of books in the collection.
     */
    public int getNumberOfBooks() {
        return bookList.size();
    }

    /**
     * Fill registry with dummies.
     */
    public void fillRegistryWithDummies() {
        Book book1 = new Book("Eskil", "Trondheim", "NTNU", "volum8", "04.01.2019");
        Book book2 = new Book("Hurlen", "Lillestrøm", "NTNU", "volum9", "04.07.2019");
        Book book3 = new Book("Eskil", "Tjommi", "NTNU", "volum3", "019.02.2017");
        Book book4 = new Book("Yusuf", "Bruh", "NTNU", "volumHæ", "01.01.2001");
        Book book5 = new Book("Sigurd", "Shiii", "Smartwater", "volumHæ", "01.01.2001", "Samsung");
        Book book6 = new Book("Rune", "Pose", "Tastatur", "volumHæ", "01.01.2001", "Varsom");
        addBook(book1);
        addBook(book2);
        addBook(book3);
        addBook(book4);
        addBook(book5);
        addBook(book6);
    }

    /**
     * List all the details of every book.
     */
    public ArrayList<Book> getBookList() {
        return bookList;
    }

    /**
     * Search for a given book by the index number.
     *
     * @param index The number in the array where the book is stored.
     */
    public void searchBookByIndex(int index) {
        Book book = bookList.get(index);
    }

    /**
     * Removes one of the books from the array.
     *
     * @param index The number in the array where the book is stored.
     */
    public void removeBookByIndex(int index) {
        if (index < bookList.size()) {
            bookList.remove(index);
        } else {
            System.out.println("Book is not in registery");
        }
    }

    /**
     * List by title.
     *
     * @param title the title
     */
    public void listByTitle(String title) {
        for (Book book : bookList) {

            if (book.getTitle().contains(title)) {
            }
        }
    }

    /**
     * Find book by title.
     *
     * @param title the title of the book you want to find.
     * @return the book
     */
    public Book findBookByTitle(String title) {
        boolean found = false;

        Iterator<Book> it = this.bookList.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.getTitle().equals(title)){
                return b;
            }
        }
        return null;
    }

    /**
     * Remove the book by title.
     *
     * @param title the title of the book you want to remove.
     */
    public void removeBookByTitle(String title) {
        boolean found = false;

        Iterator<Book> it = this.bookList.iterator();

        while (it.hasNext() && !found) {
            Book b = it.next();
            if (b.getTitle().equalsIgnoreCase(title)) {
                bookList.remove(b);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Title not found");
        }
    }

    /**
     * Find book by author array list.
     *
     * @param author the author of the book.
     * @return the array list of authors.
     */
    public ArrayList<Book> findBookByAuthor(String author) {
        ArrayList<Book> authorBookList = new ArrayList<>();
        for (Book b : bookList) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                authorBookList.add(b);
            }
        }
        return authorBookList;
    }

    /**
     * @param publisher The publisher of the book.
     * @return an ArrayList of all the books containing the author.
     */
    public ArrayList<Book> findBookByPublisher(String publisher) {
        ArrayList<Book> publisherBookList = new ArrayList<>();
        for (Book b : bookList) {
            if (b.getPublisher().equalsIgnoreCase(publisher)) {
                publisherBookList.add(b);
            }
        }
        return publisherBookList;
    }

}

