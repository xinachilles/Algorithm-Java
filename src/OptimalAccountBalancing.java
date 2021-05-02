import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {
    int result = Integer.MAX_VALUE;
    public int minTransfers(int[][] transactions) {
        if(transactions == null|| transactions.length ==0 ){
            return 0;
        }
        Map<Integer,Integer> balance = new HashMap<>();
        for(int[] trans: transactions){
            balance.put(trans[0],balance.getOrDefault(trans[0],0)+trans[2]);
            balance.put(trans[1],balance.getOrDefault(trans[1],0)-trans[2]);
        }

        DFS(new ArrayList<>(balance.values()),0,0);
        return result;
    }

    private void DFS(List<Integer> balance, int start, int step){
        // skip all the 0 balance
        while (start<balance.size() && balance.get(start)==0){
            start++;
        }
        if(start == balance.size()){
            result= Math.min(result,step);

        }

        for(int i = start+1;i<balance.size(); i++){
             if(balance.get(start)*balance.get(i)<0){
                 // balance the start account and i account or move the money from start to i account...
                 balance.set(i,balance.get(start)+balance.get(i));
                  DFS(balance,start+1,step+1);
                 balance.set(i,balance.get(i)-balance.get(start));
             }

        }
    }
}
