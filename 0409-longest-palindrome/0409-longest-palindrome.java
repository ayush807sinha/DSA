class Solution {
    public int longestPalindrome(String s) {
        if(s.length()==1){
            return 1;
        }

        HashMap<Character,Integer> map = new HashMap();
        int ans = 0;

        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        boolean flag = false;

        for(char ch : map.keySet()){
            if(map.get(ch)%2==0){
                ans = ans + map.get(ch);
            }else{
                flag = true;
            }
        }

        if(flag == false){
            return ans;
        }

        for(char ch :map.keySet()){
            if(map.get(ch)%2==1){
                ans = ans + map.get(ch) -1;
            }
        }

        return ans+1;


    }
}