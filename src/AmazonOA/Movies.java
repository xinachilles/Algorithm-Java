package AmazonOA;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 4/14/17.
 */
class Movies {
    private int id;
    private float rate;
    private List<Movies> similarMovies;

    public Movies(int id, float rate) {
        this.id = id;
        this.rate = rate;

        similarMovies =  new ArrayList<>();

    }

    public float getRating(){
        return rate;
    }

    public int getId(){
        return id;
    }
    public List<Movies> getSimilarMovies(){
        return similarMovies;
    }

    public  void updateSimilarMovies(Movies[] movies){
        for(Movies m : movies){
            similarMovies.add(m);
        }
    }
}
