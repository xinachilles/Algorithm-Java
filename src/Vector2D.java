import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 2/8/17.
 */
public class Vector2D {
    List<Integer> vec;
    int index = 0;
    public Vector2D(List<List<Integer>> vec2d) {
        List<Integer> vec = new ArrayList<>();
        for(List<Integer> v : vec2d){
            for(Integer v1: v){
                vec.add(v1);
            }
        }
    }

    //@Override
    public Integer next() {
        return vec.get(index++);
    }

  //  @Override
    public boolean hasNext() {
        return index<vec.size();
    }
}
