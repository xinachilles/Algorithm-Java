import java.util.*;

public class ValidSquare {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4){
        if(equals(p1,p2) || equals(p1,p3)|| equals(p1,p4) || equals(p2,p3) || equals(p2,p4)|| equals(p3,p4)){
            System.out.println("equals");
            return false;
        }

        List<Integer> dist = new ArrayList<>();
        dist.add(distance(p1,p2));
        dist.add(distance(p1,p3));
        dist.add(distance(p1,p4));
        dist.add(distance(p2,p3));
        dist.add(distance(p2,p4));
        dist.add(distance(p3,p4));

        Collections.sort(dist);


        System.out.println(dist.get(0));
        System.out.println(dist.get(1));
        System.out.println(dist.get(1) - dist.get(2));


        // it will return fase since it will check the reference equality
      //  if(dist.get(0) == dist.get(1) && dist.get(1)== dist.get(2) && dist.get(2)==dist.get(3) && dist.get(4)== dist.get(5)){
        if(dist.get(0).equals(dist.get(1)) && dist.get(1).equals(dist.get(2)) && dist.get(2).equals(dist.get(3)) && dist.get(4).equals(dist.get(5))){
            return true;
        }else{

            return false;
        }
    }
    private int distance(int[] a, int[] b) {

        return  (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
    private boolean equals(int[] a, int[] b){
        return a[0] == b[0] && a[1] == b[1];
    }
}
