package WePay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CurrencyRecognition {
    public static boolean isCurrency(String strAmount) {
        if (strAmount == null || strAmount.length() == 0) {
            return false;
        }
        final char yen = '\uFFE5';
        final char dollar = '\u0024';
        final char euros = '\u20AC';
        System.out.println(strAmount);

        if (strAmount.length() == 0) {
            System.out.println("1");
            return false;
        }

        boolean isYen = false;
        boolean isDollar = false;
        boolean isEuros = false;
        boolean isDot = false;
        boolean isNegative = false;
        boolean isSeperate = false;
        boolean isdigit = false;
        int lastSeperate = 0;
        int numberofSeperate  = 0;
        int digital = 0;

        for (int i = 0; i < strAmount.length(); i++) {
            char current = strAmount.charAt(i);

            if (Character.isDigit(current)) {
                if(current == '0'&& i ==1) {
                    if (strAmount.length() > 2 && strAmount.charAt(i+1)!='.' ) {
                        System.out.println("2");
                        return false;
                    }
                }
                if(isDot == false) {
                    digital++;
                }
                isdigit = true;
            } else if (current == '(') {
                if (strAmount.charAt(strAmount.length() - 1) != ')') {
                    System.out.println("3");
                    return false;
                }
            }else if(current == ')') {
              if(i != strAmount.length()-1) return false;
            }else if (current == '-') {
                    if (i != 0) {
                        System.out.println("4");
                        return false;
                    }
                    isNegative = true;
                } else if (current == yen) {
                    if (isNegative = false && i > 0) {
                        System.out.println("5");
                        return false;
                    }
                    isYen = true;
                } else if (current == dollar) {
                    if (isNegative = false && i > 0) {
                        System.out.println("6");
                        return false;
                    }
                    isDollar = true;
                } else if (current == euros) {
                    if (isNegative = false && i > 0) {
                        System.out.println("7");
                        return false;
                    }
                    isEuros = true;
                } else if (current == ',') {
                    if(isSeperate){
                        if (i-lastSeperate !=4){
                            System.out.println("8");
                            return false;
                        }
                    }else {
                        isSeperate = true;
                    }
                    numberofSeperate++;
                } else if (current == '.') {
                    if (isYen) {
                        System.out.println("9");
                        return false;
                    }
                    if (i != strAmount.length() - 3) {
                        System.out.println("10");
                        return false;
                    }
                    isDot = true;
                } else {
                System.out.println("11");
                    return false;
                }
            }


        if(!isDollar && !isEuros && !isYen){
            System.out.println("12");
            return false;
        }
        if(isSeperate &&( (digital-1)/3 != numberofSeperate)) {
            System.out.println("13");
            return false;
        }
        if(!isdigit){
            System.out.println("14");
            return false;
        }

        return true;
    }


    public static void main(String[] args) {
        final char yen = '\uFFE5';
        final char dollars = '\u0024';
        final char euros = '\u20AC';

        System.out.println(isCurrency("$450"));
        System.out.println(isCurrency("-"+euros+"23"));
        System.out.println(isCurrency("$4,500.00"));
        System.out.println(isCurrency(euros+"0.25"));
       System.out.println(isCurrency("$4,500.00" ));
        System.out.println(isCurrency("cat"));
        System.out.println(isCurrency( "$45,0"));
       System.out.println(isCurrency("("+euros+"350"));
        System.out.println(isCurrency("(-$3.50)"));
        System.out.println(isCurrency(yen+"120.00"));
        System.out.println(isCurrency("$-50"));
        System.out.println(isCurrency(" "+euros+"43.25"));
        System.out.println(isCurrency("$65."));
        System.out.println(isCurrency(euros+"82.1"));
        System.out.println(isCurrency("48.50"));
        System.out.println(isCurrency(yen+"1200,000"));
        System.out.println(isCurrency("$"));
        //System.out.println(euros);
    }
}
