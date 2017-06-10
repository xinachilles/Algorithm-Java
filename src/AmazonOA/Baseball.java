package AmazonOA;

import java.util.*;

/**
 * Created by xhu on 4/14/17.
 */
public class Baseball {
  /*  5 : sum = 5
            -2 : sum = 5 - 2 = 3
            4 : sum = 3 + 4 = 7
    Z : sum = 7 - 4 = 3
    X : sum = 3 + -2 * 2 = -1 (因为4被移除了，前一个成绩是-2)
            9 : sum = -1 + 9 = 8
            + : sum = 8 + 9 - 4 = 13 (前两个成绩是9和-4)
            + : sum = 13 + 9 + 5 = 27 (前两个成绩是5 和 9)*/
    public int test(String[] score){

        int sum = 0;

        if(score == null || score.length  == 0){
            return 0;
        }

        Stack<Integer> scoreItem = new Stack<>();
        for(String s: score){
            int newScore = 0;
            if(s.equals("Z")){
                if(scoreItem.isEmpty()){
                    return  sum;
                }else{
                    newScore = -scoreItem.pop();

                }
            }else if(s.equals("X")){
                newScore = scoreItem.peek() *2;

            }else if(s.equals("+")){
                if(scoreItem.size()<2){
                    return sum;
                }

                int first  = scoreItem.pop();
                int second  = scoreItem.pop();

                newScore = first+second;

                scoreItem.push(second);
                scoreItem.push(first);
            }else{
                newScore = Integer.valueOf(s);

            }

            sum = sum +newScore;
            if(!s.equals("Z")) {
                scoreItem.push(newScore);
            }
        }

        return sum;
    }
}
