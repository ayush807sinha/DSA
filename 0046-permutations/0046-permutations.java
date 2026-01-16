class Solution {
    public static void find(int arr[],HashMap<Integer,Integer> map,List<Integer> ds, List<List<Integer>> ans){
        if(map.size()==arr.length){
            ans.add(new ArrayList(ds));
            return;
        }

        for(int k =0;k<arr.length;k++){
            if(map.containsKey(arr[k])){
                continue;
            }
            map.put(arr[k],map.getOrDefault(arr[k],0)+1);
            ds.add(arr[k]);
            find(arr,map,ds,ans);
            ds.remove(ds.size()-1);
            map.remove(arr[k]);
        }

    }

    public List<List<Integer>> permute(int[] arr) {
        List<Integer> ds = new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        HashMap<Integer,Integer> map = new HashMap();

        find(arr,map,ds,ans);

        return ans;
    }
}