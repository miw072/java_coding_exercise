package sqrt_x;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SqrtX {
    /*
        Sqrt(x) - Binary Search
        Leetcode #69
        https://leetcode.com/problems/sqrtx/
        Difficulty: Medium
     */
    public class Solution {
        public int sqrt(int x) {
            int left = 1, right = x/2;
            if(x<2) return x;
            while (left <= right) {
                int mid = (left + right)/2;
                if (x/mid == mid) return mid;
                if (x/mid > mid) left = mid + 1;
                else right = mid - 1;
            }
            return right;
        }
    }

    /*
        Sqrt(x) - Newton's method
        Leetcode #69
        https://leetcode.com/problems/sqrtx/
        Difficulty: Medium
     */
    public class SolutionII {
        public int sqrt(int x) {
            double a = 1.0;
            while (Math.abs(a * a - x) > 10E-6) {
                a = (a + x / a) / 2;
            }
            return (int) a;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new SqrtX().new Solution();
            assertEquals(5, 5);
        }
    }
}
