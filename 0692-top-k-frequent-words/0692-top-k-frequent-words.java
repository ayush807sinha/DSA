class Solution {
    public class Pair implements Comparable<Pair>{
        String word;
        int freq;

        Pair(String word,int freq){
            this.word =word;
            this.freq = freq;
        }

        public int compareTo(Pair p2){
            if(p2.freq==this.freq){
                return this.word.compareTo(p2.word);
            }else{
                return p2.freq - this.freq;
            }
        }

    }
    public List<String> topKFrequent(String[] arr, int k) {
        int n = arr.length;
        
        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(String key : map.keySet()){
            
            pq.add(new Pair(key,map.get(key)));
            
        }

        List<String> ans = new ArrayList<>();

        for(int i=0;i<k;i++){
            Pair p = pq.poll();
            ans.add(p.word);
        }

        return ans;




    }
}