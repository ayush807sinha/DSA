class Solution {
    public int rob(int[] arr) {
        int n = arr.length;

        int dp[] = new int[n];

        dp[0] = arr[0];

        for(int i=1;i<n;i++){
            int pick = arr[i];
            if(i>1){
                pick = pick + dp[i-2];
            }
            int notpick = 0 + dp[i-1];

            dp[i] = Math.max(pick,notpick);
        }

        return dp[n-1];
    }
}