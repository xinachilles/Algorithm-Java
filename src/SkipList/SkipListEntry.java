package SkipList;

/**
 * Created by xhu on 5/16/17.
 */
public class SkipListEntry {


    public String key;
    public Integer value;

    public SkipListEntry up;       // up link
    public SkipListEntry down;     // down link
    public SkipListEntry left;     // left link
    public SkipListEntry right;    // right link

    public static String negInf = "-oo";  // -inf key value
    public static String posInf = "+oo";  // +inf key value

    public SkipListEntry(String key, Integer value){
        this.key  = key;
        this.value = value;
    }
}
