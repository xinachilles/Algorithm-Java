import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SnapshotArray {
    // data[i] is a treemap and key is snap id and value is the value for this snap id
    // treemap is sorted by snap id
    // if value is not change,we don't know store the snap for whole array each time when user call snap
    TreeMap<Integer, Integer>[] data;
    int snapId;

    public SnapshotArray(int length) {

        data = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            data[i] = new TreeMap<Integer, Integer>();
            data[i].put(0, 0);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        if(index>=data.length){
            return;
        }

        data[index].put(snapId,val);


    }

    public int snap() {
        snapId++;
        return snapId;
    }

    public int get(int index, int snap_id) {
        // the biggest entry which is equal or smaller than the current snap_id
        data[index].floorEntry(snap_id).getValue();
        return snap_id;
    }
}
