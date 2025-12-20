class Solution {
    public boolean checkanagram(int arr1[],int arr2[]){
        for(int i =0;i<26;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;

        int window = s1.length();

        int freq1[]= new int [26];

        int freq2[] = new int [26];
        for(int i =0;i<26;i++){
            freq1[i]=0;
            freq2[i]=0;
        }

        for(int i =0;i<s1.length();i++){
            freq1[s1.charAt(i)-'a']++;
        }

        for(int i =0;i<window;i++){
            freq2[s2.charAt(i)-'a']++;
        }

        if(checkanagram(freq1,freq2)){
            return true;
        }
        
        for(int i=window;i<s2.length();i++){
            freq2[s2.charAt(i)-'a']++;
            freq2[s2.charAt(i-window)-'a']--;

            if(checkanagram(freq1,freq2)){
                return true;
            }
        }

        return false;

    }
}