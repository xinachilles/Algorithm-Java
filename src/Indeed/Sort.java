package Indeed;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Sort {
    public static List<Integer> sortTwoArray(int[]a, int[]b){
        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList<>();
        while(i<a.length || j<b.length){
            if(i == a.length){
                result.add(b[j]);
                j++;
            }else if(j == b.length){
                result.add(a[i]);
                i++;
            }else if(a[i]<=b[j]){
                result.add(a[i]);
                i++;
            }else{
                result.add(b[j]);
                j++;
            }
        }

        return result;

    }
    static class Index{
        int row;
        int col;
        int value;
        public Index(int row, int col,int value){
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
   public static List<Integer>  sortMutiplArray(List<int[]> input){
        PriorityQueue<Index> heap = new PriorityQueue<>((a,b)-> input.get(a.row)[a.col]-input.get(b.row)[b.col] );
        for(int i = 0; i<input.size();i++){
            heap.offer(new Index(i,0, input.get(i)[0]));
        }
        List<Integer> result = new ArrayList<>();
        while (!heap.isEmpty()){
            Index i  = heap.poll();
            result.add(i.value);
            int row = i.row;
            int col = i.col;
            if(input.get(row).length>col+1){
                heap.offer(new Index(row,col+1, input.get(row)[col+1]));
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[]array1  = new int[]{1,2,3,4};
        int[]array2 = new int[]{3,5,7,9,10};
        int[]array3 = new int[]{4,5,7,9,10,11};
        List<int[]> input= new ArrayList<>();
        input.add(array1);
        input.add(array2);
        input.add(array3);

        List<Integer> result = sortMutiplArray(input);
        result.stream().forEach(System.out::println);
    }
}
