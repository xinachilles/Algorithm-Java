import java.util.HashMap;

/**
 * Created by xhu on 3/26/17.
 */
public class fractionToDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0){
            return "Null";
        }

        StringBuilder solution     = new StringBuilder();
        solution.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");

        long num =  Math.abs((long)numerator);
        long den =  Math.abs((long)denominator);

        long integerPart = num/den;
        long reminder = num % den;

        solution.append(String.valueOf(integerPart));
        if(reminder == 0){
            return solution.toString();
        }else{
            solution.append(".");
            // need a hashmap to store the current reminder and its length.
            // for example, 1/3: result = 0 (interger part). fraction part is 3 and length for this fraction part is 2 (0.)
            HashMap<Long,Integer> maps = new HashMap<>();
            while(reminder>0){
                if(!maps.containsKey(reminder)){
                    maps.put(reminder, solution.length());
                }else{
                    solution.insert(maps.get(reminder),"(").append(")");
                    break;
                }

                num = reminder*10;
                integerPart = num/den;
                reminder = num%den;
                solution.append(String.valueOf(integerPart));

            }
        }

        return solution.toString();
    }
}
