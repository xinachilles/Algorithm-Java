/**
 * Created by xhu on 12/14/16.
 */
public class PaintHouse {

    // paint house


    public int minCost(int[][] costs) {
        if (costs == null) {
            return 0;
        }

        int minCost = 0;
        int secondMinCost = 0;
        int minColor = -1;


        int houses = costs.length;
        int colors = costs[0].length;


        for (int i = 0; i < houses; i++) {
            int tempMin = Integer.MAX_VALUE;
            int tempSecond = Integer.MAX_VALUE;
            int tempColor = -1;
            int temp = 0;

            for (int j = 0; j < colors; j++) {

                if (j != minColor) {
                    temp = costs[i][j] + minCost;
                } else {
                    temp = costs[i][j] + secondMinCost;
                }


                if (tempMin >temp) {
                    tempSecond = tempMin;
                    tempMin = temp;
                    tempColor = j;
                } else if ( tempSecond>temp) {
                    tempSecond = temp;
                }
            }

            minCost = tempMin;
            secondMinCost = tempSecond;
            minColor = tempColor;
        }

        return minCost;

    }


}
