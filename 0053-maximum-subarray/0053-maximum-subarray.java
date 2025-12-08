class Solution {
    public int maxSubArray(int[] arr) {
        int best = arr[0];
        int ans = arr[0];

        for(int i=1;i<arr.length;i++){
            int v1 = arr[i];
            int v2 = best + arr[i];

            best = Math.max(v1,v2);

            ans = Math.max(ans , best);

        }

        return ans;
    }
}