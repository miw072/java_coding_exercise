package flatten_2d_vector;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Flatten2DVector {
    /*
        Flatten 2D Vector
        Leetcode #251
        https://leetcode.com/discuss/questions/oj/flatten-2d-vector
        http://buttercola.blogspot.com/2015/08/leetcode-flatten-2d-vector.html
        Difficulty: Medium
     */
    public class Vector2D {
        private List<List<Integer>> vec2d;
        private int rowId;
        private int colId;
        private int numRows;

        public Vector2D(List<List<Integer>> vec2d) {
            this.vec2d = vec2d;
            rowId = 0;
            colId = 0;
            numRows = vec2d.size();
        }

        public int next() {
            int ans = 0;

            if (colId < vec2d.get(rowId).size()) {
                ans = vec2d.get(rowId).get(colId);
            }

            colId++;

            if (colId == vec2d.get(rowId).size()) {
                colId = 0;
                rowId++;
            }

            return ans;
        }

        public boolean hasNext() {
            while (rowId < numRows && (vec2d.get(rowId) == null || vec2d.get(rowId).isEmpty())) {
                rowId++;
            }

            return vec2d != null &&
                    !vec2d.isEmpty() &&
                    rowId < numRows;
        }
    }

    /*
        Flatten 2D Vector in Java iterators
        http://buttercola.blogspot.com/2015/08/leetcode-flatten-2d-vector.html
        Difficulty: Medium
     */
    public class Vector2DII {
        private Iterator<List<Integer>> outerIterator;
        private Iterator<Integer> innerIterator;

        public Vector2DII(List<List<Integer>> vec2d) {
            outerIterator = vec2d.iterator();


            innerIterator = Collections.emptyIterator();
        }

        public int next() {
            return innerIterator.next();
        }

        public boolean hasNext() {
            if (innerIterator.hasNext()) {
                return true;
            }

            if (!outerIterator.hasNext()) {
                return false;
            }

            innerIterator = outerIterator.next().iterator();


            return hasNext();
        }
    }

    public static class UnitTest {
        @Test
        public void test1() {
            Vector2D sol = new Flatten2DVector().new Vector2D(new ArrayList<List<Integer>>());
            assertTrue(true);
        }
    }
}
