package AmazonOA;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PartitionTest {

    @Test
    public void partition() {




            // List<char> chars = new List<char>(new char[] { 'a', 'b', 'a', 'b', 'c', 'b', 'a', 'c', 'a', 'd', 'e', 'f', 'e', 'g', 'd', 'e', 'h', 'i', 'j', 'h', 'k', 'l', 'i', 'j' }.ToList<char>());

            // List<char> chars = new List<char>(new char[] {'a', 'b', 'c', 'd', 'a', 'e', 'f', 'g', 'h', 'i', 'j' }.ToList<char>());

            List<Character> chars = Arrays.asList(new Character[] { 'a', 'b', 'a' ,'c' ,'d' ,'f' ,'e' ,'f', 'f', 'h' ,'i', 'j', 'k', 'i', 'k' });

            // abacdfeffhijkik

            Partition test = new Partition();

            List<Integer> result = test.partition(chars);

        }

    }
