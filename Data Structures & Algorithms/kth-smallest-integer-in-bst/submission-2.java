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
    public int kthSmallest(TreeNode root, int k) {

        int[] res = new int[1];
        int[] ans = new int[1];
        dfs(root, k, ans, res);
        return ans[0];
        
    }
    public void dfs(TreeNode root, int k, int[] ans, int[] res){
        if(root == null || res[0] > k ){
            return;
        }
        
        dfs(root.left, k, ans, res);
        res[0] = res[0] + 1;
        if(k == res[0]){
            ans[0] = root.val;
        }
        dfs(root.right, k ,ans,  res);


    }
}
