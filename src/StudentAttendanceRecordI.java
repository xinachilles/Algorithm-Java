public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        if(s == null) return false;
        int numberofAbsent = 0;
        int numberofLater =0;
        int maxLater = 0;
        for(char a: s.toCharArray()){
            if(a =='L'){
                numberofLater++;
            }else if(a =='A'){
                numberofAbsent++;
                maxLater = Math.max(maxLater,numberofLater);
                numberofLater = 0;
            }else{
                maxLater = Math.max(maxLater,numberofLater);
                numberofLater = 0;
            }

        }
        return maxLater<3 && numberofAbsent<2;
    }
}
