class Solution {
    public int maxArea(int[] arr) {
        int n = arr.length;

        int i =0 ;
        int j = n-1;
        int ans = 0;

        while(i<j){
            int w = j-i;
            int h = Math.min(arr[i],arr[j]);
            int currwater = w*h;
            ans = Math.max(currwater,ans);
            if(arr[i]<arr[j]){
                i++;
            }else{
                j--;
            }

        }

        return ans;

    }
}