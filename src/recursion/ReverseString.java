package recursion;

public class ReverseString {

    public void reverseString(char[] s) {
        reverseString(s, 0, s.length - 1);
    }
    public void reverseString(char[] s, int left, int right){
        if(left >= right){
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        left++;
        right--;
        reverseString(s, left, right);
    }

}
