class Solution {
    public ArrayList<Integer> topoSort(int n, int[][] edges) {
        
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        int indegree[] = new int[n];
        
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        
        for(int i=0;i<edges.length;i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            graph.get(src).add(dest);
            indegree[dest]++;  
        }
        
        ArrayList<Integer> res =  new ArrayList<>();
        
        
        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        
        while(!q.isEmpty()){
            int node = q.remove();
            res.add(node);
            
            for(int i=0;i<graph.get(node).size();i++){
                int padosi = graph.get(node).get(i);
                indegree[padosi]--;
                if(indegree[padosi] ==0){
                    q.add(padosi);
                }
            }
            
        }
        
        return res;
        
        
        
    }
}