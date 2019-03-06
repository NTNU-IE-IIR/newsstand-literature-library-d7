import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The type Book test.
 */
public class BookTest {
    private Book book;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
      book = new Book("Anders", "Javakongen", "moren til eskil hææ?",
              "vol2", "12.01.10", "En intellektuell playboy" );
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
     * Test get author.
     */
    @Test
    public void testGetAuthor() {
        String result = this.book.getAuthor();
        String expectedResult = "Anders";
        assertEquals(expectedResult,result);
    }

    /**
     * Test get title.
     */
    @Test
    public void testGetTitle() {
        String result = this.book.getTitle();
        String expectedResult = "Javakongen";
        assertEquals(expectedResult,result);
    }

    /**
     * Test get publisher.
     */
    @Test
    public void testGetPublisher() {
        String result = this.book.getPublisher();
        String expectedResult = "moren til eskil hææ?";
        assertEquals(expectedResult,result);
    }

    /**
     * Test get edition.
     */
    @Test
    public void testGetEdition() {
        String result = this.book.getEdition();
        String expectedResult = "vol2";
        assertEquals(expectedResult,result);
    }

    /**
     * Test get publish date.
     */
    @Test
    public void testGetPublishDate() {
        String result = this.book.getPublishDate();
        String expectedResult = "12.01.10";
        assertEquals(expectedResult,result);
    }

    /**
     * Test get series title.
     */
    @Test
    public void  testGetSeriesTitle() {
        String result = this.book.getSeriesTitle();
        String expectedResult = "En intellektuell playboy";
        assertEquals(expectedResult,result);
    }

    /**
     * Test is serie.
     */
    @Test
    public void testIsSerie() {
            boolean result = this.book.isSerie();
            boolean expectedResult = true;
            assertEquals(expectedResult,result);
    }
}