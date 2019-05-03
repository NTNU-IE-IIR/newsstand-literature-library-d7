import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewspaperTest {
    private Newspaper newspaper;

    @Before
    public void setUp() throws Exception {
        newspaper = new Newspaper("Anders", "Javakongen", "moren til eskil hææ?",
                12);
    }

    @Test
    public void getGenre() {
        String result = this.newspaper.getGenre();
        String expectedResult = "moren til eskil hææ?";
        assertEquals(expectedResult,result);
    }

    @Test
    public void getReleasesPerYear() {
        int result = this.newspaper.getReleasesPerYear();
        int expectedResult = 12;
        assertEquals(expectedResult,result);
    }

    @Test
    public void getType() {
        String result = this.newspaper.getType();
        String expectedResult = "Newspaper";
        assertEquals(expectedResult,result);
    }
}