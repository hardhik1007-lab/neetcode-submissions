class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<>());
                
            }
            map.get(sorted).add(str);
            
        } 

        List<List<String>> res = new ArrayList<>();
        for(List<String> values: map.values()){
            res.add(values);
        }

        return res;
        
    }
}
