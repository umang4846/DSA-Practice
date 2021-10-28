package binary_search_tree;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indDiff, int valDiff) {
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            Long floor = set.floor((long) nums[i]); // Largest Number less then the num.
            Long ceiling = set.ceiling((long) nums[i]); // Smallest Number greater than num.

            if (floor != null && (long) nums[i] - floor <= valDiff) return true;
            if (ceiling != null && ceiling - (long) nums[i] <= valDiff) return true;

            set.add((long)nums[i]);
            if(set.size()>indDiff) set.remove((long)nums[i-indDiff]);
        }
        return false;
    }
}
