package trapping_rain_water;

public class TrappingRainWater {

    public class Solution {
        public int trap(int[] height) {
            if (height.length == 0) {
                return 0;
            }
            int maxIndex = 0;
            for (int i = 1; i < height.length; i++) {
                if (height[i] > height[maxIndex]) {
                    maxIndex = i;
                }
            }
            int cHeight = height[0];
            int water = 0;
            for (int i = 1; i < maxIndex; i++) {
                if (height[i] > cHeight) {
                    cHeight = height[i];
                } else {
                    water += cHeight - height[i];
                }
            }
            cHeight = height[height.length - 1];
            for (int i = height.length - 2; i > maxIndex; i--) {
                if (height[i] > cHeight) {
                    cHeight = height[i];
                } else {
                    water += cHeight - height[i];
                }
            }
            return water;
        }
    }

    public static class UnitTest {

    }
}
