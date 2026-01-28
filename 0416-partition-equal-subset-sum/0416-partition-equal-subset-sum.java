class Solution {
    public boolean canPartition(int[] arr) {
        int n = arr.length;

        int totalSum = 0;
        for(int i=0;i<n;i++){
            totalSum+=arr[i];
        }

        if(totalSum %2 !=0){
            return false;
        }

        int targetSum = totalSum/2;

        boolean dp[][]= new boolean[n][targetSum+1];

        for(int i=0;i<n;i++){
            dp[i][0] = true;
        }

        if(arr[0] <= targetSum){
            dp[0][arr[0]] =  true; 
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=targetSum;j++){
                boolean take = dp[i-1][j];
                boolean notTake = false;
                if(arr[i]<=j){
                    notTake = dp[i-1][j - arr[i]];
                }
                dp[i][j] = take || notTake;
            }
        }

        return dp[n-1][targetSum];
        
    }
}