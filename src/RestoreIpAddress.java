import java.util.ArrayList;
import java.util.List;

/**
 * Created by xhu on 10/17/16.
 */
public class RestoreIpAddress {
   /* *//*public List<String> restoreIPAddresses2(String s)
    {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0)
        {
            return result;
        }


        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i + 1; j < s.length() && j - i < 3; j++)
            {

                for (int m = j + 1; m < s.length() && m - j < 3; m++)
                {
                    for (int n = m + 1; n < s.length() && n - m < 3; n++)
                    {
                        String s1 = s.substring(i,j);
                        String s2 = s.substring(j,m);
                        String s3 = s.substring(m,n);
                        String s4 = s.substring(n,s.length());

                        if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
                            result.add((s1+"."+s2+"."+s3+"."+s4 ));
                        }
                    }
                }
            }
        }
                        return result;

    }
*//*
    //ip address
    public List<String> restoreIpAddresses(String s)
    {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0)
        {
            return result;
        }

        restoreIpAddress(s, 1, "", 0, result);
        return result;
    }

    private void restoreIpAddress(String s, int segment,String solution,int index, List<String> result)
    {
        if (segment == 4)
        {
            if (solution.length() > 0)
            {
                String substring = s.substring(index, s.length());
                if (isValid(substring))
                {

                    result.add(new String(solution+"."+substring));
                }
            }

            return;
        }

        for (int i = index; i<s.length() && i-index <3; i++)
        {
            String substring = s.substring(index, i+1);
            if(isValid(substring)){
                restoreIpAddress(s,segment+1,solution == ""? substring:solution+"."+substring,i+1,result);

            }
        }
    }*/
    //restore ip

    public List<String> resotreIPAddresses(String s) {
        List<String> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        for (int i = 1; i <= 3 && i <= s.length() - 3; i++) {
            for (int j = i + 1; j <= i + 3 && j <=s.length() - 2; j++) {
                for (int k = j + 1; k <= j + 3 && k <= s.length(); k++) {
                    String s1 = s.substring(0, i);
                    String s2 = s.substring(i, j);
                    String s3 = s.substring(j, k);
                    String s4 = s.substring(k, s.length());

                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        result.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return result;
    }


    private boolean isValid(String s){
        if(s.length()<=0 || s.length()>3 || s.length()>1 && s.charAt(0) == '0' ||
                Integer.valueOf(s)>255){
            return false;
        }else{
            return  true;
        }
    }
}
