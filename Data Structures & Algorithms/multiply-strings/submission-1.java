class Solution {
    
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String res = "0";
        int padding = 0;


        for(int i = num2.length() - 1; i >= 0; i--){

            int digit = num2.charAt(i) - '0';
            String num = multiplication(num1, digit, padding);
            res = add(num, res);
            padding++;
        }   

        return res;
        
    }

    public String multiplication(String num1, int digit, int padding){
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1; i >= 0; i--){
            int ic = num1.charAt(i) - '0';
            int product = ic * digit + carry;
            carry = product / 10;
            product = product % 10;

            sb.append(Integer.toString(product)); 
        }

        if(carry != 0){
            sb.append(carry);
        }

        sb = sb.reverse();
        for(int i = 0; i < padding; i++){
            sb.append(0);
        }

        return sb.toString();
    }

    public String add(String nums1, String nums2){
        int i = nums1.length() - 1;
        int j = nums2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        

        while(i >= 0 || j >= 0){
            
            int ic = i >= 0 ? nums1.charAt(i) - '0' : 0;
            int jc = j >= 0 ? nums2.charAt(j) - '0' : 0;
            int sum = ic + jc + carry;
            carry = sum/10;
            sum = sum%10;

            sb.append(Integer.toString(sum));

            
            i--;
            j--;
        }

        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
