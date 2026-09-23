class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        int low =0;
        int high = 0;
        int n = s.length();
        int ans =0;
        while(high<n){
            
            char ch = s.charAt(high);

            map.put(ch,map.getOrDefault(ch,0)+1);

            while(map.get(ch) > 1){
                char cl = s.charAt(low);
                if(map.get(cl)==1){
                    map.remove(cl);
                }else{
                    int freq = map.get(cl);
                    map.put(cl,freq-1);
                }
                low++;
            }
            
            ans = Math.max(ans,high-low+1);

            high++;
        }
    
    
        return ans;
    
    } 
}