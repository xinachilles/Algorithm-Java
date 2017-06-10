package AmazonOA;

import org.junit.Test;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by xhu on 4/15/17.
 */
public class MovieOATest {
    @Test
    public void getMovieRecommendations() throws Exception {
        Movies m0 = new Movies(0,0);
        Movies m1  = new Movies(1,2);
        Movies m2 = new Movies(2,3);
        Movies m3 = new Movies(3,4);
        Movies m5 = new Movies(5,5);

        m0.updateSimilarMovies(new Movies[]{m1,m2});
        m1.updateSimilarMovies(new Movies[] {m3});
        m2.updateSimilarMovies(new Movies[]{m5});

        MovieOA target = new MovieOA();
        Set<Movies> result =  target.getMovieRecommendations(m0,1);
    }

}