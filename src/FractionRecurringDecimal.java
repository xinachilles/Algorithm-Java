import java.util.HashMap;

/**
 * Created by xhu on 9/25/16.
 */
public class FractionRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator){
        if(denominator == 0){
            return "Null";
        }

        StringBuilder solution     = new StringBuilder();
        if(numerator *denominator <0){
            solution.append("-");
        }

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        int integerPart = numerator/denominator;
        int reminder = numerator % denominator;

        solution.append(String.valueOf(integerPart));
        if(reminder == 0){
            return solution.toString();
        }else{
            solution.append(".");
            // need a hashmap to store the current reminder and its length.
            // for example, 1/3: result = 0 (interger part). fraction part is 3 and length for this fraction part is 2 (0.)
            HashMap<Integer,Integer> maps = new HashMap<>();
            while(reminder>0){
                if(!maps.containsKey(reminder)){
                    maps.put(reminder, solution.length());
                }else{
                    solution.insert(maps.get(reminder),"(").append(")");
                    return  solution.toString();
                }

                numerator = reminder*10;
                integerPart = numerator/denominator;
                solution.append(String.valueOf(integerPart));
                reminder = numerator%denominator;
            }
        }

        return "";
    }
}
