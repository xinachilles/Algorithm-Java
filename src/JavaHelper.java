import java.util.*;

/**
 * Created by xhu on 3/9/17.
 */
public class JavaHelper {
    class Time implements  Comparable<Time>{
        int time;
        boolean isStart;

        public Time(int time, boolean isStart){
            this.time = time;
            this.isStart = isStart;

        }

        @Override
        public  int compareTo(Time a){
            if(this.time == a.time){
                if(this.isStart){
                    return -1;
                }else{
                    return  1;
                }
            }else{
                return this.time - a.time;
            }

        }

    }

    public void Helper(){
        String str = "abc";
        char[] arr  = str.toCharArray();
        String str2 = new String(arr);

        int length = str.length();
        int result = 1+ (int)Math.pow(2,3);


        Map<Integer, Integer> counts = new HashMap<>();

        //Transfer as List and sort it
        ArrayList<Map.Entry<Integer, Integer>> l = new ArrayList(counts.entrySet());
        Collections.sort(l, new Comparator<Map.Entry<Integer, Integer>>() {

            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        //covert int to char
        int i = 2;
        char c = (char)(i+'0');


        // priority queue

        //descending order
        PriorityQueue<Integer> queue = new PriorityQueue<>(5, Collections.reverseOrder());
        Map<Integer,PriorityQueue<Integer>> records = new HashMap<Integer,PriorityQueue<Integer>>();


        // string builder

        StringBuilder s = new StringBuilder();
        s.deleteCharAt(1);

        char a = '2';
        //Character.isDigit(char c)
        //Integer.parseInt(a);

        // bit

        //int a = Integer.MAX_VALUE; //2,147,483,647
        //int b = Integer.MIN_VALUE; //2147483648

        Map<Integer, Integer> maps = new HashMap<>();
        int[] nums = new int[]{1,2,3,4};
        for (int j : nums) {
            maps.put(j,maps.getOrDefault(j,0)+1);

        }


        List<Time> time = new ArrayList<>();
        Collections.sort(time);


        List<Character>[] sort = new List[5];
    }
}
