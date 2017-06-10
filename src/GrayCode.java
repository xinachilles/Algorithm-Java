import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 11/5/16.
 */
public class GrayCode {
/*
    //Gray code
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }

        grayCodeHelper(n, result, "");

        return result;

    }

        private void grayCodeHelper(int n, List<Integer> result, String code) {
            if (code.length() == n) {
                int decode = Decode(code);
                result.add(decode);
                return;
            }


            for (int j = 0; j <= 1; j++) {
                grayCodeHelper(n, result, code.length() == 0 ? String.valueOf(j) : code + String.valueOf(j));
            }
        }

        private Integer Decode(String code){
            Integer num = 0;
            for(int i = 0; i<code.length();i++){
               num =  num + (int) Math.pow(2,i)* Character.getNumericValue(code.charAt(i));
            }

            return num;
        }*/
//gray code

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);

        if (n == 0) {
            return result;
        }


        StringBuilder current = new StringBuilder();
        for (int i = 0; i < n; i++) {
            current.append("0");
        }

        helper(n, current.toString(), result);
        return  result;
    }


    private void helper(int n, String current, List<Integer> result) {
        if (result.size() == Math.pow(2, n)) {
            return;
        }

        for (int i = 0; i < n; i++) {
            char[] arr  = current.toCharArray();
            if(arr[i] == '0'){
                arr[i] = '1';
            }else{
                arr[i] = '0';
            }

            int decode = decode(new String(arr));
            if (!result.contains(decode)) {
                result.add(decode);
                helper(n, new String(arr), result);
            }
        }

    }

    private int decode(String current) {
        int result = 0;

        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) == '1') {
                result = result + (int) Math.pow(2, i);
            }
        }

        return result;
    }

}
