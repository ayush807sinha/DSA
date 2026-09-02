class Solution {
    public boolean backspaceCompare(String s, String t) {

        int n=s.length();
        int m = t.length();


        int i = n-1;
        int j = m-1;

        int skip_s=0;
        int skip_t=0;


        while(i>=0 || j>=0){

            while(i>=0){
                if(s.charAt(i)=='#'){
                    skip_s++;
                    i--;
                }else if(skip_s>0){
                    skip_s--;
                    i--;
                }else{
                    break;
                }
            }


            while(j>=0){
                if(t.charAt(j)=='#'){
                    skip_t++;
                    j--;
                }else if (skip_t>0){
                    skip_t--;
                    j--;
                }else{
                    break;
                }
            }

            char first = i < 0 ? '$' : s.charAt(i);
            char second = j < 0 ? '$' : t.charAt(j);

            if(first != second){
                return false;
            }
            i--;
            j--;
        }

        return true;



    }
}