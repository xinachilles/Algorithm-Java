package IndeedProgEx;
/*
* /* =============================================================================
题目内容：
=============================================================================*/

import java.util.*;

/*
    给出若干行的文字，再给query，输出所在的行数。行数要排序。先根据出现的频率排序，如果频率一样，
        就按照行数大小来排序。
        举例：
        a b     //1
        b a a   //2
        a b b   //3
        a       //4
        query(a),输出就是（2，1，3,4），query(b)输出(3,1,2)
        query(a & b) 输出(2,3,1)
        query(a | b) 输出(2,3,1,4)
        因为query(a&b)(a|b)的频率计算都是单独算a和b出现次数然后求和的。
        只不过或的时候更宽容一点儿吧，有一个就行，与的时候要两个都在。

        据说上机题只需要用到hashmap。
        然后计算频率的时候看清楚一些就行吧。
        还有上机题需要scanner么？

        暂时没什么想法，除了暴力做之外，可以把每个词的query单独拎出来，然后遇到a&b的时候就比较好做了。
        上机只有一轮，90分钟，看命了。
/* =============================================================================
code
=============================================================================*/




/* =============================================================================
地里面经总结
=============================================================================*/
/*
<A> 题目是经典题，给若干行文字，然后再给query，输出所以在行数，比如 第一行 java and python
        第二行 java and ， query 是 java，于是输出1,2. query可以是 java & pyhon 或者是java | python。
        输出是按照频率输出，楼主没看清题目，没弄清楚频率如何计算，于是只过了一个test case。。。。希望上机不要占太大权重。
<B> 就是那个search A或者A|B或者A&B的题。hackrank上做，有详细的解释。我暴力做的。。
        就一个个读然后判断符不符合，然后10个test case有两个超时了。不过据说他家面试主要看三轮白板，上机不太重要，
        然后根据我两个test case没过也有offer来看应该还真是白板更重要吧。
<C> 给一串query， 查找 a&b 或者a||b之类的frequency。不难，但是时间可能要抓紧，
        我处理cin cout花了半小时，最后五分钟才写完的。。。
<D> 给几行string，让你查找关键字出现的行，关键字可以是1个单词，也可以是2个单词（and，or）
        比如，java & python， java | python， java
<E> 给了一个file： indeed could do some java I love to use python ...
        然后叫你找 java这个单词出现在哪一行，然后java | python出现在哪一行，然后java & python出现在哪一行。
<F> query, A|B ,A&B,A那道题就是stduin处理比较麻烦。 最后有两个test case没有过，不知道影响不影响大局，好担心。
<G>下午online coding，也是面经题，用STDIN和STDOUT，输入如下：
        N
        ...
        ...  --> document，有N行string，每一个string是space delimited
        ....
        M
        ...
        A
        B & C  --> M行query
        D | E
        ...
        要求输出如下：对每一个query，依次print document中满足query条件的行号，其中行号根据key word出现频率排序，
        对于频率一样的，小的行号优先。
        其中出现的频率按照如下定义：如果string中单词A cnt1次，单词B cnt2次，则A&B和A | B的频率都按照cnt1 + cnt2计算。
        后面还有几道文字题目：分析时间和空间复杂度；如果给你一天时间完成，你还有什么优化，如果有很多很多记录，
        很多很多user querys，有什么优化。
*
*
* */

public class SearchQuery {
    //character -> number of this character in each row


    Map<String, int[]> maps = new HashMap<>();
    public SearchQuery(String[]input){
        BuildMap(input);
    }
    private void BuildMap(String[] input) {
        for (int i = 0; i < input.length; i++) {
            Map<String, Integer> temp = new HashMap<>();
            for (int j = 0; j < input[i].length(); j++) {
                char c = input[i].charAt(j);
                temp.put(String.valueOf(c) , temp.getOrDefault(String.valueOf(c) , 0) + 1);
            }
            for (String key : temp.keySet()) {
                if (maps.get(key) == null || maps.get(key).length == 0) {
                    maps.put(key, new int[input.length]);
                }
                maps.get(key)[i] = temp.get(key);
            }
        }

    }

    public List<Integer> query(String query) {
        List<String> input = new ArrayList<>();
        boolean orOperation = false;
        boolean andOperation = false;
        if (query.contains("|")) {
            String[] temp = query.trim().split("\\|");
            input.addAll(Arrays.asList(temp));
            orOperation = true;
        } else if (query.contains("&")) {
            String[] temp = query.trim().split("&");
            input.addAll(Arrays.asList(temp));
            andOperation = true;
        } else {
            input.add(query.trim());
        }

        List<Integer> result = new ArrayList<>();
        if (andOperation || orOperation) {
            if (input.size() != 2) {
                return null;
            }
            String a = input.get(0);
            String b = input.get(1);
            int[] linesForA = maps.get(a);
            int[] linesForB = maps.get(b);
            if (orOperation) {
                int max = 0;
                for (int i = 0; i < linesForA.length; i++) {
                    linesForA[i] += linesForB[i];
                    if (max < linesForA[i]) {
                        max = linesForA[i];
                    }
                }
                return sort(linesForA,max);
            }else {
                int max = 0;
                for (int i = 0; i < linesForA.length; i++) {
                    if (linesForA[i] != 0 && linesForB[i] != 0) {
                        linesForA[i] += linesForB[i];
                    } else {
                        linesForA[i] = 0;
                    }
                    if (max < linesForA[i]) {
                        max = linesForA[i];
                    }
                }
                return sort(linesForA,max);
            }
        }else{
            int[] lines = maps.get(query);
            int max = 0;
            for (int line : lines) {
                if (max < line) {
                    max = line;
                }
            }
            return sort(lines,max);
        }


    }
    // only return top 10
    private List<Integer>sort(int[]array, int max){
        List<Integer> result = new ArrayList<>();
        for(int i = max; i>=1;i--){
            for(int j = 0; j<array.length;j++){
               if(array[j] == i){
                   result.add(j);
               }
            }
        }
        if(result.size()>10){
            return result.subList(0,10);
        }else{
            return result;
        }

    }
    public static void main(String[] args) {
        String[] input = new String[]{"abd","acq","cqw"};
        SearchQuery search = new SearchQuery(input);
        List<Integer> result =  search.query("a|c");
        for(int r: result){
            System.out.println(r);
        }
    }
    }
