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
    public boolean isBalanced(TreeNode root) {

        
        return dfs(root)[1] == 0;

    }

    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int height = 1 + Math.max(left[0], right[0]);

        boolean bal = (left[1] == 0 && right[1] == 0) && (Math.abs(left[0] - right[0]) <= 1);

        int b = 1;
        if(bal){
            b = 0;
        }

        return new int[]{height,b};

    }
}
