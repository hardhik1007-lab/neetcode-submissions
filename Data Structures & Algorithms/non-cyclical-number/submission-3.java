class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        
        int cur = n;
        while(!seen.contains(cur)){
            int ans = 0;
            int temp = cur;
            while(temp>0){
                int i = temp%10;
                ans = ans+ i*i;
                temp = temp / 10;
            }
            if(ans==1){
                return true;
            }
            seen.add(cur);
            cur = ans;
        }
        return false;
        
    }
}
