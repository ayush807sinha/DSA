class Solution {

    public Set findPrimeFactors(int n){
        Set<Integer> ans = new HashSet();

        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                
                ans.add(i);

                while(n%i==0){
                    n=n/i;
                }

            }
        }

        if(n>1){
            ans.add(n);
        }
        return ans;

    }

    public int longestSubarray(int[] nums, int k) {
        
        HashMap<Integer,Integer> map = new HashMap<>();

        int low=0;
        int high=0;
        int ans =0;

        while(high<nums.length){
            int n = nums[high];

            Set<Integer> factors = findPrimeFactors(n);

            for(int i: factors){
                map.put(i,map.getOrDefault(i,0)+1);
            }


            if(map.size()>k){
                Set<Integer> leftFactors = findPrimeFactors(nums[low]);

                for(int p : leftFactors){
                    
                    int freq = map.get(p);

                    if(freq==1){
                        map.remove(p);
                    }else{
                        map.put(p,freq-1);
                    }

                }
                
                low++;
            }

            ans = Math.max(ans,high-low+1);
            high++;

        }

        return ans;

    }
}