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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        int maxDepth = 0;

        queue.offer(root);

        while(!queue.isEmpty()){
            maxDepth++;
            LinkedList<TreeNode> nextChildren = new LinkedList<>();
            TreeNode next;
            while((next = queue.poll()) != null) {
                if(next.left != null) {
                    nextChildren.offer(next.left);
                }
                if(next.right != null) {
                    nextChildren.offer(next.right);
                }
            }
            queue.addAll(nextChildren);
        }

        return maxDepth;
    }
}
