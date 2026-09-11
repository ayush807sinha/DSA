class Solution {
    public int rob(int[] arr) {

        int n = arr.length;

        int dp[] = new int[n];

        dp[0] = arr[0];
        if(n==1){
            return arr[0];
        }
        dp[1] = arr[0];

        for(int i=2;i<=n-2;i++){
            int c1 = arr[i] + dp[i-2];
            int c2  = dp[i-1];
            dp[i] = Math.max(c1,c2);
        }

        int ans1 = dp[n-2];

        dp[1] = arr[1];
        dp[0] = 0;

        for(int i=2;i<=n-1;i++){
            int c1 = arr[i] + dp[i-2];
            int c2 = dp[i-1];
            dp[i] = Math.max(c1,c2);
        }

        int ans2 = dp[n-1];

        return Math.max(ans1,ans2);  
        
    }
}