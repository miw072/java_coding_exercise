package invert_binary_tree;

import java.util.*;
import common.TreeNode;

public class InvertBinaryTree {
    /*
        Invert Binary Tree
        https://leetcode.com/problems/invert-binary-tree/
        Difficulty: Easy
     */
    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }

            TreeNode temp = root.left;

            root.left = invertTree(root.right);
            root.right = invertTree(temp);

            return root;
        }
    }

    public static class UnitTest {

    }
}
