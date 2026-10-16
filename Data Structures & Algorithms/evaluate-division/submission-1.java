class Edge{
    double value;
    String s;
    public Edge(String s, double value){
        this.value = value;
        this.s = s;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String, List<Edge>> map = new HashMap<>();

        for(int i = 0;i < equations.size(); i++){
            String one = equations.get(i).get(0);
            String two = equations.get(i).get(1);

            if(!map.containsKey(one)){
                map.put(one, new ArrayList<>());
            }
            if(!map.containsKey(two)){
                map.put(two, new ArrayList<>());
            }

            map.get(one).add(new Edge(two, values[i]));
            map.get(two).add(new Edge(one, 1.0/values[i]));
        }


        double[] res = new double[queries.size()];

        

        for(int i = 0; i < queries.size(); i++){
            String cur1 = queries.get(i).get(0);
            String cur2 = queries.get(i).get(1);
            HashSet<String> visited = new HashSet<>();
            Queue<Edge> q = new ArrayDeque<>();
            
            if(!map.containsKey(cur1) || !map.containsKey(cur2)){
                res[i] = -1.0;
                continue;
            }
            if(cur1.equals(cur2)){
                res[i] = 1.0;
                continue;
            }

            q.offer(new Edge(cur1, 1.0));
            visited.add(cur1);
            boolean found = false;

            while(!q.isEmpty()){
                Edge cur = q.poll();
                
                
                List<Edge> e = map.get(cur.s);
                for(int j = 0; j < e.size(); j++){
                    String v = e.get(j).s;
                    double val = e.get(j).value;
                    if(v.equals(cur2)){
                        //this is the answer
                        res[i] = cur.value * val;
                        found = true;
                        break;
                    }

                    if(!visited.contains(v)){
                        visited.add(v);
                        q.offer(new Edge(v, val * cur.value));

                    }
                    

                    
                }
                if(found){
                    break;
                    }
                    
                
                
            }

            if(!found){
                res[i] = -1.0;
            }


        }

        return res;

        
    }
}