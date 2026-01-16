class Solution {
    public static void find(int arr[],List<Integer> ds,List<List<Integer>> ans,int target,int i){
        if(target==0){
            ans.add(new ArrayList(ds));
            return;
        }

        for(int k=i;k<arr.length;k++){
            if(k>i && arr[k]==arr[k-1]){
                continue;
            }
            if(arr[k]>target){
                break;
            }
            ds.add(arr[k]);
            find(arr,ds,ans,target-arr[k],k+1);
            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        List<Integer> ds = new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        find(arr,ds,ans,target,0);
        return ans; 
    }
}