class Solution {
    public static double findDist(int x,int y){
        return Math.sqrt((x*x) + (y*y));
    }

    public static class Pair implements Comparable<Pair>{
        double dist;
        int i;
        int j;

        Pair(double dist,int i,int j){
            this.dist=dist;
            this.i=i;
            this.j=j;
        }

        public int compareTo(Pair p2){
            return Double.compare(p2.dist, this.dist);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i=0;i<k;i++){
            int x = points[i][0];
            int y = points[i][1];
            double dist = findDist(x,y);
            pq.add(new Pair(dist,x,y));
        }


        for(int i=k;i<points.length;i++){
            int x=points[i][0];
            int y=points[i][1];
    
            double dist = findDist(x,y);
            pq.add(new Pair(dist,x,y));
            pq.poll();
        }

        int ans [][]= new int[k][2];

        for(int i=0;i<k;i++){
            Pair p = pq.poll();
            ans[i][0] = p.i;
            ans[i][1] = p.j;
        }

        return ans;
    }
}