import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    List<Integer> array;
    public ProductOfNumbers() {
        array = new ArrayList<>();
        array.add(1);
    }

    public void add(int num) {
        if(num == 0){
            array = new ArrayList<>();
            array.add(1);
        }else{
            array.add(array.get(array.size()-1)*num);

        }
    }

    public int getProduct(int k) {
        if(k < array.size()){
            return array.get(k-1)/array.get(array.size()-1-k);
        }else{
            return 0;
        }
    }
}
