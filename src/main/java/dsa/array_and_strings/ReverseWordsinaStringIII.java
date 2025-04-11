package dsa.array_and_strings;

public class ReverseWordsinaStringIII {

    public static void main(String[] args){
        System.out.println(reverseWords("the sky is blue"));
    }

    public static String reverseWords(String s) {

        int i = 0;
        int j = 0;
        char[] arr = s.toCharArray();

        while(i <= arr.length){
            if(i == arr.length || arr[i] == ' '){
                reverse(arr, j, i-1);
                j = i + 1;
            }
            i++;
        }

        return new String(arr);
    }

    public static void reverse(char[] arr, int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


}
