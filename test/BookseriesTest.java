import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookseriesTest {

    private BookSeries bookseries;
    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        bookseries = new BookSeries("Anders", "Javakongen", "moren til eskil hææ?",
                "vol2", "12.01.10", "intellektuell playboy" );
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getSeriesTitle() {
        String result = this.bookseries.getSeriesTitle();
        String expectedResult = "intellektuell playboy";
        assertEquals(expectedResult,result);
    }

    @Test
    public void isSerie() {
        Boolean result = this.bookseries.isSerie();
        assertTrue(result);
    }

    @Test
    public void getAuthor() {
            String result = this.bookseries.getAuthor();
            String expectedResult = "Anders";
            assertEquals(expectedResult,result);
    }

    @Test
    public void getEdition() {
                String result = this.bookseries.getEdition();
                String expectedResult = "vol2";
                assertEquals(expectedResult,result);
        }
    }
