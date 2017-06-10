/**
 * Created by xhu on 3/11/17.
 */
public class RectangleOverlap {

    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // Write your code here


        for(int i = l1.x;i<=r1.x;i++){
            for(int j = l1.y;j<=r1.y;j--){
                if(i>=l2.x && i<=r2.x && j>=r2.y && j<=l2.y){
                    return true;
                }
            }
        }

        return false;
    }
}
