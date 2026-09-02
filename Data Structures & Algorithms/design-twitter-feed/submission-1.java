class Twitter {
    int count;

    HashMap<Integer,Set<Integer>> followMap;
    HashMap<Integer, List<int[]>> tweetMap;

    public Twitter() {
        count =0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new int[]{count, tweetId });
        count++;

        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        followMap.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
        for(int followeeId : followMap.get(userId)){
            if(tweetMap.containsKey(followeeId)){
                List<int[]> tweets = tweetMap.get(followeeId);
                
                int index = tweets.size() - 1;
                int[] tweet = tweets.get(index);
                maxHeap.offer(new int[]{tweet[0],tweet[1],followeeId,index-1});
            }
        }

        while(!maxHeap.isEmpty() && res.size()<10){
            int[] top = maxHeap.poll();
            res.add(top[1]);
            if(top[3]>=0){
                List<int[]> tweets = tweetMap.get(top[2]); 
                
                int[] tweet = tweets.get(top[3]);
                maxHeap.offer(new int[]{tweet[0],tweet[1],top[2],top[3]-1});
            }
        }
        return res;


        
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId,k -> new HashSet<>()).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
        
    }
}
