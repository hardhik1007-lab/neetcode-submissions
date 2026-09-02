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
        return maxDepthhelper(root);
        
    }

    public int maxDepthhelper(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(maxDepthhelper(node.left)+1,maxDepthhelper(node.right)+1);
    }
}
