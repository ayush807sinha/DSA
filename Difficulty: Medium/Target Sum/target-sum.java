class Solution {
    public int totalWays(int[] arr, int target) {
        
        
        int n = arr.length;
        
        
        int totalsum=0;
        for(int i=0;i<n;i++){
            totalsum+=arr[i];
        }
        
        if (totalsum < target || (totalsum - target) % 2 != 0) {
                    return 0;
        }
        
        
        int pos = (totalsum-target)/2;
     
        
        int dp[][] = new int[n+1][pos+1];
        
        
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        
        
        
        for(int i=1;i<=n;i++){
            
            
            for(int j=1;j<=pos;j++){
                
                if(arr[i-1] <=j){
                    int c1 = dp[i-1][j-arr[i-1]];
                    int c2 = dp[i-1][j];
                
                    dp[i][j] = c1+c2;
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                
            }
            
        }
        
        
        return dp[n][pos];
        
    }
    
}    