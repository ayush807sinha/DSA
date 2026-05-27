class Solution {
    int x[] = {1,-1,0,0};
    int y[] = {0,0,1,-1};

    static class Pair{
        int i;
        int j;

        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }

    boolean isValid(int i,int j,int n,int m){
       if(i <0 || i>=n || j<0 || j>=m){
            return false;
       }    
        return true;
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int time =0;    int fresh =0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fresh++;
                }else if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    grid[i][j] = -2;
                }
            }
        }

        while(!q.isEmpty() && fresh>0){
            time++;
            int size = q.size();

            while(size>0){
                Pair p = q.remove();
                int r = p.i;
                int c = p.j;

                for(int k=0;k<4;k++){
                    int row = r + x[k];
                    int col = c + y[k];
                    if(isValid(row,col,n,m) && grid[row][col] == 1){
                        q.add(new Pair(row,col));
                        grid[row][col] = -2;
                        fresh--;
                    }
                }
                size--;

            }
        }

        if(fresh>0){
            return -1;
        }else{
            return time;
        }

    }
}