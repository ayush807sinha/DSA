class Solution {
    
    int x[] = {1,-1,0,0};
    int y[] = {0,0,1,-1};

    class Pair{
        int row;
        int col;

        Pair(int row,int col){
     
            this.row = row;
            this.col = col;
        }

    }

    boolean valid(int i,int j ,int n,int m){
        if(i<0 || i>=n || j<0 ||j>=m){
            return false;
        }
        return true;
    }

    boolean bfs(int [][]grid,int n,int m,int guess){
        int vis[][] = new int [n][m];
        Queue<Pair> q = new LinkedList<>();;
        q.add(new Pair(0,0));
        vis[0][0] = 1;

        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col  =p.col;

            if(row == n-1 && col ==m-1){
                return true;
            }

            for(int i=0;i<4;i++){
                int r = row + x[i];
                int c = col + y[i];

                if(valid(r,c,n,m) && vis[r][c] == 0 && guess >= grid[r][c]){
                    q.add(new Pair(r,c));
                    vis[r][c] = 1;
                }

            }

        }
         
        return false;


    }


    public int swimInWater(int[][] grid) {
        int x[] = {1,-1,0,0};
        int y[] = {0,0,1,-1};
        int n = grid.length;
        int m = grid[0].length;
        int low = grid[0][0];
        int res=0;

        int high = grid[0][0];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                high = Math.max(high,grid[i][j]);
            }
        }


        while(low <= high){
            int guess = (low + high)/2;

            if(bfs(grid,n,m,guess)){
                res = guess;
                high = guess -1;
            }else{
                low = guess +1;
            }
        }


        return res;



    }
}