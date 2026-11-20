class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i <nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if(minHeap.size()>k){
                minHeap.poll();
            }

            
        }

        int[] res = new int[k];

        for(int i = 0; i<k; i++){
            int[] max = minHeap.poll();
            res[i] = max[0];
        }

        return res;

        

        

        

        
    }
}
