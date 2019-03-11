import java.util.ArrayList;
import java.util.Iterator;

/**
 * The registry for the project. The registry provides different types of searching- and remove functions.
 */
public class Registry {
    /**
     * The fields for this class
     */
    private ArrayList<Literature> bookList;

    /**
     * Instantiates a new Registry.
     */
    public Registry() {
        this.bookList = new ArrayList<>();
    }

    /**
     * Fill registry with dummies.
     */
    /*public void fillRegistryWithDummies() {
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
    }*/


    /**
     * Adds a book to the registry.
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
     * List all the details of every book.
     *
     * @return the book list
     */
    public ArrayList<Literature> getBookList() {
        return bookList;
    }

    /**
     * Search for a given book by the index number.
     *
     * @param index The number in the array where the book is stored.
     */
    public Literature searchBookByIndex(int index) {
        return bookList.get(index);
    }

    /**
     * Removes one of the books from the array.
     *
     * @param index The number in the array where the book is stored.
     */
    public void removeBookByIndex(int index) {
        if (index < bookList.size()) {
            bookList.remove(index);
        }
    }


    /**
     * Find book by title.
     *
     * @param title the title of the book you want to find.
     * @return the book
     */
    public Literature findBookByTitle(String title) {
        Iterator<Literature> it = this.bookList.iterator();
        while (it.hasNext()) {
            Literature b = it.next();
            if (b.getTitle().equals(title)) {
                return b;
            }
        }
        return null;
    }

    /**
     * Remove the book by title.
     *
     * @param title the title of the book you want to remove.
     * @return the book
     */
    public Literature removeBookByTitle(String title) {
        Iterator<Literature> it = this.bookList.iterator();

        while (it.hasNext()) {
            Literature b = it.next();
            if (b.getTitle().equalsIgnoreCase(title)) {
                bookList.remove(b);
                return b;
            }
        }
        return null;
    }

    /**
     * Find book by author array list.
     *
     * @param author the author of the book.
     * @return the array list of authors.
     */
    public ArrayList<Book> findBookByAuthor(String author) {
        ArrayList<Book> authorBookList = new ArrayList<>();

        for (Literature b : bookList) {
            if (b instanceof Book) {
                Book book = (Book) b;
                if (book.getAuthor().equalsIgnoreCase(author)) {
                    authorBookList.add(book);
                }
            }
        }
        return authorBookList;
    }

    /**
     * Find book by publisher array list.
     *
     * @param publisher The publisher of the book.
     * @return an ArrayList of all the books containing the author.
     */
    public ArrayList<Literature> findLiteratureByPublisher(String publisher) {
        ArrayList<Literature> publisherBookList = new ArrayList<>();
        for (Literature b : bookList) {
            if (b.getPublisher().equalsIgnoreCase(publisher)) {
                publisherBookList.add(b);
            }
        }
        return publisherBookList;
    }
    
    public Book convertToSeries(String title, String seriesTitle) {
        Literature book = findBookByTitle(title);
        /*if (book == null || book instanceof BookSeries) {
            return null;
        }*/

        if (book instanceof Book) {
            Book b = (Book) book;
            removeBookByTitle(title);
            b = b.convertToSeries(seriesTitle);
            addBook(b);
            return b;
        }
        return null;
    }
}