class CountSquares {

    HashMap<Integer, HashMap<Integer, Integer>> map;

    public CountSquares() {
        map = new HashMap<>();

        
    }
    
    public void add(int[] point) {
        HashMap<Integer, Integer>  temp = map.getOrDefault(point[0],new HashMap<>());
        temp.put(point[1], temp.getOrDefault(point[1], 0) + 1);
        map.put(point[0], temp);
        }
    
    public int count(int[] point) {
        int count = 0;

        for(int x : map.keySet()){
            for(int y : map.get(x).keySet()){
                if(x == point[0] && y == point[1]){
                    continue;
                }
                if(Math.abs(x - point[0]) != Math.abs(y - point[1])){
                    continue;

                }

                int point2 = map.get(x).get(y);

                int point3 = map.getOrDefault(point[0], new HashMap<>()).getOrDefault(y,0);
                int point4 = map.getOrDefault(x, new HashMap<>()).getOrDefault(point[1],0);

                count += point2 * point3 * point4;

            }

            
            


            


        }
        return count;
        
    }
}
