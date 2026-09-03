class Solution {
    public List<Integer> partitionLabels(String s) {
        
        int n = s.length();

        List<Integer> ans = new ArrayList<>();

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(s.charAt(i),i);
        }

        int low = 0;
        int far = Integer.MIN_VALUE;
        for(int high=0;high<n;high++){
            
            far = Math.max(map.get(s.charAt(high)),far);

            if(high == far){
                int partLength = high-low+1;
                low = high+1;
                ans.add(partLength); 
            }

        }

        return ans;

    }
}