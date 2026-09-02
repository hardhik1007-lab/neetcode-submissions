class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i =0; i < tickets.size(); i++){
            String src = tickets.get(i).get(0);
            String dst = tickets.get(i).get(1);
            if(!map.containsKey(src)){
                map.put(src, new ArrayList<>());
            }
            map.get(src).add(dst);

        }
        for(String src: map.keySet()){
            Collections.sort(map.get(src), Collections.reverseOrder());
        }

        List<String> path = new ArrayList<>();
        dfs("JFK", tickets, path, map);
        Collections.reverse(path);
        return path;


        
    }

    public void dfs(String src, List<List<String>> tickets, List<String> path,HashMap<String, List<String>> map){

        

        while(map.containsKey(src) && !map.get(src).isEmpty()){
            List<String> destinations = map.get(src);
            String dst = destinations.get(destinations.size()-1);
            destinations.remove(destinations.size()-1);
            dfs(dst, tickets, path, map);
        }

        path.add(src);
        return;




    }
}