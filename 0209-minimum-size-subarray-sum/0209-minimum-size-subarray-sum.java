class Solution {
    public int minSubArrayLen(int k, int[] arr) {
        
        int n = arr.length;

        int low =0;
        int high=0;
        int win =0;
        int ans =Integer.MAX_VALUE;

        while(high<n){
            win = win +  arr[high];
            
            while(win>=k){
                ans = Math.min(ans,high-low+1);
                win = win - arr[low];
                low++;

            }

            high++;

        }

        if(ans == Integer.MAX_VALUE){
            return 0;
        }else{
            return ans;
        }


    }
}