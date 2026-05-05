/**
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

class Solution {
    public int goodNodes(TreeNode root) {
        return count(root, root.val);
    }

    public int count(TreeNode node, int maxVal) {
        if(node == null) {
            return 0;
        }
        int res = (node.val>=maxVal) ? 1:0;
        maxVal = Math.max(node.val, maxVal);
        res+=count(node.left, maxVal);
        res+=count(node.right, maxVal);
        return res;
    }
}
