import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class MKAverage {
    int m = 0;
    int k = 0;

    int totalSum;
    //int totalNumber;
    TreeMap<Integer,Integer> left;
    TreeMap<Integer,Integer> right;
    TreeMap<Integer,Integer> mid;
    int sizeOfLeft;
    int sizeOfRight;
    int sizeOfMid;


    // for last m element
    Queue<Integer> buffer;


    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        totalSum = 0;
        sizeOfMid = 0;
        sizeOfLeft = 0;
        sizeOfRight = 0;
        left = new TreeMap<>();
        right = new TreeMap<>();
        mid = new TreeMap<>();
        buffer = new LinkedList<>();
    }

    private void remove(int n, TreeMap<Integer,Integer> map){

        map.put(n,map.get(n)-1);
        if(map.get(n)==0) map.remove(n);
    }

    private void add(int n) {
        left.put(n, left.getOrDefault(n,0)+1);
        sizeOfLeft++;

        System.out.println("add "+n);
        if(sizeOfLeft>k){
            int big = left.lastKey();
            System.out.println("move"+big+"from left to mid");
            remove(big,left);
            sizeOfLeft--;
            totalSum+=big;
            mid.put(big,mid.getOrDefault(big,0)+1);
            sizeOfMid++;
        }
        if(sizeOfMid>m-2*k){
            int big = mid.lastKey();
            System.out.println("move"+big+"from mid to right");
            remove(big,mid);
            sizeOfMid--;
            totalSum-=big;
            right.put(big,right.getOrDefault(big,0)+1);
            sizeOfRight++;
        }

    }
    private void remove(int n){
        System.out.println("remove "+n);
        if(left.containsKey(n)){
            remove(n,left);
            sizeOfLeft--;
            System.out.println("remove"+n+"from left");

        }else if(mid.containsKey(n)){
            System.out.println("remove"+n+"from mid");
            totalSum-=n;
            remove(n,mid);
            sizeOfMid--;
        }else{
            System.out.println("remove"+n+"from right");
            remove(n,right);
            sizeOfRight--;
        }

        if(left.size()<k){
            int small = mid.firstKey();
            System.out.println("move"+small+"from mid to left");
            totalSum-=small;
            remove(small,mid);
            sizeOfMid--;
            left.put(small,left.getOrDefault(small,0)+1);
            sizeOfLeft++;

        }

        if(!right.isEmpty() &&  sizeOfMid<m-2*k){
            int small = right.firstKey();
            System.out.println("move"+small+"from right to mid");
            remove(small,right);
            sizeOfRight--;
            totalSum+=small;
            mid.put(small,mid.getOrDefault(small,0)+1);
            sizeOfMid++;
        }


    }

    public void addElement(int num) {
        System.out.println("add element "+num);
        if(buffer.size() >=m){

            remove(buffer.poll());
        }
        add(num);
        buffer.add(num);

    }

    public int calculateMKAverage() {
        if(buffer.size()<m) return -1;
        System.out.println("total:"+totalSum+"average:"+totalSum/sizeOfMid);
        return totalSum/(m-2*k);
    }
}