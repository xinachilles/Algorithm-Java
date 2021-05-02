public class StringShift {
    public String stringShift(String s, int[][] shift) {
        if(s == null || s.length() == 0){
            return null;
        }

        int totalShift = 0;
        for(int i = 0; i<shift.length;i++){
            if(shift[i][0] == 0){
                totalShift += shift[i][1];
            }else{
                totalShift -=shift[i][1];
            }
        }

        totalShift = totalShift % s.length();

        if(totalShift<0) totalShift = s.length()+totalShift;

        return s.substring(totalShift+1,s.length())+ s.substring(0,totalShift);


    }
}
