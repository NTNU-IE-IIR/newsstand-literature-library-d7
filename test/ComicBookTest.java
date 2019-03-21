import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComicBookTest {
    private ComicBook comicBook;

    @Before
    public void setUp() throws Exception {
        comicBook = new ComicBook("Anders", "Javakongen", 1,
                "12.01.10");
    }


    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test get series title.
     */
    @Test
    public void testGetSerialNumber() {
        int result = this.comicBook.getSerialNumber();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }

}