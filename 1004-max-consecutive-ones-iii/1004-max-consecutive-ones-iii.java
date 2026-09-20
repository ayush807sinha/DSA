class Solution {
    public int longestOnes(int[] arr, int k) {
        
        int n = arr.length;

        int high=0;
        int low =0;
        int ans=0;
        int zeros=0;

        while(high<n){

            if(arr[high] ==0){
                zeros++;
            }
            high++;

            while(zeros > k){
                if(arr[low]==0){
                    zeros--;
                }
                low++;
            }
            ans = Math.max(ans,high-low);
        }

        return ans;
    }
}