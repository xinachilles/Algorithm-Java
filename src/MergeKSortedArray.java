import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public int[] merge(int[][] arrayOfArrays) {
        class Element implements Comparable<Element> {
            int arrayIndex;
            int elementIndex;
            int value;

            public Element(int indexArray, int indexElement, int value){
                this.arrayIndex = indexArray;
                this.elementIndex = indexElement;
                this.value = value;
            }

            public int compareTo(Element e){
                if(this.value == e.value){
                    return this.arrayIndex - e.arrayIndex;
                }else{
                    return this.value- e.value;
                }
            }
        }
        // Write your solution here

        PriorityQueue<Element> queue = new PriorityQueue<>();
        int total = 0;

        for(int i = 0; i<arrayOfArrays.length;i++){
            Element e = new Element(i,0,arrayOfArrays[i][0]);
            total += arrayOfArrays[i].length;
        }

        int[] result = new int[total];
        for(int i = 0; i<result.length; i++){
            Element e = queue.poll();
            result[i] = e.value;
            if(e.elementIndex+1< arrayOfArrays[e.arrayIndex].length){
                queue.offer(new Element(e.arrayIndex,e.elementIndex+1, arrayOfArrays[e.arrayIndex][e.elementIndex+1]));
            }
        }

        return result;

    }
}
