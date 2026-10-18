class Solution {
    public int romanToInt(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = 0;
        for(int i = 0;i < s.length(); i++){
            char c = s.charAt(i);
            int val = map.get(c);
            if(c == 'I'){
                if(i < s.length() - 1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                    res -= val;
                }else{
                    res += val;
                }

            }else if(c == 'X'){
                if(i < s.length() - 1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                    res -= val;
                }else{
                    res += val;
                }
            }else if(c == 'C'){
                if(i < s.length() - 1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                    res -= val;
                }else{
                    res += val;
                }
            }else{
                res += val;
            }
            
        }

        return res;
        
    }
}