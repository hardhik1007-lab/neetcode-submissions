class Pair {
    char c;
    int freq;

    public Pair(char c, int freq) {
        this.c = c;
        this.freq = freq;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {

        

        PriorityQueue<Pair> heap = new PriorityQueue<>((x,y) -> Integer.compare(y.freq, x.freq));
        if(a > 0){
            heap.offer(new Pair('a', a));
        }
        if(b > 0){
            heap.offer(new Pair('b', b));
        }
        if(c > 0){
            heap.offer(new Pair('c', c));
        }
        StringBuilder sb = new StringBuilder();

        while(!heap.isEmpty()){

            Pair cur = heap.poll();
            
            int n = sb.length();

            // condition 1 - both last and before lst = cur
            if(n >= 2 && sb.charAt(n - 1) == cur.c && sb.charAt( n - 2) == cur.c){
                //use next elemnt
                if(heap.isEmpty()){
                    return sb.toString();
                }
                Pair second = heap.poll();
                sb.append(second.c);
                second.freq--;
                if(second.freq > 0){
                    heap.offer(second);
                }
                heap.offer(cur);
            }else{

                sb.append(cur.c);
                cur.freq--;
                if(cur.freq > 0){
                    heap.offer(cur);
                }
                

            }

        }
        return sb.toString();


        
    }
}