class Solution {
    public void find(int arr[] ,int i,List<List<Integer>> ans,List<Integer> ds){
        
        ans.add(new ArrayList(ds));

        for(int k=i;k<arr.length;k++){
            if(k!=i && arr[k]== arr[k-1]){
                continue;
            }
            ds.add(arr[k]);
            find(arr,k+1,ans,ds);
            ds.remove(ds.size()-1);
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        List<Integer> ds = new ArrayList();
        List<List<Integer>> ans = new ArrayList();

        find(arr,0,ans,ds);

        return ans;
    }
}