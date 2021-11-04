package kunal_kushwaha_dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class DiceRoll {
    public static void main(String[] args) {
      //  dice("",4);
     //   System.out.println(diceReturn("",4));
      //  diceCustomFace("",7,7);
        System.out.println(diceCustomFaceReturn("",7,7));
    }

    static void dice(String processed, int target) {
        if (target == 0) {
            System.out.println(processed);
            return;
        }

        for (int i = 1; i <= 6 && i <= target; i++) {
            dice(processed + i, target - i);
        }
    }

    static List<String> diceReturn(String processed, int target) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target; i++) {
            ans.addAll(diceReturn(processed + i, target - i));
        }
        return ans;
    }

    static void diceCustomFace(String processed, int target, int face) {
        if (target == 0) {
            System.out.println(processed);
            return;
        }

        for (int i = 1; i <= face && i <= target; i++) {
            diceCustomFace(processed + i, target - i,face);
        }
    }

    static List<String> diceCustomFaceReturn(String processed, int target, int face) {
        if (target == 0) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> ans = new ArrayList<>();
        for (int i = 1; i <= face && i <= target; i++) {
            ans.addAll(diceCustomFaceReturn(processed + i, target - i,face));
        }
        return ans;
    }
}
