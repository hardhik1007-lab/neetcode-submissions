class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        int n = accounts.size();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0;  i < n; i++){
            graph.add(new ArrayList<>());
        }

        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            List<String> cur = accounts.get(i);
            int  len = cur.size();

            for(int j = 1; j < len; j++){
                if(map.containsKey(cur.get(j))){
                    int idx = map.get(cur.get(j));
                    graph.get(idx).add(i);
                    graph.get(i).add(idx);
                }else{
                    map.put(cur.get(j), i);
                }
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();

        List<List<String>> res = new ArrayList<>();




        for(int i = 0; i < graph.size(); i++){
            if(!visited.contains(i)){
                visited.add(i);
                q.add(i);
                HashSet<String> h = new HashSet<>();

                while(!q.isEmpty()){
                    int cur = q.poll();

                    List<String> curmail = accounts.get(cur);
                    

                    // add all mails
                    for(int j = 1; j < curmail.size(); j++){
                        h.add(curmail.get(j));
                    }

                    //add all neighbors
                    List<Integer> neigh = graph.get(cur);
                    for(int nu : neigh){
                        if(!visited.contains(nu)){
                            q.add(nu);
                            visited.add(nu);
                        }
                    }
                }

                //now add to res
                List<String> ans = new ArrayList<>();
                ans.add(accounts.get(i).get(0));

                List<String> emails = new ArrayList<>(h);
                Collections.sort(emails);

                ans.addAll(emails);

                res.add(ans);

            }
        }

        return res;


        
    }
}