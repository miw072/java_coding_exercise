package majority_element;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {

    public class Solution {
        public int majorityElement(int[] num) {
            int majority = num[0];
            int count = 1;
            for (int i = 1; i < num.length; i++) {
                if (majority != num[i]) {
                    count--;
                    if (count == 0) {
                        // the majority element always exist in the array
                        majority = num[++i];
                        count = 1;
                    }
                } else {
                    count++;
                }
            }
            return majority;
        }
    }

    // Mjority Element II
    // https://leetcode.com/problems/majority-element-ii/
    // Difficulty: Medium
    public class SolutionII {
        public List<Integer> majorityElement(int[] nums) {
            List<Integer> result = new ArrayList<Integer>();

            Integer n1 = null, n2 = null;
            int c1 = 0, c2 = 0;

            for (int i : nums) {
                if (n1 != null && i == n1.intValue()) {
                    c1++;
                } else if (n2 != null && i == n2.intValue()) {
                    c2++;
                } else if (c1 == 0) {
                    c1 = 1;
                    n1 = i;
                } else if (c2 == 0) {
                    c2 = 1;
                    n2 = i;
                } else {
                    c1--;
                    c2--;
                }
            }

            c1 = c2 = 0;

            for (int i : nums) {
                if (i == n1.intValue()) {
                    c1++;
                } else if (i == n2.intValue()) {
                    c2++;
                }
            }

            if (c1 > nums.length / 3)
                result.add(n1);
            if (c2 > nums.length / 3)
                result.add(n2);

            return result;
        }
    }

    public static class UnitTest {

    }
}

