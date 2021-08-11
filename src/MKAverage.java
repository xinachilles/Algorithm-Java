import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class MKAverage {
    int m = 0;
    int k = 0;
    int totalSum;
    //int totalNumber;
    TreeSet<Integer> left;
    TreeSet<Integer> right;
    TreeSet<Integer> mid;
    Queue<Integer> buffer;


    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
        totalSum = 0;

        left = new TreeSet<>();
        right = new TreeSet<>();
        mid = new TreeSet<>();
        buffer = new LinkedList<>();
    }

    private void add(int n) {
        left.add(n);
        if(left.size()>k){
            int big = left.pollLast();
            System.out.println("move"+big+"to mid");
            totalSum+=big;
            mid.add(big);
        }
        if(mid.size()>m){
            int big = mid.pollLast();
            System.out.println("move"+big+"to right");
            totalSum-=big;
            right.add(big);
        }

    }
    private void remove(int n){
        if(left.contains(n)){
            left.remove(n);
        }else if(mid.contains(n)){
            totalSum-=n;
            mid.remove(n);
        }else{
            right.remove(n);
        }

        if(left.size()<k){
            int small = mid.pollFirst();
            totalSum-=small;
            left.add(small);
        }
        if(mid.size()<m){
            int small = right.pollFirst();
            totalSum+=small;
            mid.add(small);
        }


    }

    public void addElement(int num) {
        if(buffer.size() >=m){
            remove(buffer.poll());
        }
        add(num);
        buffer.add(num);

    }

    public int calculateMKAverage() {
        if(buffer.size()<m) return -1;
        return totalSum/m;
    }
}
