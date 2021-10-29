package recursion;

/*
* Remove the spring from given string
* e.g string = dcapplefg
* answer = dcfg
*
* .
* */
public class SkipString {

    public static void main(String[] args) {
        System.out.println(skipString2("bcdappleef"));
    }

    public static String skipString2(String unprocessed){
        if(unprocessed.isEmpty()){
            return "";
        }
        //skipping apple here
        if (unprocessed.startsWith("apple")) {
            return skipString2(unprocessed.substring(5));
        }
        else{
            return unprocessed.charAt(0) + skipString2(unprocessed.substring(1));
        }

    }


}
