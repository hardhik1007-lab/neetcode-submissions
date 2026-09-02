class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dparray = new int[text1.length()+1][text2.length()+1];

        for(int i=text1.length()-1;i>-1;i--){
            for(int j=text2.length()-1;j>-1;j--){
                if(text1.charAt(i)==text2.charAt(j)){
                    dparray[i][j]= dparray[i+1][j+1] + 1;
                }else{
                    dparray[i][j]=Math.max(dparray[i+1][j],dparray[i][j+1]);
                }
            }
        }
        return dparray[0][0];
    }
}
