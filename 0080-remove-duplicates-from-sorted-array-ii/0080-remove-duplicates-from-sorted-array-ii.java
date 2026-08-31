class Solution {
    public int removeDuplicates(int[] arr) {
        int n = arr.length;

        if(n==1 || n ==0){
            return n;
        }

        int i = 0;
        int j = 1;
        int k = 1;
        int ans = 1;

        for(j=1;j<n;j++){

            if(arr[i] == arr[j]){
                if(k<2){
                    i++;
                    arr[i] = arr[j];
                    ans++;
                    k++;
                    
                }else{
                    continue;
                }
            }else{
                i++;
                arr[i] = arr[j];
                k=1;
                ans++;
            }

        }

        return ans;
    }
}