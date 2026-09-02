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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return dfs(preorder, inorder, map,0, preorder.length -1, 0, inorder.length -1);
        
    }

    public TreeNode dfs(int[] preorder, int[] inorder, HashMap<Integer, Integer> map, int preStart, int preEnd, int instart, int inEnd){

        if(preStart > preEnd || instart > inEnd){
            return null;
        }
        int idx= map.get(preorder[preStart]);
        int leftSize = idx - instart; 
        TreeNode lefttree = dfs(preorder, inorder, map, preStart+1,preStart+ leftSize, instart, idx - 1);
        TreeNode righttree = dfs(preorder, inorder, map, preStart+1+leftSize, preEnd, idx + 1, inEnd);
        TreeNode root = new TreeNode(preorder[preStart],lefttree, righttree);
        return root;
        

    }
}
