class Solution {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int n = num1.length();
        int m = num2.length();

        int[] res = new int[n + m];

        for(int i = num1.length() - 1; i >= 0; i--){
            for(int j = num2.length() - 1; j >= 0; j--){
                int ic = num1.charAt(i) - '0';
                int jc = num2.charAt(j) - '0';

                int product = ic * jc + res[i + j + 1];

                res[i+j+1] = product % 10;
                res[i+j] += product / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++){
            if( i == 0 && res[i] == 0){
                continue;
            }
            sb.append(res[i]);
        }

        return sb.toString();
        
    }
}
