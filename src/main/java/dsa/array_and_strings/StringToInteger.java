package dsa.array_and_strings;

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println(myAtoi("   -042"));
    }

    public static int myAtoi(String s) {
        long ans = 0;
        int index = 0;
        s = s.trim();
        boolean isNegative = false;
        // to handle sign cases
        if (index < s.length()) {
            if (s.charAt(index) == '-') {
                isNegative = true;
                ++index;
            } else if (s.charAt(index) == '+'){
                ++index;
            }

        }

        while(index < s.length()){
            char c = s.charAt(index++);
            int asciiCode = c - '0';
            if(asciiCode < 0 || asciiCode > 9){
                break;
            }
            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < ans || Integer.MAX_VALUE/10 == ans && Integer.MAX_VALUE %10 < asciiCode){
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = ans * 10 + (int)asciiCode;
        }
        return isNegative ? (int)-ans : (int)ans;
    }
}
