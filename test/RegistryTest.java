import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RegistryTest {
    private Registry test;
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;

    @Before
    public void setUp() throws Exception {
        test = new Registry();
        book1 = new Book("Eskil", "Trondheim", "NTNU", "volum8", "04.01.2019");
        book2 = new Book("Hurlen", "Lillestrøm", "NTNU", "volum9", "04.07.2019");
        book3 = new Book("Eskil", "Tjommi", "NTNU", "volum3", "019.02.2017");
        book4 = new Book("Yusuf", "Bruh", "NTNU", "volumHæ", "01.01.2001");
        book5 = new Book("Yusuf", "Shiii", "Smartwater", "volumHæ", "01.01.2001", "Samsung");
        book6 = new Book("Rune", "Pose", "Tastatur", "volumHæ", "01.01.2001", "Varsom");
        test.addBook(book1);
        test.addBook(book2);
        test.addBook(book3);
        test.addBook(book4);
        test.addBook(book5);
        test.addBook(book6);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addBook() {
        Book bok1 = new Book("HP", "Anders", "NTNU", "4", "1504");
        Book bok2 = new Book("HP", "Anders", "NTNU", "4", "1504");
        test.addBook(bok1);
        ArrayList<Book> testList = test.getBookList();
        assertTrue(testList.contains(bok1));
        assertFalse(testList.contains(bok2));
    }

    @Test
    public void getNumberOfBooks() {
        int expected = 6;
        int expectedFalse = 6666;
        int result = test.getNumberOfBooks();
        assertEquals(expected, result);
        assertNotEquals(expectedFalse, result);
    }


    @Test
    public void findBookByTitle() {
        Book result = test.findBookByTitle("Bruh");
        Book expectedTrue = book4;
        Book expectedFalse = book1;
        assertEquals(expectedTrue, result);
        assertNotEquals(expectedFalse, result);
    }

    @Test
    public void removeBookByTitle() {
        test.removeBookByTitle("Bruh");
        assertFalse(test.getBookList().contains(book4));
        assertTrue(test.getBookList().contains(book1));
    }

    @Test
    public void findBookByAuthor() {
        ArrayList<Book> result = test.findBookByAuthor("Yusuf");
        String expected = "Yusuf";
        String expectedFalse = "Busuf";

        for (Book b : result) {
            assertEquals(expected, b.getAuthor());
            assertNotEquals(expectedFalse, b.getAuthor());
        }


    }
}