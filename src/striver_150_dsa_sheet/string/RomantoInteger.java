package striver_150_dsa_sheet.string;

import java.util.HashMap;

public class RomantoInteger {

    int getValue(char c){
        if(c=='I') return 1;
        else if(c=='V') return 5;
        else if(c=='X') return 10;
        else if(c=='L') return 50;
        else if(c=='C') return 100;
        else if(c=='D') return 500;
        else return 1000;
    }
    //Approach 1
    public int romanToInt1(String s) {
        int result = 0;
        for(int i=0;i<s.length() - 1;i++){
            int a = getValue(s.charAt(i));
            int b = getValue(s.charAt(i+1));
            if(a<b){
                result-=a;
            }else{
                result+=a;
            }
        }
        result += getValue(s.charAt(s.length()-1));
        return result;
    }

    //Approach 2
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        for(int i = 0; i<s.length() - 1;i++){
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))){
                result = result - map.get(s.charAt(i));
            }else{
                result  = result + map.get(s.charAt(i));
            }
        }
        result = result + map.get(s.charAt(s.length() - 1));
        return result;
    }
}
