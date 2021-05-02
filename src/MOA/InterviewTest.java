package MOA;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class InterviewTest {
    @Test
    public void test1() throws Exception {
        Interview target = new Interview();
        int result = target.test1(new int[][]{{0,0,1,0},{0,0,1,0},{0,0,0,0},{0,0,1,0}});



    }
    @Test
    public void test2() throws Exception {
        Interview target = new Interview();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('b');
        set.add('c');
        set.add('d');
        String result = target.test2("aaaabaacd",set);



    }
}