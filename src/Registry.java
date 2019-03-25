import java.util.ArrayList;
import java.util.Iterator;

/**
 * The registry for the project. The registry provides different types of searching- and remove functions.
 */
public class Registry {
    /**
     * The fields for this class
     */
    private ArrayList<Literature> literatureList;

    /**
     * Instantiates a new Registry.
     */
    public Registry() {
        this.literatureList = new ArrayList<>();
    }

    /**
     * Fill registry with dummies.
     */
    public void fillRegistryWithDummies() {
        Literature book1 = new Book("Eskil", "Trondheim", "NTNU", "volum8", "04.01.2019");
        Literature book2 = new Book("Hurlen", "Lillestrøm", "NTNU", "volum9", "04.07.2019");
        Literature comic = new ComicBook("Eskil", "Tjommi", 2, "19. april");
        Literature comic2 = new ComicBook("Sigurd", "Shiii", 15, "01.01.2001");
        Literature newspaper = new Newspaper("Yusuf", "Bruh", "NTNU", 53);
        Literature book6 = new BookSeries("Hurlen", "Trondheim", "Tastatur", "volumHæ", "01.01.2001", "Varsom");
        addLiterature(book1);
        addLiterature(book2);
        addLiterature(comic);
        addLiterature(comic2);
        addLiterature(newspaper);
        addLiterature(book6);
    }


    /**
     * Adds a book to the registry.
     *
     * @param book the book
     */
    public void addLiterature(Literature book) {
        this.literatureList.add(book);
    }

    /**
     * Return the number of books in the collection.
     *
     * @return The number of books in the collection.
     */
    public int getNumberOfLiterature() {
        return literatureList.size();
    }


    /**
     * List all the details of every book.
     *
     * @return the book list
     */
    public ArrayList<Literature> getLiteratureList() {
        return literatureList;
    }

    /**
     * Search for a given book by the index number.
     *
     * @param index The number in the array where the book is stored.
     */
    public Literature searchLiteratureByIndex(int index) {
        return literatureList.get(index);
    }

    /**
     * Removes one of the books from the array.
     *
     * @param index The number in the array where the book is stored.
     */
    public void removeLiteratureByIndex(int index) {
        if (index < literatureList.size()) {
            literatureList.remove(index);
        }
    }


    /**
     * Find book by title.
     *
     * @param title the title of the book you want to find.
     * @return the book
     */
    public Literature findLiteratureByTitle(String title) {
        Iterator<Literature> it = this.literatureList.iterator();
        while (it.hasNext()) {
            Literature b = it.next();
            if (b.getTitle().equalsIgnoreCase(title)) {
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
    public Literature removeLiteratureByTitle(String title) {
        Iterator<Literature> it = this.literatureList.iterator();

        while (it.hasNext()) {
            Literature l = it.next();
            if (l.getTitle().equalsIgnoreCase(title)) {
                literatureList.remove(l);
                return l;
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

        for (Literature b : literatureList) {
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
        ArrayList<Literature> publisherLiteratureList = new ArrayList<>();
        for (Literature b : literatureList) {
            if (b.getPublisher().equalsIgnoreCase(publisher)) {
                publisherLiteratureList.add(b);
            }
        }
        return publisherLiteratureList;
    }

    public Book convertToSeries(String title, String seriesTitle) {
        Literature book = findLiteratureByTitle(title);
        if (book == null || book instanceof BookSeries) {
            return null;
        }

        if (book instanceof Book) {
            Book b = (Book) book;
            b = b.convertToSeries(seriesTitle);
            removeLiteratureByTitle(title);
            addLiterature(b);
            return b;
        }
        return null;
    }
}