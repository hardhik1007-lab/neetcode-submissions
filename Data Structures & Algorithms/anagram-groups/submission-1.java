class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for(String str:strs){
            int[] fre = new int[26];
            for(char c : str.toCharArray()){
                fre[c - 'a']+=1;

            }
            String key = Arrays.toString(fre);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str);
        }
        return new ArrayList<>(res.values());
    }
}
