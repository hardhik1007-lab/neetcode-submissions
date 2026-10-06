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
        char prev = ' ';

        while(sb.length() < s.length()){
            if(!heap.isEmpty()){
                Pair cur = heap.poll();
                if(prev != cur.c){
                    sb.append(cur.c);
                    cur.freq = cur.freq - 1;
                    prev =cur.c;
                }else{
                    if(heap.isEmpty()){
                        return "";
                    }
                    Pair cur2 = heap.poll();
                    sb.append(cur2.c);
                    cur2.freq = cur2.freq - 1;
                    if(cur2.freq > 0){
                        heap.offer(cur2);
                    }
                    
                    prev = cur2.c;
                }

                if(cur.freq > 0){
                    heap.offer(cur);
                }
            }

        }

        return sb.toString();


    }
}