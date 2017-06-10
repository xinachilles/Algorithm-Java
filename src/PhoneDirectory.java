/**
 * Created by xhu on 3/18/17.
 */
public class PhoneDirectory {
    boolean[] phoneBook;

    public PhoneDirectory(int maxNumbers) {
        phoneBook = new boolean[maxNumbers];
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        for(int i = 0;i<phoneBook.length;i++){
            if(phoneBook[i]){
                return i;
            }
        }

        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(number>=phoneBook.length){
            return false;
        }

        return phoneBook[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(number>=phoneBook.length){
            return;
        }

        phoneBook[number] = true;
    }

}
