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
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> res= new ArrayList<>();

        if(root != null){
            q.offer(root);
            res.add(root.val);
        }

        while(!q.isEmpty()){
            int size = q.size();
            TreeNode rightmost = null;
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(cur.left != null){
                    q.offer(cur.left);
                    rightmost = cur.left;
                }
                if(cur.right != null){
                    q.offer(cur.right);
                    rightmost = cur.right;
                }
            }
            if(rightmost != null){
                res.add(rightmost.val);
            }
            
        }

        return res;
        
    }
}
