class Solution {
    public int[] sortArray(int[] nums) {

        return dfs(nums);
        
    }

    public int[] dfs(int[] arr){
        if(arr.length <= 1){
            return arr;
        }

        int mid = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, mid);
        int[] arr2 = Arrays.copyOfRange(arr, mid, arr.length);

        int[] sorted1 = dfs(arr1);
        int[] sorted2 = dfs(arr2);

        //merge them
        int i = 0;
        int j = 0;
        int k = 0;
        int[] sort = new int[sorted1.length + sorted2.length];

        while(i < sorted1.length && j < sorted2.length){
            if(sorted1[i] < sorted2[j]){
                sort[k] = sorted1[i];
                i++;
                k++;
            }else{
                sort[k] = sorted2[j];
                j++;
                k++;
            }
        }

        while(i < sorted1.length){
            sort[k] = sorted1[i];
            i++;
            k++;
        }

        while(j < sorted2.length){
            sort[k] = sorted2[j];
            j++;
            k++;
        }

        return sort;
    }
}