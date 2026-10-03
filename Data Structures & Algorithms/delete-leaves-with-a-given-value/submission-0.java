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
    public TreeNode removeLeafNodes(TreeNode root, int target) {

        return recursive(root, target);
        
    }

public TreeNode recursive(TreeNode root, int val){

        if(root == null){
                return null;
                    }
                     root.left = recursive(root.left, val);
                            root.right = recursive(root.right, val);

                                if(root.left == null && root.right == null && root.val == val){
                                        return null;
                                            }

                                                return root;
                                                }
}
