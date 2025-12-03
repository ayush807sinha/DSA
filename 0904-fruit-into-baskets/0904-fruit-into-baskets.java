class Solution {
    public int totalFruit(int[] fruits) {

        int basket = 2;
        int n = fruits.length;
    
        int high = 0;
        int low = 0;
        int res =0;

        Map<Integer,Integer> map = new HashMap<>();
 
        for(high =0; high < n ;high++){

            int key = fruits[high];
            map.put(key,map.getOrDefault(key,0)+1);


            while(map.size()>basket){
                int key2 = fruits[low];
                map.put(key2,map.get(key2)-1);

                if(map.get(key2)==0){
                    map.remove(key2);
                }

                low++;

            }

            if(map.size()== basket || map.size()<basket){

                int len = high-low+1;
                res = Math.max(res,len);

            }


        }

        return res;

    
    }
}