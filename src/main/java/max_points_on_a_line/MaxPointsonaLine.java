package max_points_on_a_line;

import org.junit.Test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MaxPointsonaLine {
    /*
        Max Points on a Line
        https://leetcode.com/problems/max-points-on-a-line/
        Difficulty: Hard
     */
    public class Solution {
        public int maxPoints(Point[] points) {
            int rslt = 0;
            int N = points.length;
            for (int i = 0; i < N; ++i) {
                HashMap<Double, Integer> m = new HashMap<Double, Integer>();
                int ss = 1, sp = 0;
                for (int j = i + 1; j < N; ++j) {
                    double slope = Double.MIN_VALUE;
                    if (points[i].x != points[j].x) {
                        slope = (double) (points[i].y - points[j].y) / (points[i].x - points[j].x);
                        if (slope == -0.0) slope = 0.0;
                    } else if (points[i].y == points[j].y) {
                        sp += 1;
                        continue;
                    }
                    int tmp = 2;
                    if (m.containsKey(slope)) {
                        tmp = m.get(slope) + 1;
                    }
                    m.put(slope, tmp);
                    ss = Math.max(ss, tmp);
                }
                rslt = Math.max(rslt, ss + sp);
            }
            return rslt;
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Solution sol = new MaxPointsonaLine().new Solution();
            assertEquals(5, 5);
        }
    }
}
