public class PlusOne{
    public static void main(String[] args) {
        int [] arr = {9,9,9};
    }
    public int [] plusOne (int [] digits){
        for(int i = digits.length-1; i>=0; i--){
            if(digits[i]<9){
                digitp[i]++;
                return digits;
            }
            digit[i] = 0;
        }

        //If we reach this stage that means our array was something like 999 or 9999 so, adding 1 becomes 1000 and 10000
        int [] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}