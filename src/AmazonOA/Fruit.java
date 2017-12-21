package AmazonOA;

import java.util.List;

public class Fruit {

    public int fruit(List<List<String>> codeList, List<String> shopingCart) {
        if (codeList == null || shopingCart == null) {

            return 0;

        }

        int totalCount = 0;

        for (List<String> c : codeList) {

            totalCount += c.size();

        }


        for (int i = 0; i < shopingCart.size(); i++) {

            int j = i;

            int tempCount = 0;


            for (int m = 0; m < codeList.size() && j < shopingCart.size(); m++) {

                for (int n = 0; n < codeList.get(m).size() && j < shopingCart.size(); n++) {

                    if (!codeList.get(m).get(n).equals(shopingCart.get(j)) && !codeList.get(m).get(n).toLowerCase().equals("anything")) {

                        break;
                    }


                    j++;

                    tempCount++;


                }

            }


            if (tempCount == totalCount)

            {

                return 1;

            }


        }

        return 0;


    }


}
