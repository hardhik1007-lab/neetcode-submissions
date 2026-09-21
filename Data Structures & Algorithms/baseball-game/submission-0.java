class Solution {
    public int calPoints(String[] operations) {

        List<Integer> ans = new ArrayList<>();
        int total = 0;

        for(String str : operations){
            if(str.equals("+")){
                int size = ans.size();
                ans.add(ans.get(size - 1) + ans.get(size - 2));
                total += ans.get(size - 1) + ans.get(size - 2);
            }else if(str.equals("D")){
                int size = ans.size();
                ans.add(ans.get(size - 1) * 2);
                total += ans.get(size - 1) * 2;
            }else if(str.equals("C")){
                int size = ans.size();
                
                total -= ans.get(size - 1);
                ans.remove(size - 1);
            }else{
                int x = Integer.parseInt(str);
                ans.add(x);
                total += x;
            }
        }

        return total;
        
    }
}