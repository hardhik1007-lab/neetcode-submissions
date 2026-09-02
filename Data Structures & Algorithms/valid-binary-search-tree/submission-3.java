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
    public boolean isValidBST(TreeNode root) {

        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }

    public boolean dfs(TreeNode root, long l, long r){
        if(root == null){
            return true;
        }

        if(dfs(root.left, l, root.val) && dfs(root.right, root.val, r) && l < root.val && root.val < r){
            return true;
        }

        return false;
    }
}
