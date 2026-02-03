class Solution {
    static class Pair implements Comparable<Pair>{
        int freq;
        char ch;

        Pair(int freq , char ch){
            this.freq = freq;
            this.ch = ch;
        }

        public int compareTo(Pair p2){
            if(this.freq != p2.freq){
                return p2.freq - this.freq;
            }else{
                return p2.ch - this.ch;
            }
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue();

        for(char key : map.keySet()){
            int val = map.get(key);
            pq.add(new Pair(val,key));
        }

        StringBuilder res = new StringBuilder("");
        int seat = 0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            if(seat == 0 || res.charAt(seat-1)!=p.ch){
                res.append(p.ch);
                p.freq--;
                seat++;
                if(p.freq>0){
                    pq.add(p);
                }
            }else{
                if(pq.isEmpty()){
                    return "";
                }else{
                    Pair p2 = pq.poll();
                    res.append(p2.ch);
                    p2.freq--;
                    seat++;
                    if(p2.freq>0){
                        pq.add(p2);
                    }
                }
                pq.add(p);
            }
        }

        return res.toString();
    }
}