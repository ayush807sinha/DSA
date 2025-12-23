class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        String b = "balloon";
        int ans = Integer.MAX_VALUE;
        HashMap<Character,Integer> map = new HashMap();
        HashMap<Character,Integer> bmap = new HashMap();

        for(int i =0;i<n;i++){
            char ch = text.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        for(int i =0;i<b.length();i++){
            char ch = b.charAt(i);
            bmap.put(ch,bmap.getOrDefault(ch,0)+1);
        }


        for(char ch : bmap.keySet()){
            if(map.containsKey(ch)){
                int count = map.get(ch)/bmap.get(ch);
                ans = Math.min(ans,count);
            }else{
                ans = 0;
            }
        }

        return ans;
        
    }
}