class Solution {
    public String gcdOfStrings(String str1, String str2) {

        StringBuilder sb = new StringBuilder();
        int g = gcd(str1.length(), str2.length());

        String cand = str1.substring(0, g);
        int n = str1.length() / cand.length();

        for(int i = 0; i < n ; i++){
            sb.append(cand);
        }
        if(!sb.toString().equals(str1)){
            return "";
        }

        //for str2
        
        int m = str2.length() / cand.length();
        StringBuilder sb1 = new StringBuilder();

        for(int i = 0; i < m ; i++){
            sb1.append(cand);
        }
        if(!sb1.toString().equals(str2)){
            return "";
        }

        return cand;
        
    }

    public int gcd(int a, int b){
        while(b != 0){
            int temp = b;
            b = a%b;
            a = temp;
        }

        return a;
    }
}