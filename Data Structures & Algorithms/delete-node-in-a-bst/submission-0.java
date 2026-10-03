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
    public TreeNode deleteNode(TreeNode root, int key) {

        return recursive(root,key);
        
    }

    public TreeNode recursive(TreeNode root, int key){

        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = recursive(root.left, key);
        }else if(key > root.val){
            root.right = recursive(root.right, key);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null || root.right == null){
                if(root.left != null){
                    return root.left;
                }else{
                    return root.right;
                }
            }else{
                TreeNode min = root.right;
                while(min.left != null){
                    min = min.left;
                }
                // min is the smallest node in right subtree

                root.val = min.val;
                root.right = recursive(root.right, min.val);
            }
        }

        return root;
    }

    
}