class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for(int layer = 0; layer < n/2; layer++){
            for(int offset = 0; offset < n-1 - 2 *layer; offset++){
                int first = matrix[layer][layer + offset];
                int second = matrix[layer + offset][n - 1 - layer];
                int third = matrix[n - 1 - layer][n -1 - (layer + offset)];
                int fourth = matrix[n -1 - (layer + offset)][n-1 - (n - 1 - layer)];

                matrix[layer + offset][n - 1 - layer] = first;
                matrix[n - 1 - layer][n -1 - (layer + offset)] = second;
                matrix[n -1 - (layer + offset)][n-1 - (n - 1 - layer)] = third;
                matrix[layer][layer + offset] = fourth;

                


            }
        }
        
    }
}
