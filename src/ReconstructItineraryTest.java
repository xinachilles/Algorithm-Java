import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xhu on 9/26/16.
 */
public class ReconstructItineraryTest {

    @Test
    public void testFindItinerary() throws Exception {
        ReconstructItinerary target = new ReconstructItinerary();
        //String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
       // String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
        String[][] tickets = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
       // target.findItinerary(tickets);
    }
}