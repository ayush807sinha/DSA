class Solution {
    
    public static int find(int dp[],int n,int arr[]){
        if(n==0){
            return 0;
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        int jump1 = find(dp,n-1,arr) + Math.abs(arr[n]-arr[n-1]);
        int jump2 = Integer.MAX_VALUE;
        if(n>1){
            jump2 = find(dp,n-2,arr) + Math.abs(arr[n]-arr[n-2]);
        }

        return dp[n] = Math.min(jump1,jump2); 
    }
    int minCost(int[] arr) {
        int n = arr.length;
        int dp[] = new int[n+1];
        
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        
        return find(dp,n-1,arr);
        
    }
}