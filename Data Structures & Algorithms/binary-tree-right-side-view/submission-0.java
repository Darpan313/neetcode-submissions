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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int prevLevel = 0;
        int currLevel = 0;
        if(root!=null) {
            queue.offer(new Pair<>(root, prevLevel+1));
        }
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            currLevel = p.getValue();

            if(currLevel!=prevLevel){
                res.add(node.val);
            }
            if(node.right!=null) {
                queue.offer(new Pair<>(node.right, currLevel+1));
            }
            if(node.left!=null) {
                queue.offer(new Pair<>(node.left, currLevel+1));
            }
            prevLevel = currLevel;
        }
        return res;
    }
}
