package _3sum_smaller;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class _3SumSmaller {
    /*
        3 Sum Smaller
        http://buttercola.blogspot.com/2015/08/leetcode.html
        Difficulty: Medium
     */
    public class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            if (nums == null || nums.length < 3) {
                return 0;
            }

            int result = 0;
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 2; i++) {
                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    if (nums[i] + nums[j] + nums[k] < target) {
                        result += (k - j);
                        j++;
                    } else {
                        k--;
                    }
                }
            }

            return result;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new _3SumSmaller().new Solution();
            assertTrue(true);
        }
    }
}
