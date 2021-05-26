package Indeed;

import java.util.*;

public class Encrypt {
    // only translate alphabet, and keep the rest as original character;
//keep upper/lower case during translation;
//it's guarantee all a-z exist in the key string, caseless;

    public static List<String> encryp2(String[]dic, String cipher) {
        Map<Integer, List<String>> wordLength = new HashMap<>();
        for (String word : dic) {
            wordLength.computeIfAbsent(word.length(), a -> new ArrayList<>()).add(word);
        }
        // there are how many way can decoding the cipher
        Set<Integer> set = new HashSet<>();
        numDecodingHelper(cipher, 0, 0, set);
        List<String> result = new ArrayList<>();
        for (int key : wordLength.keySet()) {
            if (set.contains(key)) {
                result.addAll(wordLength.get(key));

            }
        }

            return result;
    }




    private static void numDecodingHelper(String s, int index,int count,Set<Integer> set) {
        if (index == s.length()) {
            set.add(count);
            return;
        }

        // only take one
        if (index + 1 <= s.length()) {
            int number = Integer.valueOf(s.substring(index, index + 1));
            if (number >= 1 && number <= 9) {
                numDecodingHelper(s, index + 1,count+1,set);
            }
        }
        // take two
        if (index + 2 <= s.length()) {
            int number = Integer.valueOf(s.substring(index, index + 2));
            if (number >= 10 && number <= 26) {
                numDecodingHelper(s, index + 2,count+1,set);
            }

        }
    }

    public static List<String> encryp3(String[]dic, String cipher) {
        List<String> result = new ArrayList<>();
        for(String d : dic){
            if(wordPatternMatch(d,cipher)){
                result.add(d);
            }
        }
        return result;
    }



    public static boolean wordPatternMatch(String pattern, String str) {
        if (pattern == null || str == null) {
            return false;
        }

        Map<Character, String> patToStr = new HashMap<>();
        Map<String,Character> strToPat = new HashMap<>();

        Set<String> sets = new HashSet<>();
        return wordPatternMatchHelper(pattern, str, patToStr,strToPat);
    }

    private static boolean wordPatternMatchHelper(String pattern, String str, Map<Character, String> patToStr, Map<String, Character> strToPat) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        char pat = pattern.charAt(0);
        for (int i = 0; i < str.length(); i++) {

            String word = str.substring(0, i + 1);
            if(Integer.valueOf(word)>26){
                return false;
            }

            if (!patToStr.containsKey(pat) && !strToPat.containsKey(word)) {
                patToStr.put(pat, word);
                strToPat.put(word, pat);

                if (wordPatternMatchHelper(pattern.substring(1), str.substring(i + 1), patToStr, strToPat)) {
                    return true;
                }

                patToStr.remove(pat);
                strToPat.remove(word);
            } else {
                if (patToStr.containsKey(pat) && strToPat.containsKey(word) && (patToStr.get(pat).equals(word)) && (strToPat.get(word).equals(pat))) {
                    if (wordPatternMatchHelper(pattern.substring(1), str.substring(i + 1), patToStr, strToPat)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }

    public static void main(String[] args) {
        //String[] dictionary2 = { "AXE", "CAT", "AT", "OR", "A", "COO", "CARD" };
        String[] dictionary2 = {"BOXY", "BORN", "FORTH", "FROTH", "ARTERY", "ACES", "PORTO", "THOR"};

        String ciphertext6 = "10251826";
        List<String> result= encryp3(dictionary2,ciphertext6);
    }

    }


