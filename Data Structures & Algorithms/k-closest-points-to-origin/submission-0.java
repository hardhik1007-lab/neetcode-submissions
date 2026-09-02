class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxheap = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int[] point : points){
            int x1 = point[0];
            int y1 = point[1];
            maxheap.offer(new int[]{distance(x1,y1),x1,y1});
            if(maxheap.size()>k){
                maxheap.poll();
            }
            
        }

        int[][] result = new int[k][2];
        int i = 0;
        while(!maxheap.isEmpty()){
            int[] point = maxheap.poll();
            result[i][0] = point[1];
            result[i][1] = point[2];
            i++;
        }

        return result;




        

    }

    public int distance(int x, int y){
        return x * x + y * y;
    }
}
