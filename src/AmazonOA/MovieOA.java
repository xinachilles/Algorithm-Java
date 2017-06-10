package AmazonOA;

import java.util.*;

/**
 * Created by xhu on 4/14/17.
 */

 class MovieComparator implements Comparator<Movies> {

    @Override
    public int compare(Movies x, Movies y){
        if(x.getRating()<y.getRating()){
            return -1;
        }else if(x.getRating()>y.getRating()){
            return 1;
        }else{
            return 0;
        }
    }
}
public class MovieOA {
    public Set<Movies> getMovieRecommendations(Movies movies, int N){
        Set<Movies>  result  =  new HashSet<>();
        if(movies == null){
            return result;
        }

        Set<Movies> visted = new HashSet<>();

        Queue<Movies> visiting = new LinkedList<>();
        visiting.offer(movies);


        PriorityQueue<Movies> topN = new PriorityQueue<>(N,new MovieComparator());

        while(!visiting.isEmpty()){
            Movies current = visiting.poll();
            visted.add(current);

            for(Movies m : current.getSimilarMovies()){
                if(!visted.contains(m)){
                    visiting.offer(m);
                    if(topN.size()>=N) {

                        if (topN.peek().getRating() < m.getRating()) {
                            topN.poll();
                        }else{
                            continue;
                        }
                    }
                    topN.offer(m);
                }
            }

        }

        while (!topN.isEmpty()){
            result.add(topN.poll());
        }

        return result;
    }

}
