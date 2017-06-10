import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 2/8/17.
 */
public class ZigzagIterator {
    List<Integer> v;
    int index = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        v = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;


        while(index1<v1.size() && index2<v2.size()){
            v.add(v1.get(index1));
            index1++;
            v.add(v2.get(index2));
            index2++;
        }

        while(index1<v1.size()){
            v.add(v1.get(index1));
            index1++;
        }

        while(index2<v2.size()){
            v.add(v2.get(index2));
            index2++;
        }

    }

    public int next() {

        return v.get(index++);

    }

    public boolean hasNext() {

        return index<v.size();
    }
}
