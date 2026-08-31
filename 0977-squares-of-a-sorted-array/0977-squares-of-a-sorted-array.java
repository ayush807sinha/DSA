class Solution {
    public int[] sortedSquares(int[] arr) {
        
        int n = arr.length;

        int poscnt = 0;
        int negcnt = 0;

        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                poscnt++;
            }else{
                negcnt++;
            }
        }

        int pos[] = new int[poscnt];
        int neg[] = new int[negcnt];
        
        

        int i = 0;
        int j = negcnt-1;
        
        
        for(int k = 0;k<n;k++){
                
            if(arr[k]>=0){
                pos[i] = arr[k] * arr[k];
                i++;
            }else{
                neg[j] = arr[k] * arr[k];
                j--;
            }    
            
        }

        i = 0;
        j = 0;
        int k = 0;

        while(i<pos.length && j <neg.length){
            if(pos[i] <= neg[j]){
                arr[k] = pos[i];
                k++;
                i++;
            }else{
                arr[k] =  neg[j];
                k++;
                j++;
            }
        }

        while(i<pos.length){
            arr[k] = pos[i];
            i++;
            k++;
        }


        while(j<neg.length){
            arr[k] = neg[j];
            j++;
            k++;
        }

        return arr;

    }
}