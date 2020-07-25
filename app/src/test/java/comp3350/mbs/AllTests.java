package comp3350.mbs;

import junit.framework.TestSuite;

import comp3350.mbs.business.AccessTheatreMoviesTest;
import comp3350.mbs.business.CalculateTest;
import comp3350.mbs.business.TrailerTest;
import comp3350.mbs.objects.SeatingTest;
import comp3350.mbs.objects.TheatreMoviesTest;
import comp3350.mbs.objects.TheatreTest;
import comp3350.mbs.objects.TicketTest;
import comp3350.mbs.objects.ViewingTimeTest;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AllTests {

    public static TestSuite suite;

    public static junit.framework.Test suite() {
        suite = new TestSuite("All tests");
        testObjects();
        testBusiness();
        return suite;
    }

    private static void testObjects() {
        suite.addTestSuite(TicketTest.class);
        suite.addTestSuite( SeatingTest.class);
        suite.addTestSuite(TheatreTest.class);

        suite.addTestSuite(ViewingTimeTest.class);
        suite.addTestSuite(TheatreMoviesTest.class);
	// Add Test Classes
    }

    private static void testBusiness() {
        suite.addTestSuite(CalculateTest.class);
        suite.addTestSuite(TrailerTest.class);
        suite.addTestSuite(AccessTheatreMoviesTest.class);
    }

}