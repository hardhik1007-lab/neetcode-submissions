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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] max = new int[1];
        diameterhelper(root,max);
        return max[0];
        
    }

    public int diameterhelper(TreeNode node,int[] max){
        if(node==null){
            return 0;
        }
        int left = diameterhelper(node.left,max);
        int right = diameterhelper(node.right,max);

        if(max[0]<left + right){
            max[0] = left + right;
        }
        return 1+ Math.max(left,right);
    }

}
