class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast=sum(n);
        if(n==1){
            return true;
        }

        while (slow!=fast){
            slow = sum(slow);
            fast = sum(sum(fast));
            if(fast==1|| slow==1){
                return true;
            }
        }
        return false;

        
    }

    public int sum(int n){
        int ans = 0;
        int temp =n;

        while(temp>0){
            int i = temp%10;
            ans = ans+ i*i;
            temp = temp / 10;
        }
        return ans;
        

    }
}
