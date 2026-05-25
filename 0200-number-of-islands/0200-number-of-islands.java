class Solution {
    int x[] = {-1,1,0,0};
    int y[] = {0,0,-1,1};


    public boolean valid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }

        return true;
    }

    public void dfs(char[][] map, int n, int m, int i, int j, boolean vis[][]) {

        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {

            int row = i + x[k];
            int col = j + y[k];

            if (valid(row, col, n, m) &&
                map[row][col] == '1' &&
                vis[row][col] == false) {

                dfs(map, n, m, row, col, vis);
            }
        }
    }


    public int numIslands(char[][] grid) {
        int res =0;
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];


        for(int i=0;i<vis.length;i++){
            for(int j=0;j<vis[0].length;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    dfs(grid,n,m,i,j,vis);
                    res++;
                }
            }
        }

        return res;
    }
}