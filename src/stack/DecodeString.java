package stack;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                //32[a]
                num = num * 10 + c - '0';
            } else if (c == '[') {

                strStack.push(result);
                result = new StringBuilder();

                numStack.push(num);
                num = 0;
            } else if (c == ']') {
                StringBuilder temp = result;
                result = strStack.pop();
                int count = numStack.pop();

                while (count > 0) {
                    result.append(temp);
                    count--;
                }
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }


}
