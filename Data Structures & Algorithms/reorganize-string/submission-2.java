class Pair{
    char c;
    int freq;

    public Pair(char c, int freq){
        this.c = c;
        this.freq = freq;
    }
}

class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((a,b) -> b.freq - a.freq);

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : map.keySet()){
            heap.add(new Pair(c, map.get(c)));
        }

        StringBuilder sb = new StringBuilder();
        Pair prev= null;

        while(sb.length() < s.length()){


            if(heap.isEmpty()){
                return "";
            }

            Pair cur = heap.poll();
            
            sb.append(cur.c);
            cur.freq = cur.freq - 1;


            if(prev != null && prev.freq > 0){
                heap.offer(prev);
            }
            
            prev =cur;

                
            

        }

        return sb.toString();


    }
}