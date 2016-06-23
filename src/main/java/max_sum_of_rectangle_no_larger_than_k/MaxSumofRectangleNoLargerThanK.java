package max_sum_of_rectangle_no_larger_than_k;

import org.junit.Test;

import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class MaxSumofRectangleNoLargerThanK {
  /*
      Max Sum of Rectangle No Larger Than K
      Leetcode #363
      https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/
      Difficulty: Hard
   */
  public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
      if (matrix.length == 0) return 0;

      int m = matrix.length, n = matrix[0].length;
      int maxSum = Integer.MIN_VALUE;

      //outer loop should use smaller axis
      //now we assume we have more rows than cols, therefore outer loop will be based on cols
      for (int left = 0; left < n; left++) {
        //array that accumulate sums for each row from left to right
        int[] sums = new int[m];
        for (int right = left; right < n; right++) {
          //update sums[] to include values in curr right col
          for (int i = 0; i < m; i++) {
            sums[i] += matrix[i][right];
          }

          //we use TreeSet to help us find the rectangle with maxSum <= k with O(logN) time
          TreeSet<Integer> set = new TreeSet<Integer>();
          //add 0 to cover the single row case
          set.add(0);
          int currSum = 0;

          for (int sum : sums) {
            currSum += sum;
            //we use sum subtraction (curSum - sum) to get the subarray with sum <= k
            //therefore we need to look for the smallest sum >= currSum - k
            Integer num = set.ceiling(currSum - k);
            if (num != null) maxSum = Math.max(maxSum, currSum - num);
            set.add(currSum);
          }
        }
      }

      return maxSum;
    }
  }

  public static class UnitTest {
    @Test
    public void test1() {
      Solution sol = new MaxSumofRectangleNoLargerThanK().new Solution();
      int[][] matrix = {
              {1, 0, 1},
              {0, -2, 3}
      };
      assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
      matrix = new int [][]{
              {1, 2, -1, -4, -20},
              {-8, -3, 4, 2, 1},
              {3, 8, 10, 1, 3},
              {-4, -1, 1, 7, -6}
      };
      assertEquals(2, sol.maxSumSubmatrix(matrix, 2));
      assertEquals(8, sol.maxSumSubmatrix(matrix, 9));
    }
  }
}

