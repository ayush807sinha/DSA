class Solution {
    public boolean checkAnagram(int arr1[],int arr2[]){
        for(int i =0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(p.length()>s.length()){
            return ans;
        }
        
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        int window = p.length();

        int high = window-1;
        int low =0;

        for(int i=0;i<26;i++){
            freq1[i]=0;
            freq2[i]=0;
        }

        
        for(int i=0;i<p.length();i++){
            freq1[p.charAt(i)-'a']++;
        }

        for(int i=low;i<=high;i++){
            freq2[s.charAt(i)-'a']++;
        }

        if(checkAnagram(freq1,freq2)){
            ans.add(low);
        }
        
        for(high =high+1;high<s.length();high++){
            freq2[s.charAt(low)-'a']--;
            freq2[s.charAt(high)-'a']++;
            low++;
            if(checkAnagram(freq1,freq2)){
                ans.add(low);
            }
        }

        return ans;
    }
}