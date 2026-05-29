class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int wt;
        
        Pair(int node,int wt){
            this.wt = wt;
            this.node = node;
        }
        
        @Override
        public int compareTo(Pair p2){
            return this.wt - p2.wt;
        }
    }
    
    
    public int spanningTree(int n, int[][] edges) {
        ArrayList<ArrayList<Pair>> graph =  new ArrayList<>();
        int sum=0;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            int wt = edges[i][2];
            
            graph.get(src).add(new Pair(dest,wt));
            graph.get(dest).add(new Pair(src,wt));
        }
        
        int vis[]= new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        
        while(!pq.isEmpty()){
            Pair p1 = pq.remove();
            int node = p1.node;
            int wt = p1.wt;
            
            if(vis[node] == 1){
                continue;
            }
            
            vis[node] =1;
            sum = sum+wt;
            
            for(int i=0;i<graph.get(node).size();i++){
                int padosi = graph.get(node).get(i).node;
                int pwt = graph.get(node).get(i).wt;
                
                if(vis[padosi] == 0){
                    pq.add(new Pair(padosi,pwt));
                }
                
            }
            
        }
        
        return sum;
        
        
    }
}
