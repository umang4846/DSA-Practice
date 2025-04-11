package main.java.dsa.array_and_strings;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11", "10"));
    }

    public static String addBinary(String a, String b) {

        int sum = 0;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {

            int a1 = i>=0 ? Character.getNumericValue(a.charAt(i)) : 0;
            int b1 = j>=0 ? Character.getNumericValue(b.charAt(j)) : 0;

            sum = a1 + b1 + carry;

            if (sum == 2 || sum == 3) {
                carry = 1;
            } else {
                carry = 0;
            }

            if (sum == 1 || sum == 3) {
                result.append("1");
            } else {
                result.append("0");
            }

            i--;
            j--;
        }
        if (carry > 0) {
            result.append("1");
        }

        return result.reverse().toString();

    }

}
