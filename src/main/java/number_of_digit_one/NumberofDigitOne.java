package number_of_digit_one;

public class NumberofDigitOne {
    /*
        Number of Digital One
        https://leetcode.com/problems/number-of-digit-one/
        Difficulty: Medium
     */
    public class Solution {
        public int countDigitOne(int n) {
            int ones = 0;
            for (long m = 1; m <= n; m *= 10) {
                long a = n / m, b = n % m;
                ones += (a + 8) / 10 * m;
                if (a % 10 == 1) ones += b + 1;
            }
            return ones;
        }
    }

    public static class UnitTest {

    }
}
