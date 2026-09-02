class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> idx= new HashMap<>();



        List<Integer> res=  new ArrayList<>();
        

        for(int j = 0; j< s.length(); j++){
            
            idx.put(s.charAt(j), j);
        }

        int lastIndex = 0;
        int end = 0;

        


        for(int i =0 ; i<s.length(); i++){
            
            
            end = Math.max(end, idx.get(s.charAt(i)));
            if(i == end){
                res.add(end - lastIndex + 1);
                lastIndex = end + 1;
            }
            

        }

        return res;
        
    }
}
