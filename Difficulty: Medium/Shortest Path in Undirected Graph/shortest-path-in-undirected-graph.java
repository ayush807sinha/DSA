class Solution {
    class Pair{
        int src;
        int dist;
        
        Pair(int src,int dist){
            this.src = src;
            this.dist = dist;
        }
    }
    
    
    
    public int[] shortestPath(int n, int[][] edges, int src) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        boolean vis[] = new boolean[n];
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int source = edges[i][0];
            int distance = edges[i][1];
            graph.get(source).add(distance);
            graph.get(distance).add(source);
        }
        
        Queue<Pair> q = new LinkedList<>();
        int res[] = new int[n];
        
        q.add(new Pair(src,0));
        vis[src] = true;
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            
            int node = p.src;
            int distance = p.dist;
            
            res[node] = distance;
            
            
            for(int i=0;i<graph.get(node).size();i++){
                int padosi = graph.get(node).get(i);
                
                if(vis[padosi] == false){
                    q.add(new Pair(padosi,distance +1));
                    vis[padosi] = true;
                }
            }
            
        }
        
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                res[i] = -1;
            }
        }
        
        return res;
        
        
        
    }
}
