import java.util.TreeSet;

class ExamRoom {

    int numberOfSeet;
    boolean[] seats;

    public ExamRoom(int N) {
        numberOfSeet = N;
        seats = new boolean[N];
    }

    public int seat() {
        int student = 0;
        Integer previous = null;
        int distance = 0;

        for(int i = 0; i<numberOfSeet;i++){
            if(seats[i]){
                if (previous != null) {
                    int d = (i - previous) / 2;
                    if (d > distance) {
                        distance = d;
                        student = d + previous;
                    }
                }
            }
            previous = i;
        }
        //Considering the right-most seat
        if (previous  != null &&  (numberOfSeet - 1 - previous > distance)) {
            student = numberOfSeet - 1;
        }

        seats[student] = true;
        return student;


    }

    public void leave(int p) {
        seats[p] = false;
    }
}
