class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            int[] temp = new int[26];
            for(int i = 0; i < str.length(); i++){
                temp[str.charAt(i) - 'a']+=1;
            }
            /*StringBuilder sb = new StringBuilder();
            for(int n : temp){
                sb.append(n);

            }
            String key = sb.toString()*/

            String key = Arrays.toString(temp);
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
                
            }
            map.get(key).add(str);
            
        } 

        List<List<String>> res = new ArrayList<>();
        for(List<String> values: map.values()){
            res.add(values);
        }

        return res;
        
    }
}
