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
        dfs_ser(root,sb);
        return sb.toString();
        
    }
    public void dfs_ser(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("N").append(",");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        dfs_ser(root.left,sb);
        dfs_ser(root.right,sb);
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        int[] i = new int[1];
        String[] values = data.split(",");
        return dfs_deser(values, i);

        
    }
    public TreeNode dfs_deser(String[] values, int[] i){
        if(i[0] > values.length || values[i[0]].equals("N")){
            i[0]++;
            return null;
        }

        int val = Integer.parseInt(values[i[0]]);
        TreeNode node = new TreeNode(val);
        i[0]++;
        
        node.left = dfs_deser(values, i);
        node.right = dfs_deser(values, i);
        return node;



    }
}
