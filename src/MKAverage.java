import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class MKAverage {
    int m = 0;
    int k = 0;
    int sizeOfMid;
    int totalSum;
    //int totalNumber;
    TreeMap<Integer,Integer> left;
    TreeMap<Integer,Integer> right;
    TreeMap<Integer,Integer> mid;
    // for last m element
    Queue<Integer> buffer;


    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        totalSum = 0;
        sizeOfMid = m-2*k;
        left = new TreeMap<>();
        right = new TreeMap<>();
        mid = new TreeMap<>();
        buffer = new LinkedList<>();
    }

    private void add(int n) {
        left.put(n, left.getOrDefault(n,0)+1);
        System.out.println("add "+n);
        if(left.size()>k){
            int big = left.lastKey();
            System.out.println("move"+big+"from left to mid");
            left.put(big,left.get(big)-1);
            if(left.get(big)==0) left.remove(big);
            totalSum+=big;
            mid.put(big,mid.getOrDefault(big,0)+1);
        }
        if(mid.size()>sizeOfMid){
            int big = mid.pollLast();
            System.out.println("move"+big+"from mid to right");
            totalSum-=big;
            right.add(big);
        }

    }
    private void remove(int n){
        System.out.println("remove "+n);
        if(left.containsKey(n)){
            System.out.println("remove"+n+"from left");
            left.remove(n);
        }else if(mid.contains(n)){
            System.out.println("remove"+n+"from mid");
            totalSum-=n;
            mid.remove(n);
        }else{
            System.out.println("remove"+n+"from right");
            right.remove(n);
        }

        if(left.size()<k){
            int small = mid.pollFirst();
            System.out.println("move"+small+"from mid to left");
            totalSum-=small;
            left.add(small);
        }

        if(!right.isEmpty() &&  mid.size()<sizeOfMid){
            int small = right.pollFirst();
            System.out.println("move"+small+"from right to mid");
            totalSum+=small;
            mid.add(small);
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
        return totalSum/sizeOfMid;
    }
}