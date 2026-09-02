class Solution {

    Boolean[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(),n= s2.length();
        if(m+n != s3.length()){return false;}
        dp = new Boolean[s1.length()+1][s2.length()+1];

        return dfs(0,0,s1,s2,s3);
        
        


    }

    boolean dfs(int i, int j, String s1, String s2, String s3){
            if(i+j==s3.length()){
                return i==s1.length() && j==s2.length();
            }

            if(dp[i][j] != null){
                return dp[i][j];
            }

            

            if(i<s1.length() && s1.charAt(i) == s3.charAt(i+j) && dfs(i+1,j,s1,s2,s3)){
                return true;
            }
            if(j<s2.length() && s2.charAt(j) == s3.charAt(i+j) && dfs(i,j+1,s1,s2,s3)){
                return true;
            }
            dp[i][j] = false;
            return false;

        }
}
