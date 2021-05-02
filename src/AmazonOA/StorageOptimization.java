package AmazonOA;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StorageOptimization {
    public static int storageOptimization(int n, int m, List<Integer> h, List<Integer> v) {
        int maxH = 0;
        int maxV = 0;
        int[] h1 = new int[n+1];
        int[] v1 = new int[m+1];
        int tempX = 0, tempY = 0;
        int maxOverLapY =0;
        int maxOverLapX = 0;

        for (int i = 0; i < h.size(); i++) {
           h1[h.get(i)] = 1;
        }
        for (int i = 0; i < v.size(); i++) {
            v1[v.get(i)] = 1;
        }
        for(int i = 0; i < h1.length;i++)
        {
            if(h1[i]==0)
            {
                tempX= 0;
            }
            else
            {
                tempX++;
                maxOverLapX = Math.max(maxOverLapX,tempX);
            }
        }
        for(int i = 0; i < v1.length;i++)
        {
            if(v1[i]==0)
            {
                tempY= 0;
            }
            else
            {
                tempY++;
                maxOverLapY = Math.max(maxOverLapY,tempY);
            }
        }
        return (maxOverLapY + 1) * (maxOverLapX + 1);
    }

}
