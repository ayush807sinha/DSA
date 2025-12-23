class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map2= new HashMap();

        HashMap<Character,Integer> map1 = new HashMap();

        for(int i =0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }

        for(int i =0;i<magazine.length();i++){
            char ch = magazine.charAt(i);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        

        for(int i =0;i<ransomNote.length();i++){
            char ch = ransomNote.charAt(i);
            int count1 = map1.get(ch);
            int count2 = 0;
            if(!map2.containsKey(ch)){
                return false;
            }else{
                count2 = map2.get(ch);
                if(count2>=count1){
                    continue;
                }else{
                    return false;
                }
            }
        
        }

        return true;


    }
}