class Solution {
    public int openLock(String[] deadends, String target) {

        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));

        if(dead.contains("0000")){
            return -1;
        }

        Queue<String> q = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();

        q.offer("0000");
        visited.add("0000");
        int moves = 0;

        while(!q.isEmpty()){

            int size = q.size();
            for(int i = 0; i < size; i++){
                String cur = q.poll();
                if(cur.equals(target)){
                    return moves;
                }
                char[] arr = cur.toCharArray();
                for(int j = 0; j < arr.length; j++){
                    char original = arr[j];
                    arr[j] = (char)(((original - '0' + 1) % 10) + '0');
                    String new1 = new String(arr);
                    if(!visited.contains(new1) && !dead.contains(new1)){
                        q.offer(new1);
                        visited.add(new1);
                    }

                    arr[j] = (char)(((original - '0' - 1 + 10) % 10) + '0');
                    String new2 = new String(arr);
                    if(!visited.contains(new2) && !dead.contains(new2)){
                        q.offer(new2);
                        visited.add(new2);
                    }

                    arr[j] = original;

                }
            }

            moves++;
        }

        return -1;
        
    }
}