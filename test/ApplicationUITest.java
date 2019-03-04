import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ApplicationUITest {
    private ArrayList<Book> bookList;

    @Before
    public void setUp() throws Exception {
        this.bookList = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void start() {
    }
}