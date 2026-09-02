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
        ArrayDeque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        int depth = 0;
        if(root != null){
            stack.push(new Pair<>(root,1));
        }


        while(!stack.isEmpty()){
            Pair<TreeNode, Integer> cur = stack.pop();
            TreeNode node= cur.getKey();
            int cur_depth = cur.getValue();

            depth = Math.max(depth, cur_depth);

            if(node.left != null){
                stack.push(new Pair<>(node.left, 1+ cur_depth));
            }
            if(node.right != null){
                stack.push(new Pair<>(node.right, 1+ cur_depth));
            }

            
            
            
        }

        return depth;


        
    }
    
}
