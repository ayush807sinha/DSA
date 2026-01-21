class Solution {

    public int find(int n ,int dp[]){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        return dp[n] = find(n-1,dp) + find(n-2,dp);

    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];

        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }

        return find(n,dp);
    }
}