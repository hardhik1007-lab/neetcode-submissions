class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {      

        if(!wordList.contains(endWord)){
            return 0;
        }
        HashMap<String, List<String>> al = new HashMap<>();

        for(String word : wordList){
            for(int i =0; i < word.length(); i++){
                String temp = word.substring(0,i) + '*' + word.substring(i+1, word.length());
                if(!al.containsKey(temp)){
                    al.put(temp, new ArrayList<>());
                }
                
                al.get(temp).add(word);
            }
        }

        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int min = 1;
        HashSet<String> visited = new HashSet<>();

        while(!q.isEmpty()){

            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(cur.equals(endWord)){
                    return min;
                }
                for(int j =0; j < cur.length(); j++){
                    String temp = cur.substring(0,j) + '*' + cur.substring(j+1,cur.length());
                    if(al.containsKey(temp)){
                        List<String> bucketlist = al.get(temp);
                        for(String word : bucketlist){
                            if(!visited.contains(word)){
                                q.add(word);
                                visited.add(word);
                            }
                        }
                    }
                }

            }
            min++;
        }

        return 0;

        
    }
}
