package AmazonOA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoppingOptions {
    public int getOptions(int[] a, int[] b, int[] c, int[] d, int dollars) {
        List<Integer> abPair = new ArrayList<>();
        List<Integer> cdPair = new ArrayList<>();

        createPair(a,b,abPair,dollars);
        createPair(c,d,cdPair,dollars);
        Collections.sort(abPair);
        Collections.sort(cdPair);

        int index1 = 0;
        int index2 = cdPair.size()-1;
        int result = 0;

        while (index1<abPair.size() && index2>=0){
            int sum = abPair.get(index1)+cdPair.get(index2);
            if(sum<=dollars){
                result+=(index2+1);
                index1++;
            }else{
                index2--;
            }

        }

        return result;
    }

    private void createPair(int[] a, int[]b, List<Integer> solution, int target){
        for(int a1: a){
            for(int b1:b){
                if(a1+b1<target){
                    solution.add(a1+b1);
                }
            }
        }
    }
}
