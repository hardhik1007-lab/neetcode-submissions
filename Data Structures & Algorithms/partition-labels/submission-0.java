class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> count= new HashMap<>();



        List<Integer> res=  new ArrayList<>();

        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c,0)+1);
        }

        HashSet<Character> set = new HashSet<>();
        int len = 0;


        for(char c: s.toCharArray()){
            
            set.add(c);
            count.put(c,count.get(c)-1);
            len++;
            

            boolean allZero = true;

            for (char ch : set) {
                if (count.get(ch) != 0) {
                    allZero = false;
                    break;
                }
            }
            if(allZero){
                res.add(len);
                len = 0;
                set.clear();
            }

        }

        return res;
        
    }
}
