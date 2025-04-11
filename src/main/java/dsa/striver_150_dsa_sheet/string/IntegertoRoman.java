package dsa.striver_150_dsa_sheet.string;

public class IntegertoRoman {

    //Approach  1
    public String intToRoman1(int num) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        /*
         * Notes :  Example -> 2459
         * num/1000 = 2459/1000 = 2 -> give 1000th place value (here 2)
         * (num%1000)/100 = (2459%1000)/100 = 459/100 = 4 -> give 100th place value (here 4)
         * (num%100)/10 = (2459%100)/10 = 59/10 = 5 -> give 10th place value (here 5)
         * num%10 = 2459%10 = 9 -> give unit place value (here 9)
         * */
        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    //Approach 2
    public String intToRoman2(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strValue = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; num > 0 && i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(strValue[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegertoRoman integertoRoman = new IntegertoRoman();
        // System.out.println(integertoRoman.intToRoman1(10));
        System.out.println(integertoRoman.intToRoman2(10));


    }
}
