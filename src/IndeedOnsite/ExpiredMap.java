package IndeedOnsite;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ExpiredMap {
    class Node {
        String val;
        double expired_time;
        Node() {}
        public Node(String val, double expired_time) {
            this.val = val;
            this.expired_time = expired_time;
        }
    }

    Map<String, Node> map = new HashMap<>();
   public int get(String key, String  val) {
        double now = System.currentTimeMillis();
        Node current = map.get(key);
        if(current == null) return -1;
        if (current.expired_time <= now) {
            map.remove(key);
            return -1;
        }
        current.val = val;
        map.put(key,current);
        return 0;
    }


    // duration -- second
    void put(String key, String val, int duration) {
        double now = System.currentTimeMillis();
        double expired_time = now + duration*1000;
        map.put(key, new Node(val,expired_time));
    }
    // whoever expire first is in front
    PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
        if(map.get(a).expired_time == map.get(b).expired_time ) {
            return map.get(a).val.compareTo(map.get(b).val);
        }else{
            return (int)(map.get(a).expired_time-map.get(b).expired_time);
        }

    });

    public void checkExpire() {
        synchronized (this) {
            double now = System.currentTimeMillis();
            while (!pq.isEmpty() && map.get(pq.peek()).expired_time <= now) {
                String key = pq.poll();
                map.remove(key);

            }

        }
    }

    public int get2(String key, String  val) {

        checkExpire();
        Node current = map.get(key);
        if(current == null) return -1;
        current.val = val;
        map.put(key,current);
        return 0;
    }
    void put2(String key, String val, int duration) {
        checkExpire();
        double now = System.currentTimeMillis();
        double expired_time = now + duration*1000;
        map.put(key, new Node(val,expired_time));
        pq.offer(key);
    }

    /*
    * 接着还能优化吗？
当然了了，直接开喷就⾏行行了了:
如果不不是因为⾯面试时间不不够，我不不会⽤用map，因为直接server⼀一挂缓存数据全没了了
我会选基于共享内存的hashtable,每个节点是个linked list
这样lock granularity会特别⼩小，并且⽤用cas可以实现lock-free
然后priority queue这个⽤用 skip list 替换，也可以在多线程⾥里里效率很⾼高
结了了，不不吹逼的讲，这应该是⼯工程中的很优的解法了了
能讲出这些东⻄西⾯面试官应该⽬目瞪⼝口呆了了，⼼心想：你TM懂的不不少啊
但是注意要循序渐进，别TM上来⾃自⼰己就要写个hashtable，那是闲的蛋疼。
    *
    * */

}
