package dsa.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class OpentheLock {

    public int openLock(String[] deadends, String target) {
        int[][] dp = new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1},
                {-1, 0, 0, 0}, {0, -1, 0, 0}, {0, 0, -1, 0}, {0, 0, 0, -1}};

        int level = 0;
        HashSet<String> deads = new HashSet<>();
        for (String d : deadends) {
            deads.add(d);
        }
        Queue<String> toVisit = new LinkedList<>();
        toVisit.offer("0000");

        while (!toVisit.isEmpty()) {
            int size = toVisit.size();
            for (int i = 0; i < size; i++) {
                String curr = toVisit.poll();
                if (deads.contains(curr)) {
                    continue;
                }
                if (curr.equals(target)) {
                    return level;
                }
                deads.add(curr);
                for (int j = 0; j < dp.length; j++) {
                    int[] canPos = new int[]{curr.charAt(0) - '0', curr.charAt(1) - '0', curr.charAt(2) - '0', curr.charAt(3) - '0'};
                    for (int k = 0; k < 4; k++) {
                        canPos[k] += dp[j][k];
                        canPos[k] = canPos[k] > 9 ? 0 : canPos[k];
                        canPos[k] = canPos[k] < 0 ? 9 : canPos[k];
                    }
                    String cand = "" + canPos[0] + canPos[1] + canPos[2] + canPos[3];
                    if (!deads.contains(cand)) {
                        toVisit.add(cand);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
