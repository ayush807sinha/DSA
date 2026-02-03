class Solution {
    static class Pair{
        int c;
        int p;
        Pair(int c,int p){
            this.c= c;
            this.p= p;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> capPq = new PriorityQueue<>(
            (a,b) -> a.c - b.c
        );

        PriorityQueue<Pair> proPq =  new PriorityQueue<>(
            (a,b) -> b.p - a.p
        );

        for(int i=0;i<capital.length;i++){
            capPq.add(new Pair(capital[i],profits[i]));
        }

        while(k-->0){
            while(!capPq.isEmpty() && capPq.peek().c<=w){
                proPq.add(capPq.poll());
            }

            if(proPq.isEmpty()){
                return w;
            }

            w = w + proPq.poll().p;
        }

        return w;
    }
}