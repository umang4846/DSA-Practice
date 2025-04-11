public class DryRun {
    public static void main(String[] args) {
      /*  String s = "the sky is blue";
        String[] words = s.trim().split(" +");
        Collections.reverse(Arrays.asList(words));
        System.out.println(String.join(" ", words));*/
        //printBothWay(5);
       // digitSum1(500);
        //System.out.println(sum);
      //  System.out.println(countZeros(1111,0));
      //  printTriangle(4,0);

        // Input string to be traversed
        String S = "AABAACAADAABAABA";

        // Pattern string to be checked
        String pattern = "AABA";

        // Calling the above search() method(Method1)
        // in the main() method
        search(S, pattern);
    }


    public static void printBothWay(int n){
        if(n == 0){
            return;
        }
        System.out.println(n);
        printBothWay(n-1);
        System.out.println(n);
    }


    static int sum = 0;
    static void digitSum1(int n){
        if(n == 0){
            return;
        }
        int remainder = n % 10;
        sum = sum * 10 + remainder;
        digitSum1(n/10);
    }

    static int countZeros(int n, int c){
        if(n == 0){
            return c;
        }
        int rem = n % 10;
        if(rem == 0){
            return countZeros(n/10, ++c);
        }
        return countZeros(n/10, c);
    }

    public static void printTriangle(int row, int col){
        if(row == 0){
            return;
        }

        if(col < row){
            System.out.print("*");
            printTriangle(row, col+1);
        }else{
            System.out.println();
            printTriangle(row-1, 0);
        }
    }

    // Method 1
    // To search the pattern
    static void search(String S, String pattern)
    {
        // Declaring and initializing the hash values
        int hash1 = 0;
        int hash2 = 0;

        // Iterating over the pattern string to be matched
        // over
        for (int i = 0; i < pattern.length(); ++i) {

            // Storing the hash value of the pattern
            hash1 += pattern.charAt(i) - 'A';

            // Storing First hash value of the string
            hash2 += S.charAt(i) - 'A';
        }

        // Initially declaring with zero
        int j = 0;

        // Iterating over the pattern string to checkout
        // hash values
        for (int i = 0; i <= S.length() - pattern.length(); ++i) {

            // Checking the hash value
            if (hash2 == hash1) {

                // Checking the value
                for (j = 0; j < pattern.length(); ++j) {

                    // Checking for detection of pattern in a
                    // pattern
                    if (pattern.charAt(j)
                            != S.charAt(i + j)) {

                        // Break statement to hault the
                        // execution of program as no
                        // pattern found
                        break;
                    }
                }
            }

            // If execution is not stopped means
            // pattern(sub-string) is present

            // So now simply detecting for one or more
            // occurrences inbetween pattern string using the
            // length() method
            if (j == pattern.length()) {

                // Pattern is detected so printing the index
                System.out.println(i);
            }
            // for last case of loop, have to check,
            // otherwise,
            // S.charAt(i + pattern.length()) below will
            // throw error
            if (i == S.length() - pattern.length())
                break;

            // Roll the hash value over the string detected
            hash2 = (int)((hash2) - (S.charAt(i) - 'A')) + S.charAt(i + pattern.length()) - 'A';
        }
    }

}
