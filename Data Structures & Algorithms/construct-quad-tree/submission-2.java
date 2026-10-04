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
        int n = grid.length;

        int[][] prefix = new int[n+1][n+1];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                prefix[i+1][j+1] = prefix[i+1][j] + prefix[i][j+1] - prefix[i][j] + grid[i][j];
            }
        }



        return recursion(grid, 0,0,grid.length, prefix);
        
    }

    public Node recursion(int[][] grid, int i, int j, int size, int[][] prefix){
        
        int val = grid[i][j];
        boolean leaf = false;

        int sum = prefix[i + size][j + size]
        - prefix[i][j + size]
        - prefix[i + size][j]
        + prefix[i][j];

        if(sum == 0 || sum == size * size){
            leaf = true;
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
            node.topLeft = recursion(grid, i, j, half, prefix);
            node.topRight = recursion(grid, i, j + half, half, prefix);
            node.bottomLeft = recursion(grid, i + half, j, half, prefix);
            node.bottomRight = recursion(grid, i + half, j + half, half, prefix);


        }

        return node;
        
    }
}