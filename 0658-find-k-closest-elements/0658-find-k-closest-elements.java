class Solution {
    static class Pair implements Comparable<Pair>{
        int ele;
        int dist;

        Pair(int ele,int dist){
            this.ele = ele;
            this.dist = dist;
        }

        public int compareTo(Pair p2){
            if(this.dist == p2.dist){
                return p2.ele - this.ele;
            }else{
                return p2.dist - this.dist;
            }
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            int dist = Math.abs(arr[i] - x);
            pq.add(new Pair(arr[i],dist));
        }

        for(int i=k;i<arr.length;i++){
            int dist =  Math.abs(arr[i]-x);
            pq.add(new Pair(arr[i],dist));
            pq.poll();
        }
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<k;i++){
            Pair p = pq.poll();
            ans.add(p.ele);
        }

        Collections.sort(ans);

        return ans;
    }
}