package kunal_kushwaha_dsa.recursion;

public class SkipCharacter {

    public static void main(String[] args) {
        skipCharacter("","bcdah");
        System.out.println(skipCharacter2("abcdeaa"));
    }

    public static void skipCharacter(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }

        char ch = unprocessed.charAt(0);
        if (ch == 'a') {
            skipCharacter(processed,unprocessed.substring(1));
        }
        else{
            skipCharacter(processed + ch, unprocessed.substring(1));
        }

    }

    public static String skipCharacter2(String unprocessed){
        if(unprocessed.isEmpty()){
            return "";
        }

        char ch = unprocessed.charAt(0);
        if (ch == 'a') {
           return skipCharacter2(unprocessed.substring(1));
        }
        else{
           return ch + skipCharacter2(unprocessed.substring(1));
        }

    }

}
