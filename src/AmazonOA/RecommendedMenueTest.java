package AmazonOA;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecommendedMenueTest {

    @Test
    public void recommendedMenue() {
        RecommendedMenue test = new RecommendedMenue();

        String[][] menu = new String[][] { new String[] { "Pizza", "Italian" },

                new String[] { "Pasta", "Italian" },

                new String[] { "Burger", "American"},

        };



        //String[][] personPreference = new String[][] { new String[] { "Peter", "Italian" },

        //                                   new String[] { "Adam", "American" }};

        String[][] personPreference = new String[][] { new String[] { "Peter", "*" },

        };



        String[][] result = test.RecommendedMenue(menu,personPreference);
    }
}