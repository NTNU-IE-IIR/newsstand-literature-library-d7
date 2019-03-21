import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * The type Registry test.
 */
public class RegistryTest {
    private Literature harry;
    private Book book1;
    private Literature book2;
    private Literature comicbook;
    private Literature newspaper;
    private Literature bookseries;
    private Literature book6;



    private Registry registry;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        registry = new Registry();

        book1 = new Book("Eskil", "Trondheim", "NTNU", "volum8", "04.01.2019");
        book2 = new Book("Hurlen", "Lillestrøm", "NTNU", "volum9", "04.07.2019");
        comicbook = new ComicBook("Tjommi", "Tjommi", 2, "volum3");
        newspaper = new Newspaper("tittel", "Bruh", "sjanger", 3);
        bookseries = new BookSeries("Eskil", "Shiii", "Smartwater", "volumHæ", "01.01.2001", "Samsung");

        harry = new Book("Anders", "Javakongen", "moren til eskil hææ?",
                "vol2", "12.01.10");

        registry.addLiterature(book1);
        registry.addLiterature(book2);
        registry.addLiterature(comicbook);
        registry.addLiterature(newspaper);
        registry.addLiterature(bookseries);
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test add book.
     */
    @Test
    public void testAddLiterature() {
        List<Literature> registryBookList = this.registry.getLiteratureList();

        book6 = new Book("Rune", "Pose", "Tastatur", "volumHæ", "01.01.2001");

        this.registry.addLiterature(harry);
        assertFalse(registryBookList.contains(book6));
        assertTrue(registryBookList.contains(harry));
    }

    /**
     * Test get number of books.
     */
    @Test
    public void testGetNumberOfBooks() {
        int result = this.registry.getNumberOfLiterature();
        int expectedResult = 5;
        int expectedFalse = 1337;
        assertEquals(expectedResult, result);
        assertNotEquals(expectedFalse,result);
    }

    /**
     * Test find book by title.
     */
    @Test
    public void testFindBookByTitle() {
        Literature result = this.registry.findLiteratureByTitle("Tjommi");
        Literature expectedResult = comicbook;
        Literature expectedFalse = book1;
        assertEquals(expectedResult,result);
        assertFalse(expectedFalse == result);
    }

    /**
     * Test remove book by title.
     */
    @Test
    public void testRemoveBookByTitle() {

        assertTrue(this.registry.getLiteratureList().contains(book1));
        this.registry.removeLiteratureByTitle("Trondheim");
        assertFalse(this.registry.getLiteratureList().contains(book1));

        List<Literature> registryBookList = this.registry.getLiteratureList();
        int expected = 4;
        this.registry.removeLiteratureByTitle("");
        int result = registryBookList.size();
        assertEquals(expected,result);
    }

    /**
     * Find book by author.
     */
    @Test
    public void testFindBookByAuthor() {
        List<Book> result = this.registry.findBookByAuthor("Eskil");

        String expected = "Eskil";
        Literature expectedFalse = book2;

        assertTrue(result.size() !=0);

        for(Book b: result) {
            assertEquals(expected, b.getAuthor());
            assertNotEquals(expectedFalse, book1.getAuthor());
        }
    }

    @Test
    public void testConvertToSeries() {
        Boolean result1 = book1.isSeries();
        assertFalse(result1);

        Book b = registry.convertToSeries("Trondheim" , "en serietittel");
        Boolean result2 = b.isSeries();
        assertTrue(result2);
    }


}