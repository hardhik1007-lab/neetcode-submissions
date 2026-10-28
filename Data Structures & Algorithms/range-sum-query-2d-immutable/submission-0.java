class NumMatrix {
    int[][] prefix;

    public NumMatrix(int[][] matrix) {
        
        this.prefix = new int[matrix.length + 1][matrix[0].length + 1];

        for(int i = 1; i <= matrix.length; i++){
            for(int j = 1; j <= matrix[0].length; j++){
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1] + matrix[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        //prefix 1- indexed
        //matrix 0 - indexed


        int sum = prefix[row2 + 1][col2 + 1] - prefix[(row1 + 1) - 1][col2 + 1] - prefix[row2 + 1][(col1 + 1) - 1] + prefix[row1][col1];

        return sum;
        
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */