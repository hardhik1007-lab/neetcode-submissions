class Solution {
    //caring for odd m * n lesser. no rows or cols left even if rows != cols
    public List<Integer> spiralOrder(int[][] matrix) {


        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        for(int layer = 0; layer < Math.min(rows,cols)/2; layer++){
            //topright
            for(int i = layer; i < cols-1-layer; i++){
                res.add(matrix[layer][i]);

            }
            //rightcol
            for(int j = layer; j < rows - 1 - layer; j++){
                res.add(matrix[j][cols - 1 - layer]);

            }
            //bottom
            for(int i = cols - 1 - layer; i > layer; i--){
                res.add(matrix[rows - 1 - layer][i]);

            
            }
            //left
            for(int j = rows - 1 - layer; j > layer; j--){
                res.add(matrix[j][layer]);

            }
        }
        if(Math.min(rows,cols) % 2 == 1){
            int layer = Math.min(rows, cols) / 2;
            if(rows > cols){
                
                for(int i = layer; i <= rows- 1 - layer; i++){
                    res.add(matrix[i][layer]);
                }

            }else{
                
                for(int j = layer; j <= cols- 1 - layer; j++){
                    res.add(matrix[layer][j]);
                }

            }

        }

        
        return res;
        
    }
}
