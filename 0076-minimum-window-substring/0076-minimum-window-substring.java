class Solution {

    public boolean sahi(int have[],int needed[]){
        for(int i=0;i<256;i++){
            if(have[i]<needed[i]){
                return false;
            }
        }

        return true;
    }

    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0){
            return "";
        }
        int high =0;
        int low =0;
        int res =Integer.MAX_VALUE;
        int n=s.length();
        int start=-1;

        int have[] = new int[256];
        int needed[] = new int[256];

        for(int i=0;i<256;i++){
            have[i]=0;
            needed[i]=0;
        }

        for(int i=0;i<t.length();i++){
            char ch = t.charAt(i);
            needed[ch] += 1; 
        }

        for(high=0;high<n;high++){

            char ch=s.charAt(high);
            have[ch] += 1;

            while(sahi(have,needed)){
                char lowch = s.charAt(low);
                int len = high -low+1;
                if(res > len){
                    res = len;
                    start = low;
                }

                have[lowch]--;
                low++;

            }

        }

        return (res == Integer.MAX_VALUE)? "" : s.substring(start,start + res);

    }
}