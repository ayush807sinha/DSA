class Solution {
    class Pair implements Comparable<Pair>{
        int dist;
        int row;
        int col;

        Pair(int dist,int row,int col){
            this.dist = dist;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Pair p2){
            return this.dist - p2.dist;
        }
    }

    boolean valid(int i,int j,int n,int m){
        if(i<0 || i>=n || j<0 || j>=m){
            return false;
        }
        return true;
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int res[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                res[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        res[0][0] = 0;
        pq.add(new Pair(0,0,0));

        int x[] = {0,0,1,-1};
        int y[] = {1,-1,0,0};

        while(!pq.isEmpty()){
            Pair p1 = pq.remove();
            int dist = p1.dist;
            int row = p1.row;
            int col = p1.col;

            if(dist > res[row][col]){
                continue;
            }

            for(int i=0;i<4;i++){
                int r = row + x[i];
                int c = col + y[i];

                if(!valid(r,c,n,m)){
                    continue;
                }

                int absdiff = Math.abs(heights[row][col] - heights[r][c]);
                int newwt = Math.max(absdiff,dist);

                if(newwt < res[r][c]){
                    res[r][c] = newwt;
                    pq.add(new Pair(newwt , r,c));
                }

            }

        }

        return res[n-1][m-1];

    }
}