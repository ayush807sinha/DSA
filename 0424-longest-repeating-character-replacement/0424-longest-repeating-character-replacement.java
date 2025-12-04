class Solution {
    public static int findMax(int arr[]){
        int maxCnt=-1;
        for(int i =0 ;i<256;i++){
            maxCnt = Math.max(maxCnt,arr[i]);
        }
        return maxCnt;
    } 
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low =0;
        int high =0;

        int res = Integer.MIN_VALUE;

        int arr[] = new int[256];

        for(int i=0;i<256;i++){
            arr[i] = 0;
        } 


        for(high =0 ;high<n;high++){
            char ch = s.charAt(high);
            
            arr[ch] = arr[ch]+1;
            int maxCnt = findMax(arr);

            int len = high - low +1;

            int diff = len - maxCnt;

            while(diff > k){
                char lowch = s.charAt(low);
                arr[lowch] = arr[lowch]-1;
                low++;

                maxCnt = findMax(arr);

                len = high - low+1;

                diff = len - maxCnt;

            }

            len = high - low +1;
            res = Math.max(res,len);

        }

        return res;



    }
}