// User function Template for Java

class Solution {
    public int[] bellmanFord(int n, int[][] edges, int src) {
        
        int dist[] = new int[n];
        
        for(int i=0;i<n;i++){
            dist[i] = (int)1e8;
        }
        
        
        dist[src] = 0;
        
        
        for(int i=0;i<n-1;i++){
            for(int j=0;j<edges.length;j++){
                int s = edges[j][0];
                int d = edges[j][1];
                int wt = edges[j][2];
                
                if(dist[s] != (int)1e8 && dist[d] > dist[s] + wt){
                    dist[d] = dist[s]+wt;
                }
                
            }
        }
        
        for(int i=0;i<edges.length;i++){
            int s = edges[i][0];
            int d = edges[i][1];
            int wt = edges[i][2];
            
            if(dist[s] != (int)1e8 && dist[d] > dist[s] +wt){
                return new int[]{-1};
            }
            
        }
        return dist;
        
    }
}
