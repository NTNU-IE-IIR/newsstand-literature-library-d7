import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RegistryTest {
    private Registry test;

    @Before
    public void setUp() throws Exception {
        test = new Registry();
        test.fillRegistryWithDummies();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addLiterature() {
        Book bok1 = new Book("", "Anders", "NTNU", "4", "1504");
        Book bok2 = new Book("HP", "Anders", "NTNU", "4", "1504");
        test.addLiterature(bok1);
        ArrayList<Literature> testList = test.getLiteratureList();
        assertTrue(testList.contains(bok1));
        assertFalse(testList.contains(bok2));
    }


    @Test
    public void findLiteratureByTitle() {
        Book bok1 = new Book("SHIII", "Anders", "NTNU", "4", "1504");
        Book bok2 = new Book("HP", "No", "NTNU", "4", "1504");
        test.addLiterature(bok1);
        Literature result1 = test.findLiteratureByTitle("Anders");
        Literature result2 = test.findLiteratureByTitle("");
        Book expectedTrue = bok1;
        Book expectedFalse = bok2;
        assertEquals(expectedTrue, result1);
        assertNotEquals(expectedFalse, result1);
        assertNotEquals(expectedTrue, result2);
    }

    @Test
    public void removeLiteratureByTitle() {
        Book bok2 = new Book("HP", "No", "NTNU", "4", "1504");
        test.addLiterature(bok2);
        Literature temp = test.removeLiteratureByTitle("Bruh");
        assertFalse(test.getLiteratureList().contains(temp));
        assertTrue(test.getLiteratureList().contains(bok2));
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

    @Test
    public void findLiteratureByPublisher() {
        ArrayList<Literature> result = test.findLiteratureByPublisher("Yusuf");
        String expected = "Yusuf";
        String expectedFalse = "Busuf";

        for (Literature b : result) {
            assertEquals(expected, b.getPublisher());
            assertNotEquals(expectedFalse, b.getPublisher());
        }
    }

    @Test
    public void convertToSeries(){
        Book bok2 = new Book("HP", "No", "NTNU", "4", "1504");
        test.addLiterature(bok2);
        test.convertToSeries("No", "yes");
        Literature literature = test.findLiteratureByTitle("No");
        Book book = (Book) literature;
        String type = book.getType();
        assertEquals(type, "Bookseries");
    }
}