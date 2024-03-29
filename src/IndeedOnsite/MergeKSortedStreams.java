package IndeedOnsite;

/* =============================================================================
Question Description

 /*
Given n sorted stream, and a constant number k. The stream type is like iterator
        and it has two functions, move() and getValue(), find a list of numbers that each
        of them appears at least k times in these streams. Duplicate numbers in a stream
        should be counted as once.

        Note: In the interview, we should use min heap method
 */

/*
suppose we have m stream and each stream have n item
* hashamp solution, class {int value int index (from which stream} O(n*m)
* put all item to a list, O(n*m)
* hash map O(n*m)
* sort the finally result = mnlog(mn)

for heap solucton: 1. build a heap = logm
finally each node need to be pushed into heap once mn*logm

K Stream 那一轮？如果假设有M个Stream，每个Stream的平均长度是N的话，那么如果用HashMap来做的话，
时间复杂度的话是O(MN + MNlog(MN)) 遍历+排序，空间复杂度是O(MN),
如果用heap来做的话，时间复杂度是O(MNlog(M))，空间复杂度是 O(M), 请问楼主这么分析是不是就够了？
* */
/*=============================================================================*/

import java.util.*;

/* =============================================================================
code
=============================================================================*/
class Stream{
    Iterator<Integer> iterator;
    public Stream(List<Integer> list){
        this.iterator = list.iterator();
    }
    public boolean move(){
        return iterator.hasNext();
    }
    public int getValue(){
        return iterator.next();
    }
}
class Num{
    int val;
    Stream stream;
    public Num(Stream stream){
        this.stream = stream;
        // current value of the stream
        this.val = stream.getValue();
    }
}
/*  这个是iterator的版本，我真无聊
    class Data{
        int val;
        Iterator ite;
        public Data(Iterator iterator){
            this.ite = iterator;
            this.val = ite.next();
        }
    }
*/
class MergeKSortedStreams {
    public List<Integer> getNumberInAtLeastKStream(List<Stream> lists, int k){
        List<Integer> res = new ArrayList<>();
        if (lists == null || lists.size() == 0) return res;
        // smallest number will be on the top
        PriorityQueue<Num> minHeap = new PriorityQueue<Num>((a,b)-> a.val-b.val);

        //先把所有的stream放进heap里面
        for (Stream s: lists) {
            if (s.move()){ //这里先判断一下要不就崩了
                minHeap.offer(new Num(s));
            }
        }
        // we pop the first element
        while (!minHeap.isEmpty()){
            Num cur = minHeap.poll();
            int curValue = cur.val;
            int count = 1;
            while (cur.stream.move()){
                int nextVal = cur.stream.getValue();
                // duplicate value
                if (nextVal == curValue){
                    continue;
                }
                else {
                    cur.val = nextVal;
                    minHeap.offer(cur);
                    break;
                }
            }
            //scan other streams in the heap 。
            while (!minHeap.isEmpty() && curValue == minHeap.peek().val){
                count++;
                Num num = minHeap.poll();
//                int numVal = num.val;

                while (num.stream.move()){
                    int nextVal = num.stream.getValue();
                    // skip the dupicate value in the same stream
                    if (curValue == nextVal){
                        continue;
                    }
                    else {
                        num.val = nextVal;
                        minHeap.offer(num);
                        break;
                    }
                }
            }

            if (count >= k){
                res.add(curValue);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MergeKSortedStreams test = new MergeKSortedStreams();
        Integer[] arr1 = {1,1,2,3,3,4,5};
        Integer[] arr2 = {1,2,5};
        Integer[] arr3 = {1,2,6};

        List<Integer> l1 = Arrays.asList(arr1);
        List<Integer> l2 = Arrays.asList(arr2);
        List<Integer> l3 = Arrays.asList(arr3);

        List<Stream> lists = new ArrayList<>();
        lists.add(new Stream(l1));
        lists.add(new Stream(l2));
        lists.add(new Stream(l3));

        List<Integer> res = test.getNumberInAtLeastKStream(lists, 2);
        System.out.println(res);
    }
}
/* =============================================================================
Follow Up
=============================================================================*/
/*
这题不让用map来做，根据2016年9月的面经得出的结论。
        http://www.1point3acres.com/bbs/thread-201699-1-1.html
        一是内存消耗太大，二是二是不是in order的排序，你弄完了result还得sort一下这个算法不是最优。
        follow up是一个stream特别长，其他都很短，怎么处理。

        可以提前结束？min heap的size比k小的时候提前结束。
        /* =============================================================================
        Follow Up code
        =============================================================================*/

/* =============================================================================
题目内容：
=============================================================================*/
   /*
        给n个stream，每个stream都是排好序的，找出现k次或以上的元素。在一个stream出现多次的算作1次。
        最后返回的就是一群数字，每个都在n个stream里面出现 ≥k 次。

        非常高频，必须准备3次。还有复杂度。到时候直接给出heap解法吧。
/* =============================================================================
地里面经总结
=============================================================================*/
/*
    <A> merge k sorted streams。但是要求是合并的结果中只包含出现在K个stream以上的元素，同一个stream中重复的次数不算。
<B> 输入是n个data stream 和 一个常数K，返回至少出现K次的数的list, 这个数必须在多于1个Stream中出现过。
public List<Integer> getK(List<Stream>, int K){}
        Stream有两个操作：
/*
interface Stream{
    boolean move(); //true means next postition has value
    int getValue();
}


    Ex: k = 2;

            [1,2,3,4]
            [2,5,6]
            [2,5,7]

            Ans: [2, 5]
<C> prduct manager 很健谈 也挺有意思的，聊了快半个点他说我们开始写代码吧，不然来不及。
        就是n个sorted stream，找到feq大于k的元素 从小到大的输出。freq每个stream只算一次。
        然后follow up是如果一个stream特别长其他的短怎么办
<D> stream 的type是iterator，input是（streams，k）
<E> 给 m streams, 找出freq至少k次的输出。
<F> n个非常长的有序数组，找出其中出现了至少k次的数字，用heap，用heap，用heap！重要的事情说三遍。
<G> 第一轮：get K appearances numbersin N sorted streams，问了复杂度，要求写几个test case跑一跑。
        笔记里面的11和3都是一道题。
<A> m个sorted lists，让你求出top k most frequent elements。
<B> merge k sorted streams，原题，但是楼主对iterator不是特别熟悉
<C> stream 的type是iterator，input是（streams，k）
        http://www.1point3acres.com/bbs/thread-148694-2-1.html 这里面有两个讨论的code

 */
