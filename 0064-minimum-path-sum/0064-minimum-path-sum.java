class Solution {
    public static int find(int map[][],int dp[][],int row,int col){
        if(row>=map.length || col>=map[0].length){
            return Integer.MAX_VALUE;
        }
        if(row ==map.length-1 && col==map[0].length-1){
            return map[row][col];
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int right = find(map,dp,row,col+1);
        int down = find(map,dp,row+1,col);

        return dp[row][col] = map[row][col]+Math.min(right,down);
    }

    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int dp[][] = new int[row][col];

        for(int i=0;i < row;i++){
            for(int j=0;j < col;j++){
                dp[i][j] = -1;
            }
        }
        
        return find(grid,dp,0,0);

        
    }
}