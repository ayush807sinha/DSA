class Solution {
    public int findTargetSumWays(int[] arr, int target) {
        int n = arr.length;

        int totalsum = 0;

        for(int i=0;i<n;i++){
            totalsum +=arr[i];
        }


        if(totalsum < Math.abs(target) || (totalsum - target) % 2 != 0){
            return 0;
        }


        int pos = (totalsum-target)/2;

        int dp[][] = new int[n+1][pos+1];


        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }


        for(int i=1;i<=n;i++){

            for(int j=0;j<=pos;j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }


        return dp[n][pos];
    }
}