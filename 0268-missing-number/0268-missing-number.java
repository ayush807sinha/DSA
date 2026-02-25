class Solution {
    public int missingNumber(int[] arr) {
        int n = arr.length;

        HashSet<Integer> set = new HashSet<>();
        
        int ans =0;

        for(int i=0;i<n;i++){
            set.add(arr[i]);
        } 


        for(int i=0;i<=n;i++){
            if(!set.contains(i)){
                ans = i;
            }
        }

        return ans;



    }
}