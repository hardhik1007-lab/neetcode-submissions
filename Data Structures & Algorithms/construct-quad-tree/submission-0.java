/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {

        return recursion(grid, 0,0,grid.length);
        
    }

    public Node recursion(int[][] grid, int i, int j, int size){
        
        int val = grid[i][j];
        boolean leaf = true;

        for(int l = i; l < i + size; l++){
            for(int b = j; b < j + size; b++){
                if(val != grid[l][b]){
                    leaf = false;
                }

            }
        }

        Node node;
        if(leaf){
            // this is leaf node, create 
            boolean flag = (val == 1);

            node = new Node(flag, true);
        }else{
            //not a leaf, create node and assign 4 children nodes.
            int half = size/2;
            node = new Node( true, false);
            node.topLeft = recursion(grid, i, j, half);
            node.topRight = recursion(grid, i, j + half, half);
            node.bottomLeft = recursion(grid, i + half, j, half);
            node.bottomRight = recursion(grid, i + half, j + half, half);


        }

        return node;
        
    }
}