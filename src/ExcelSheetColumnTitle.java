/**
 * Created by xhu on 6/19/17.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        if(n<=0){
            return "";
        }

        String result = "";
        while(n>0){
            result = result + String.valueOf((char) ((n-1)%26+'A'));

            n = n/26;
        }

        return result;

    }
}
