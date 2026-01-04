class Solution {
    public int maxFrequencyElements(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap();

        for(int i =0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int max = 0;

        for(int freq : map.values()){
            max = Math.max(freq,max);
        }

        int ans = 0;

        for(int n :  map.values()){
            if(max==n){
                ans+=n;
            }
        }

        return ans;
    }
}