import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The type Application ui test.
 */
public class ApplicationUITest {
private ApplicationUI appUI;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        appUI = new ApplicationUI();
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
     * Start.
     */
    @Test
    public void testStart() {
        appUI.start();
    }
}