package stack;

import java.util.List;
import java.util.Stack;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        Stack<Integer> keys = new Stack<>();
        keys.push(0);

        while(!keys.isEmpty()){
            int curr = keys.pop();
            for(int i : rooms.get(curr)){
                if(!visited[i]){
                    visited[i] = true;
                    keys.add(i);
                }
            }
        }

        for(int i = 0; i<visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return false;

    }

}
