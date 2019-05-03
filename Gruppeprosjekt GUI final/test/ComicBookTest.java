import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComicBookTest {
    private ComicBook book;

    @Before
    public void setUp() throws Exception {
        book = new ComicBook("Anders", "Javakongen", 20,
                "vol2");
    }

    @Test
    public void getSerialNumber() {
        int result = this.book.getSerialNumber();
        int expectedResult = 20;
        assertEquals(expectedResult, result);
    }

    @Test
    public void getPublishDate() {
        String result = this.book.getPublishDate();
        String expectedResult = "vol2";
        assertEquals(expectedResult,result);
    }

    @Test
    public void getType() {
        String result = this.book.getType();
        String expectedResult = "Comic book";
        assertEquals(expectedResult,result);
    }
}