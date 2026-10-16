class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {

        int n = arr.length;

        int high=0;
        int low=0;
        int one=0;
        int ans =0;


        while(high<n){
            
            if(arr[high] == 1){
                one++;
            }

            if(arr[high] == 0){
                one = 0;
                low = high+1;
            }

            ans = Math.max(ans,one);
            high=high+1;
        }


        return ans;

    }
}