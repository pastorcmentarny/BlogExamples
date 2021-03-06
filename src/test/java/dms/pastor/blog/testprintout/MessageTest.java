package dms.pastor.blog.testprintout;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * Author Dominik Symonowicz
 * Created 23/02/2017
 * WWW:	http://pastor.ovh.org
 * Github:	https://github.com/pastorcmentarny
 * Google Play:	https://play.google.com/store/apps/developer?id=Dominik+Symonowicz
 * LinkedIn: uk.linkedin.com/pub/dominik-symonowicz/5a/706/981/
 * <p>
 * Example for this blog entry: http://dominiksymonowicz.blogspot.co.uk/2016/09/how-to-test-method-that-uses.html
 */
public class MessageTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream original = System.err;

    @Before
    public void setUp() throws Exception {
        System.setErr(new PrintStream(outputStream));
    }

    @After
    public void tearDown() throws Exception {
        System.setErr(original);
    }

    @Test
    public void displayErrorTest() throws Exception {
        //Given
        final String errorMessage = "Test";

        //When
        Message.error(errorMessage);

        //Then
        assertEquals("ERROR: " + errorMessage, outputStream.toString());

    }
}