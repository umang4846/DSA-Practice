package dsa.striver_150_dsa_sheet.stack_and_queue;

public class FindTheCelebrity {
    public class Solution extends Relation {
        public int findCelebrity(int n) {
            int suspectedCelebrity = 0;
            for (int i = 1; i < n; i++) {
                if (knows(suspectedCelebrity, i)) {
                    suspectedCelebrity = i;
                }
            }
            for (int i = 0; i < n; i++) {
                if (i != suspectedCelebrity && (knows(suspectedCelebrity, i) || !knows(i, suspectedCelebrity))) {
                    return -1;
                }
            }
            return suspectedCelebrity;
        }
    }

    class Relation {
        int MATRIX[][] = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};
        /* The knows API is defined in the parent class Relation.*/
        boolean knows(int a, int b) {
            boolean res = (MATRIX[a][b] == 1) ? true : false;
            return res;
        }
    }
}
