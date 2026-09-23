class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;

        int low =0;
        int high =0;
        int ans =0;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(high<n){

            int i = arr[high];

            map.put(i,map.getOrDefault(i,0)+1);

            while(map.size()>2){
                int j = arr[low];
                int freq = map.get(j);

                if(freq ==1){
                    map.remove(j);
                }else{
                    map.put(j,freq-1);
                }
                low++;
            }
            


            ans = Math.max(ans,high-low+1);

            high++;
        }

        return ans;

    }
}