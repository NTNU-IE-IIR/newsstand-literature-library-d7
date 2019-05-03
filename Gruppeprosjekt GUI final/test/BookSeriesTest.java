import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookSeriesTest {
    private BookSeries book;

    @Before
    public void setUp() throws Exception {
        book = new BookSeries("Anders", "Javakongen", "moren til eskil hææ?",
                "vol2", "12.01.10", "shiman");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSeriesTitle() {
        String result = this.book.getSeriesTitle();
        String expectedResult = "shiman";
        assertEquals(expectedResult,result);
    }

    @Test
    public void testGetType() {
        String result = this.book.getType();
        String expectedResult = "Bookseries";
        assertEquals(expectedResult,result);
    }
}