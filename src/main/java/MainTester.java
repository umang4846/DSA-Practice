import java.util.*;
import java.util.stream.Collectors;

public class MainTester {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(60, 2);
        map.put(70, 3);
        map.put(80, 4);
        map.put(90, 5);
        map.put(100, 7);

        Map<Integer, Integer> integerIntegerHashMap = sortMap(map);
        System.out.println(integerIntegerHashMap);
    }

    public static Map<Integer, Integer> sortMap(HashMap<Integer, Integer> map) {
        map.entrySet().stream().sorted();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for (Integer key : map.keySet()) {
            map1.put(map.get(key), key);
        }
        List<Integer> list = map.values().stream().sorted().toList();
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        for (int i = 0; i < list.size(); i++) {
            linkedHashMap.put(map1.get(list.get(i)), list.get(i));
        }
        return linkedHashMap;
    }

}
