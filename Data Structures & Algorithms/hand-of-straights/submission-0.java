class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int i = 0; i<hand.length; i++){
            count.put(hand[i], count.getOrDefault(hand[i],0) + 1);
        }

        for(int num : hand){
            if(count.get(num)>0){
                for(int i =num; i<num + groupSize;i++){
                    if(count.getOrDefault(i,0) == 0){
                        return false;
                    }else{
                        count.put(i, count.get(i) - 1);
                    }
                }
            }
        }
        return true;


        
    }
}
