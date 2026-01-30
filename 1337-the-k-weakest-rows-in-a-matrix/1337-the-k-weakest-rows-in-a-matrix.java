class Solution {
    static class Pair implements Comparable<Pair>{
        int i;
        int sol;
        int civ;

        Pair(int i,int sol,int civ){
            this.i = i;
            this.sol = sol;
            this.civ = civ;
        }

        public int compareTo(Pair p2){
            if(this.sol==p2.sol){
                return p2.i - this.i;
            }else{
                return p2.sol - this.sol;
            }
        }

    }
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq =  new PriorityQueue<>();

        for(int i=0;i<mat.length;i++){
            int sol=0;
            int civ=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    civ++;
                }else{
                    sol++;
                }
            }

            pq.add(new Pair(i,sol,civ));

            if(i>=k){
                pq.poll();
            }
        }

        int ans[] = new int[k];
        int a=ans.length-1;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            ans[a] = p.i;
            a--;
        }
        
        return ans;
    }
}