import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewspaperTest {
    private Newspaper newspaper;

    @Before
    public void setUp() throws Exception {
        newspaper = new Newspaper("Anders", "Javakongen", "genre",
                2);
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
    public void getReleasesPerYear() {

    int result = this.newspaper.getReleasesPerYear();
    int expectedResult = 2;

    assertEquals(expectedResult, result);

}

    @Test
    public void getGenre() {
        String result = this.newspaper.getGenre();
        String expectedResult = "genre";
        assertEquals(expectedResult,result);
    }
}