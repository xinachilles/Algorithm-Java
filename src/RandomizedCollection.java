import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by xhu on 11/6/16.
 */
public class RandomizedCollection {
    public List<Integer> list;

    public RandomizedCollection(){
        list = new ArrayList<>();

    }

    public boolean insert(int val)
    {
        boolean isContains = list.contains(val);
        list.add(val);

        return isContains;
    }

    public boolean remove(int val)
    {
        if (list.contains(val))
        {
            list.remove(list.indexOf(val));
            return true;
        }
        else
        {
            return false;
        }
    }

    public int getRandom()
    {
        Random r = new Random();
        int index = r.nextInt(list.size());

        return list.get(index);
    }
}
