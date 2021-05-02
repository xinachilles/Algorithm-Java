package AmazonOA;

import java.util.List;

public class UtilizationChecks {
    private static final int LIMIT = 2 * 100_000_000;
    public static int finalInstances(int instances, List<Integer> averageUtil) {
        for (int i = 0; i < averageUtil.size(); i++) {
            int util = averageUtil.get(i);
            if (util < 25) {
                if (instances > 1) {
                    instances = instances / 2 + ((instances % 2 == 0) ? 0 : 1);
                    i += 10;
                }
            } else if (util > 60) {
                int tmp = 2 * instances;
                if (tmp <= LIMIT) {
                    instances = tmp;
                    i += 10;
                }
            }
        }
        return instances;
    }

    public static int finalInstance(int instance, List<Integer> averageUtil){
        if(averageUtil.size() == 0 || averageUtil == null || instance == 0) return 0;

        int cursor = 0;
        while(cursor < averageUtil.size()){
            int utilization = averageUtil.get(cursor);
            if(utilization > 60 && instance <= 2e8){
                instance = instance * 2;
                cursor = cursor + 10;
            } else if(utilization < 25 && instance > 1){
                instance = instance / 2;
                cursor = cursor + 10;
            } else{
                cursor = cursor + 1;
                continue;
            }
            cursor = cursor + 1;
        }
        System.out.println(instance);
        return instance;
    }

}
