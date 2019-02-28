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
    public ArrayList<Book> getBookList() {
        return bookList;
    }

    /**
     * Search for a given book by the index number.
     *
     * @param index The number in the array where the book is stored.
     */
    public Book searchBookByIndex(int index) {
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
    public Book findBookByTitle(String title) {
        Iterator<Book> it = this.bookList.iterator();
        while (it.hasNext()) {
            Book b = it.next();
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
    public Book removeBookByTitle(String title) {
        Iterator<Book> it = this.bookList.iterator();

        while (it.hasNext()) {
            Book b = it.next();
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
        for (Book b : bookList) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                authorBookList.add(b);
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