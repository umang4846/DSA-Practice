package dsa.two_pointer;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        int[] height = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
        System.out.println(trappingRainWater.trap(height)); // Output: 9
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0;
        int r = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (l < r) {
            if (height[l] < height[r]) {
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
                l++;
            } else {
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
                r--;
            }
        }
        return res;
    }
}

