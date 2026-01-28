class Solution {
    static class Pair implements Comparable<Pair>{
        int number;
        int freq;

        Pair(int number,int freq){
            this.number = number;
            this.freq = freq;
        }

        public int compareTo(Pair p2){
            return p2.freq - this.freq;
        }
    }


    public int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int key : map.keySet()){
            pq.add(new Pair(key,map.get(key)));
        }

        int ans[] = new int[k];

        for(int i=0;i<k;i++){
            Pair ansPair = pq.poll();
            ans[i] = ansPair.number;
        }

        return ans;
    }
}