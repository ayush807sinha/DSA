class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int high =0 ;
        int low = 0;
        int res = Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();


        for(high=0 ; high<n ; high++){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);


            int k = high - low+1;

            while(map.size()<k){
                char lowch = s.charAt(low);
                map.put(lowch,map.get(lowch)-1);

                if(map.get(lowch)==0){
                    map.remove(lowch);
                }
                
                low++;
                k = high - low + 1;

            }

            k = high -low+1;
            res = Math.max(k,res);

        }

        return res;

    }
}