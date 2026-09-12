class Solution {
    public boolean canPartition(int[] arr) {
        
        int n = arr.length;

        int totalsum = 0;

        for(int i=0;i<n;i++){
            totalsum+=arr[i];
        }


        if(totalsum%2!=0){
            return false;
        }

        int part = totalsum/2;

        boolean dp[][] = new boolean[n+1][part+1];

        for(int i=0;i<=n;i++){
            dp[i][0] = true;
        }


        for(int i=1;i<=n;i++){

            for(int j =0;j<=part;j++){

                if(arr[i-1] <=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[n][part];

    }
}