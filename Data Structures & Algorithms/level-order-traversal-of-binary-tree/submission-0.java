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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode curr = p.getKey();
            int level = p.getValue();

            if(result.size()==level){
                result.add(new ArrayList<>());
            }
            result.get(level).add(curr.val);

            if(curr.left!=null) {
                queue.offer(new Pair<>(curr.left, level+1));
            }
            if(curr.right!=null) {
                queue.offer(new Pair<>(curr.right, level+1));
            }
        }
        return result;
    }
}
