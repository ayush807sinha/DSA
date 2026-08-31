class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length;

        if(arr.length==1){
            return;
        }

        int i=0;
        int j=0;

        for(j=0;j<n;j++){
            
            if(arr[j] == 0){
                continue;
            }else{
                arr[i] = arr[j];
                if(i!=j){
                    arr[j] = 0;
                }
                i++;
            }
        }


    }
}