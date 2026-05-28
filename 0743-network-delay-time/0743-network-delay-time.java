class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int wt;

        Pair(int node,int wt){
            this.node =node;
            this.wt = wt;
        }

        public int compareTo(Pair p){
            return this.wt - p.wt;
        }
    }

    public int networkDelayTime(int[][] edges, int n, int k) {
        
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList());
        }
        int dist[] = new int[n];

        for(int i=0;i<n;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i=0;i<edges.length;i++){
            int s = edges[i][0];
            int d = edges[i][1];
            int wt = edges[i][2];

            graph.get(s-1).add(new Pair(d-1,wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(k-1,0));
        dist[k-1] = 0;

        while(!pq.isEmpty()){
            Pair p1 = pq.remove();
            int node = p1.node;
            int wt = p1.wt;

            if(dist[node] < wt){
                continue;
            }

            for(int i=0;i<graph.get(node).size();i++){
                int padosiNode = graph.get(node).get(i).node;
                int padosiWt = graph.get(node).get(i).wt;

                if(padosiWt + wt < dist[padosiNode]){
                    dist[padosiNode] = padosiWt + wt;
                    pq.add(new Pair(padosiNode,wt + padosiWt)); 
                }
            }

        }


        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            if(dist[i] > max){
                max = dist[i];
            }
        }

        if(max == Integer.MAX_VALUE){
            return -1;
        }

        return max;

    }
}