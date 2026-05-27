class Solution {
    boolean cycle = false;
    
    void dfs(ArrayList<ArrayList<Integer>> graph , int node , boolean vis[] ,boolean[] path){
        vis[node] =true;
        path[node] = true;
        
        for(int i=0;i<graph.get(node).size();i++){
            int padosi = graph.get(node).get(i);
            
            if(vis[padosi] == true && path[padosi] == true){
                cycle = true;
            }
            
            if(vis[padosi] == false){
                dfs(graph , padosi , vis, path);
            }
        }
        
        path[node] = false;
        return;
        
    }
    
    
    public boolean isCyclic(int n, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Integer>> graph =  new ArrayList<>();
        
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            graph.get(src).add(dest);
        }
        
        
        boolean vis[] = new boolean[n];
        boolean path[] = new boolean[n];
        
        
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                dfs(graph,i,vis,path);
            }
        }
        
        
        return cycle;
    }
}