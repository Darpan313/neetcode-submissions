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
    Map<TreeNode, Integer> robResult = new HashMap<>();
    Map<TreeNode, Integer> notRobResult = new HashMap<>();
    public int rob(TreeNode root) {
        return rob(root, false);
    }

    public int rob(TreeNode root, boolean isParentRobbed) {
        if(root == null) {
            return 0;
        }

        if(isParentRobbed) {
            if(robResult.containsKey(root)) {
                return robResult.get(root);
            }
            int result = rob(root.right, false) + rob(root.left, false);
            robResult.put(root, result);
            return result;
        }
        else {
            if(notRobResult.containsKey(root)) {
                return notRobResult.get(root);
            }
            int result = Math.max(root.val + rob(root.left, true)+rob(root.right, true), rob(root.left, false)+rob(root.right, false));
            notRobResult.put(root, result);
            return result;
        }
    }
}