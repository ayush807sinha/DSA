class Solution {
    public int minimumTotal(List<List<Integer>> map) {
        int n = map.size();

        int dp[][]=new int [n][n];

        for(int i=0;i<n;i++){
            dp[n-1][i] = map.get(n-1).get(i);
        }

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                int down = map.get(i).get(j) + dp[i+1][j];
                int diagonal =  map.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down,diagonal);
            }
        }

        return dp[0][0];

    }
}