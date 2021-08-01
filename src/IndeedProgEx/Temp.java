package IndeedProgEx;

import java.util.*;

class Untitled {
    // user -> the words he searched before
    public static Map<String, Set<String>> people = new HashMap<String, Set<String>>();
    // words -> list of user who searched this word before
   // public static Map<String, Set<String>> languages = new HashMap<String, Set<String>>();
    // words-> related words and times
    public static Map<String, Map<String, Integer>> finals = new HashMap<String, Map<String, Integer>>();
    public static Map<String, Maximal> cache = new HashMap<String, Maximal>();

    static class Maximal {
        public List<String> list;
        public int counter;
        public Maximal(){
            counter = 0;
            list = new ArrayList<String>();
        }
    }
    public static void main(String[] args) {
        String[] input = new String[] {"A,python",
                "B,java",
                "A,java",
                "B,php",
                "C,python",
                "C,java",
                "D,java"};
        for(String i: input){
            String[] info =i.split(",");
            String res = search(info[0], info[1]);
            updateCache(info[0],info[1]);
            System.out.println(res);
        }

    }
    public static void updateCache(String person, String language){
        people.putIfAbsent(person, new HashSet<String>());
        // langyage -> person and the language that person search before and times
        // user-> query word and how many time this person search this word
        finals.putIfAbsent(language, new HashMap<String, Integer>());
        cache.putIfAbsent(language, new Maximal());

        if (!people.get(person).contains(language)) {
            for (String l : people.get(person)) {
                finals.get(language).put(l, finals.get(language).getOrDefault(l, 0) + 1);
                if (cache.get(language).counter == finals.get(language).get(l)) {
                    // addList(cache.get(language).list, l);

                    if(!cache.get(language).list.contains(l)){
                        cache.get(language).list.add(l);
                    }


                } else if (cache.get(language).counter < finals.get(language).get(l)) {
                    cache.get(language).list = new ArrayList<String>();
                    cache.get(language).list.add(l);
                    cache.get(language).counter = finals.get(language).get(l);
                }

                finals.get(l).put(language, finals.get(l).getOrDefault(language, 0) + 1);

                if (cache.get(l).counter == finals.get(l).get(language)) {
                    // addList(cache.get(l).list, language);

                    if(!cache.get(l).list.contains(language)){
                        cache.get(l).list.add(language);
                    }


                } else if (cache.get(l).counter < finals.get(l).get(language)) {
                    cache.get(l).list = new ArrayList<String>();
                    cache.get(l).list.add(language);
                    cache.get(l).counter = finals.get(language).get(l);
                }

            }

            people.get(person).add(language);
        }
    }
    public static String search(String person, String language) {

        cache.putIfAbsent(language, new Maximal());
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<String>(cache.get(language).list);
        int counter = cache.get(language).counter;




        Collections.sort(list);
        sb.append(counter);
        for (String s: list) {
            sb.append(" " + s);
        }
        return sb.toString().trim();
    }

    public static void addList(List<String> list, String target) {
        int index = Collections.binarySearch(list, target);
        if (index < 0) {
            index = -(index + 1);
        }
        if (index == list.size()) {
            list.add(target);
        } else {
            list.add(index, target);
        }
    }



    }



