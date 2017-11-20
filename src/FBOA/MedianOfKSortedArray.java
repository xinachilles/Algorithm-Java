package FBOA;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Number {
    double value;
    int row;
    int column;

    public Number(double value, int row, int column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }
}

public class MedianOfKSortedArray {

    public double findMedian(List<double[]> input) {
        PriorityQueue<Number> minHeap = new PriorityQueue<>(input.size(), new Comparator<Number>() {
            @Override
            public int compare(Number num1, Number num2) {
                if (num1.value > num2.value) {
                    return 1;
                }
                return -1;
            }
        });
        int total = 0;
        for (int i = 0; i < input.size(); i++) {
            minHeap.add(new Number(input.get(i)[0], i, 0));
            total += input.get(i).length;
        }
        double median = 0;
        double previous = 0;
        int count = 0;
        while (count <= total / 2) {
            Number min = minHeap.poll();
            count++;
            previous = median;
            median = min.value;

            if (min.column < input.get(min.row).length - 1) {
                minHeap.add(new Number(input.get(min.row)[min.column + 1], min.row, min.column + 1));

            }
        }
        if (total % 2 == 0) {
            return (previous + median) / 2.0;
        }
        return median;
    }


}
