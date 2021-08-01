import java.util.Arrays;

public class CarFeetII {
    public double[] getCollisionTimes(int[][] cars) {
        double[] result = new double[cars.length];
        Arrays.fill(result,-1.0);
        for(int i = 0; i<cars.length-1; i++){
            double min = Double.MAX_VALUE;

            for(int j = i+1; j<cars.length;j++){
                if(cars[i][1]>cars[j][1]){
                    min= Math.min((double)(cars[i][1]-cars[j][1])/(cars[j][0]-cars[i][0]),min);
                }
                if(min != Double.MAX_VALUE) result[i] = min;
            }
        }
        return result;
    }
}
