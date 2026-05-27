class Solution {
    
    class Pair implements Comparable<Pair>{
        int d;
        int wt;
        
        Pair(int d,int wt){
            this.d=d;
            this.wt=wt;
        }
        
        public int compareTo(Pair p){
            return this.wt - p.wt;
        }
    }
    
    
    
    public int[] dijkstra(int n, int[][] edges, int src) {
        
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        
        int dist[] = new int[n];
        
        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int s = edges[i][0];
            int d = edges[i][1];
            int w = edges[i][2];
            
            graph.get(s).add(new Pair(d,w));
            graph.get(d).add(new Pair(s,w));
        }
        
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        dist[src] = 0;
        pq.add(new Pair(src,0));
        
        
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.d;
            int wt = p.wt;
            
            if(dist[node] < wt){
                continue;
            }
            
            for(int i=0;i<graph.get(node).size();i++){
                int padosi = graph.get(node).get(i).d;
                int weight = graph.get(node).get(i).wt;
                
                if(wt + weight < dist[padosi]){
                    dist[padosi] = wt+weight;
                    pq.add(new Pair(padosi,wt+weight));
                }
            }
            
        }
        
        
        return dist;
        
        
    }
}