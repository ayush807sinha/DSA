class Solution {
    public int longestOnes(int[] arr, int k) {
        int n  = arr.length;

        int low =0;
        int high =0;

        int res = 0;

        int zeroCnt =0;

        for(high =0 ; high<n;high++){
            
            if(arr[high]==0){
                zeroCnt++;
            }

            int len = high -low+1;

            while(zeroCnt > k){
                if(arr[low]==0){
                    zeroCnt--;
                }
                low++;

                len = high - low+1;
                
            }

            len = high -low+1;
            res = Math.max(res,len);



        }

        return res;
    }
}