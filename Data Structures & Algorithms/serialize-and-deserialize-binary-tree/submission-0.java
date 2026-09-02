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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            if(cur == null){
                sb.append('N').append(',');
            }else{
                
                sb.append(cur.val).append(',');
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");
        int i = 0;
        Queue<TreeNode> q = new LinkedList<>();
        String value = values[i];
        if(value.equals("N")){
            return null;
        }
        int val = Integer.parseInt(value);
        TreeNode root = new TreeNode(val);
        q.offer(root);
        i++;

        while(i < values.length){

            // cur node from queue
            TreeNode node = q.poll();
            

            if(values[i].equals("N")){
                i++;
                
            }else{
                // biuld left and attach
                int val_left = Integer.parseInt(values[i]);
                TreeNode left = new TreeNode(val_left);
                node.left = left;
                q.offer(left);
                i++;
            }

            // for right
            if(values[i].equals("N")){
                i++;
                
            }else{
                //build right and atatach
                int val_right = Integer.parseInt(values[i]);
                TreeNode right = new TreeNode(val_right);
                node.right = right;
                q.offer(right);
                i++;

            }

        }

        return root;
        
    }
}
