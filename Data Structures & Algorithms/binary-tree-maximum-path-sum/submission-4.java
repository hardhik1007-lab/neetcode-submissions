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
    public int maxPathSum(TreeNode root) {

        int[] max = new int[]{Integer.MIN_VALUE};
        dfs(root, max);
        return max[0];
        
    }

    public int dfs(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left, max);
        int right = dfs(root.right, max);
        int res= root.val;

        if(left > 0){
            res += left;
        }
        if(right > 0){
            res += right;
        }

        
        max[0]= Math.max(res, max[0]);
        

        return root.val + Math.max(0, Math.max(left, right));


    }
}
