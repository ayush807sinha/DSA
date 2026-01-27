class Solution {
    public int minFallingPathSum(int[][] map) {
        int n = map.length;
        int m = map[0].length;

        int dp[][] = new int[n][m];

        for(int j=0;j<m;j++){
            dp[0][j] = map[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up = map[i][j] + dp[i-1][j];

                int leftUp = Integer.MAX_VALUE;
                if(j-1 >= 0){
                    leftUp = map[i][j] + dp[i-1][j-1];
                }

                int rightUp = Integer.MAX_VALUE;
                if(j+1 < m){
                    rightUp = map[i][j] + dp[i-1][j+1];
                }

                dp[i][j] = Math.min(up, Math.min(leftUp, rightUp));
                
            }
        }

        int ans =  Integer.MAX_VALUE;

        for(int j=0;j<m;j++){
            ans = Math.min(ans,dp[n-1][j]);
        }

        return ans;

    }
}