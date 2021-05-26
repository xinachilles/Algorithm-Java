package IndeedOnsite;

import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

/* =============================================================================
Question Description
=============================================================================*/
/*
Given a stream of input, and a API int getNow() to get the current time stamp,
         Finish two methods:

         1. void record(int val) to save the record.
         2. double getAvg() to calculate the averaged value of all the records in 5 minutes.
/* =============================================================================
code
=============================================================================*/
class Event{
    int val;
    int time;
    public Event(int val, int time){
        this.val = val;
        this.time = time;
    }
}
public class MovingAverage {
    private Queue<Event> queue = new LinkedList<>();
    private int sum = 0;

    //这个是每次记录读进来的时间的,这个不用自己写,就是直接返回当前系统时间
    private int getNow(){
        return 0; //暂时写个0，苟活
    }

    private boolean isExpired(int curTime, int preTime){
        return curTime - preTime > 300;
    }
    private void removeExpireEvent(){
        while (!queue.isEmpty() && isExpired(getNow(), queue.peek().time)){
            Event curE = queue.poll();
            sum -= curE.val;
        }
    }
    public void record(int val){
        Event event = new Event(getNow(), val);
        queue.offer(event);
        sum += val;

        removeExpireEvent();
    }

    public double getAvg(){
        removeExpireEvent();
        if (!queue.isEmpty()){
            return (double) sum/queue.size();
        }

        return 0.0;
    }


    //实现find Median，其实O1操作的话，要始终维护两个heap，这样塞进去会很慢
//原有基础上实现的话，那就直接quick select的办法了。
//复杂度是On in average and O^2 worst，因为每次average case是去掉一半，就是O(n)+O(n/2)+O(n/4)+... 最后出来是O(2n)

    public double getMedian() {
        removeExpireEvent();
      //  int[] temp = new int[queue.size()];
        List<Integer> temp = new ArrayList(queue);

        int len = temp.size();
        Integer[] intArray = new Integer[len];
        if (len % 2 == 0) {
            return 0.5 * (findKth(temp.toArray(intArray), len / 2, 0, len - 1) + findKth(temp.toArray(intArray), len / 2 - 1, 0, len - 1));
        }
        return (double) findKth(temp.toArray(intArray), len / 2, 0, len - 1);
    }

    public int findKth(Integer[] temp, int k, int start, int end) {
        if(start>=end){
            return temp[start];
        }
        int r = ThreadLocalRandom.current().nextInt(start,end+1);
        swap(temp,r,start);
        int pivot = temp[start];
        int lo = start, hi = end;
        while (lo <= hi) {
            while (lo<=hi && temp[hi] > pivot ) {
                hi--;
            }
            while (lo<=hi && temp[lo] <= pivot) {
                lo++;
            }
            if(lo<=hi) {
                swap(temp, lo, hi);
                lo++;
                hi--;
            }
        }
        swap(temp, start, hi);
        // or k+1 == hi (if k start with 1)
        if (k == hi) {
            return pivot;
        } else if (k < hi) {
            return findKth(temp, k, start, hi - 1);
        }else {

            return findKth(temp, k, hi + 1, end);
        }
    }

    public void swap(Integer[] temp, int left, int right) {
        int i = temp[left];
        temp[left] = temp[right];
        temp[right] = i;
    }
    public static void main(String[] args) {
      MovingAverage av = new MovingAverage();
      Integer[] array = new Integer[]{1,4,6,8,5,7};
      int len = array.length;
      if (len % 2 == 0) {
            System.out.println( 0.5 * (av.findKth(array, len / 2, 0, len - 1) + av.findKth(array, len / 2 - 1, 0, len - 1)));
        }else {
          System.out.println(av.findKth(array, len / 2, 0, len - 1));
      }
    }
}

    /* =============================================================================
    中文描述
    =============================================================================*/
    /*
    一个Data Stream输入，每次读进来一个数。完成两个函数。
        1.record(int val)，输入的时候每次都自动调用record。
        2.getAvg(),返回最近5分钟的平均值。

        其实就是维护一个queue和一个sum，建个新的类，把每次读进来的值和时间捏在一起。
        注意每次读进来之后都把过期的丢掉，为了省空间。
        求平均值之前也把过期的扔了，这个肯定啊。

     */
/* =============================================================================
以下是地里面经搜集
=============================================================================*/
/*
<A> moving avg，就是一个stream输入，给一个int getNow()API获取当前timestamp，
        完成两个函数void record(int value)和double getAvg()，有输入时会自动call record，
        然后call getAvg()时返回5分钟内的平均值。用一个queue来存数据，一个sum存当前和，
        每次record和getAvg时pop掉过期的数据就好了。
        follow up： 如果还要getMedium呢？我说用two heap，他说太慢了因为record要o(logN)，说这个getMedium call得很少，
        可以直接在当前的数据结构上implement，于是其实就是求unsorted list的medium，用quick select能O(n)时间得到，面试官表示很满意。

<B> moving average，写一个类，
        有三个方法，getNow能获取当前时间，int record（int value）记录data point，double getAvg（）记录最近五分钟内的平均值，
        用queue维护最近五分钟的data point，用sum维护和就可以了。record和getAvg都得把五分钟以外的data point去除。
        follow up是如果memory不够怎么办

<C> 给一个流， 不停有数进来，然后实现一个avg（），每次call这个函数就返回前 5 分钟所有数的平均值。
        参考：可以用队列，或者升级版（节约空间）- 数组，每个元素存一定时间间隔

<D> 输入还是一个数据流，实现一个函数
public double getAvg(int[] A); 返回call这个函数时倒数5分钟内数据的平均值 有个一 public long time(); 可以用来返回当前时间。
        如果数据点非常密集，5分钟内的所有点会爆内存怎么办，
        */




