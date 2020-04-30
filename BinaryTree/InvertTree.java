/**
 Invert the given binary tree. Leetcode - 226.
Input :    4
         /   \
        2     7
       / \   / \
      1   3 6   9

Output :   4
         /   \
        7     2
       / \   / \
      9   6 3   1

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import BinaryTree.*;
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        } 
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}