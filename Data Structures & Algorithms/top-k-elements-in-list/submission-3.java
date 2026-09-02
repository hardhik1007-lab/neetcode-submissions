class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        //HashMap<Integer, Integer> map = new HahMap<>();

        Arrays.sort(nums);
        ArrayList<int[]> array = new ArrayList<>();
        
        int[] result = new int[k];
        int i = 0;

        while(i<nums.length){
            int num = nums[i];
            int count = 0;
            while(i<nums.length && nums[i]==num){
                count++;
                i++;
            }
            array.add(new int[]{num,count});
            
        }

        Collections.sort(array, (a,b) -> Integer.compare(a[1], b[1]));
        for(int j = array.size() - 1; j>array.size() -1 -k; j-- ){
            result[array.size() - 1 - j] = array.get(j)[0];
        }
        return result;

        
    }
}
