class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ten = 0;
        int five = 0;

        for(int i = 0; i < bills.length; i++){
            int balance = bills[i] - 5;
            if(bills[i] == 10){
                ten++;
            }else if(bills[i] == 5){
                five++;
            }

            
            if(balance == 15){
                if(ten > 0 && five >= 1){
                    ten--;
                    five--;
                     
                }else if(five > 2){
                    five -= 3;
                }else{
                    return false;
                }
            }else if(balance == 5){
                if(five > 0){
                    five--;
                }else{
                    return false;
                }

            } 
        }

        return true;
        
    }
}