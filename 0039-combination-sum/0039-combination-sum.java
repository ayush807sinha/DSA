class Solution {

    public static void combos(int arr[],int target,List<List<Integer>> ans,List<Integer> ds,int i){

        if(i == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[i]<=target){
            ds.add(arr[i]);
            combos(arr,target-arr[i],ans,ds,i);
            ds.remove(ds.size()-1);
        }

        combos(arr,target,ans,ds,i+1);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<Integer> ds = new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        combos(arr,target,ans,ds,0);
        return ans;
    }
}