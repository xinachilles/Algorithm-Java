package AmazonOA;

public class RobotBoundedCircle {
    public boolean isRobotBounded(String instructions) {
        int[][]moves = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        int r = 0;
        int c = 0;
        int d = 0;
        for(char g: instructions.toCharArray()){
            if(g == 'G'){
                r += moves[d][0];
                c+=moves[d][1];
            }else if(g =='L'){
                d =(d +3)%4; // trun left
            }else if(g == 'R'){
                d = (d+1)%4; // turn right
            }

        }
        return(r==0 && c == 0 || d>0);
    }
}
