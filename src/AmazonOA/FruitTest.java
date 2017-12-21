package AmazonOA;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FruitTest {

    @Test
    public void fruit() {
            Fruit test = new Fruit();

            List<String> code1 = Arrays.asList(new String[]{"apple","apricot"});
            List<String> code2 = Arrays.asList(new String[] {"banana", "anything","guava"});
            List<String> code3 = Arrays.asList(new String[] { "papaya","anything"});
            //List<String> code4 = Arrays.asList(new String[] {"banana"});


        //List<String> code2 = new List<string>(new String[] {"apple","apple","banana"}.ToList<String>());

          //  List<String> shoppingCart = Arrays.asList(new String[] { "orange", "apple", "apple", "banana", "orange","apple","banana" });

            //List<String> shoppingCart = new List<string>(new String[] { "apple", "banana", "apple", "banana", "orange", "banana" }.ToList<String>());
           List<String> shoppingCart = Arrays.asList(new String[] {"banana", "orange", "guava", "apple", "apricot", "papaya", "kiwi"});




            //List<String> code1 = new List<string>(new String[] {"orange"}.ToList<String>());

            //List<String> code2 = new List<string>(new String[] { "apple", "apple" }.ToList<String>());

            //List<String> code3 = new List<string>(new String[] { "banana","orange","apple"}.ToList<String>());

            //List<String> code4 = new List<string>(new String[] { "banana" }.ToList<String>());





            //List<String> code1 = new List<string>(new String[] {"apple","apricot "}.ToList<String>());

            //List<String> code2 = new List<string>(new String[] { "banana", "anything","guava"}.ToList<String>());

           // List<String> code3 = new List<string>(new String[] { "papaya","anything"}.ToList<String>());





            //List<String> shoppingCart = new List<string>(new String[] { "banana", "orange", "guava", "apple", "apricot", "papaya", "kiwi" }.ToList<String>());



            List<List<String>> code  = new ArrayList<>();

            code.add(code1);

            code.add(code2);

            code.add(code3);

           // code.add(code4);



            int result =  test.fruit(code, shoppingCart);

        }


    }
