/**
 * Created by xhu on 10/9/16.
 */
public class CompareVersionNumbers {
    // compare version number

    public int compareVersion(String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");


        int max = Math.max(version1Array.length, version2Array.length);

        for (int i = 0; i < max; i++) {

            Integer number1 =  i>= version1Array.length? 0: Integer.valueOf(version1Array[i]);
            Integer number2 =  i>= version2Array.length? 0: Integer.valueOf(version2Array[i]);


            if(number1 == number2){
                continue;
            }else {
                return number1.compareTo(number2);
            }

        }

        return 0;

    }


}
