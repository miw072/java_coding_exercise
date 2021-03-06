package patching_array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PatchingArray {
    /*
        Patching Array
        Leetcode #330
        https://leetcode.com/problems/patching-array/
        Difficulty: Medium
    */
    public class Solution {
        public int minPatches(int[] nums, int n) {
            long sum = 0;
            int rslt = 0;
            for (int cur : nums) {
                if (sum >= n) break;
                while (sum + 1 < cur && sum < n) {
                    sum += sum + 1;
                    rslt++;
                }
                sum += cur;
            }
            while (sum < n) {
                sum += sum + 1;
                rslt++;
            }
            return rslt;
        }
    }


    /*
        Patching Array
        Leetcode #330
        https://leetcode.com/problems/patching-array/
        Difficulty: Medium
     */
    public class Solution_2 {
        public int minPatches(int[] nums, int n) {
            long sum = 1;
            int rslt = 0, i = 0;
            while (sum <= n) {
                if (i < nums.length && nums[i] <= sum) {
                    sum += nums[i];
                    i++;
                } else {
                    sum += sum;
                    rslt++;
                }
            }
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new PatchingArray().new Solution();
            assertEquals(1, sol.minPatches(new int[]{1, 3}, 6));
            assertEquals(2, sol.minPatches(new int[]{1, 5, 10}, 20));
            assertEquals(0, sol.minPatches(new int[]{1, 2, 2}, 5));
        }

        @Test
        public void test2() {
            Solution_2 sol = new PatchingArray().new Solution_2();
            assertEquals(1, sol.minPatches(new int[]{1, 3}, 6));
            assertEquals(2, sol.minPatches(new int[]{1, 5, 10}, 20));
            assertEquals(0, sol.minPatches(new int[]{1, 2, 2}, 5));
        }
    }
}

