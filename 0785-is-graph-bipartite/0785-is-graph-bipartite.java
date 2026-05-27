class Solution {
    boolean res = true;

    void dfs(int graph[][],int colors[],int c,int node){
        colors[node] = c;

        for(int i=0;i<graph[node].length;i++){
            int padosi = graph[node][i];

            if(colors[padosi] != -1 && colors[padosi] == c){
                res = false;
            }

            if(colors[padosi] == -1){
                dfs(graph,colors,1-c,padosi);
            }

        }

    }


    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int colors[] = new int[n];

        for(int i=0;i<n;i++){
            colors[i] = -1;
        }


        for(int i=0;i<n;i++){
            if(colors[i] == -1){
                dfs(graph,colors,0,i);
            }
        }

        return res;
    }
}