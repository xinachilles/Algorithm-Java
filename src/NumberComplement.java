public class NumberComplement {
    public int findComplement(int num) {
        int result = 0;
        int bit  =1;
        for(int i = 0; i<32;i++){
            result |= ~(num & bit);
            bit  = bit <<1;

        }
        return result;
    }
}
