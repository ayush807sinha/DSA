class Solution {
    public int getSecondLargest(int[] arr) {
        int n = arr.length;
        
        int max = -1;
        int secondmax = -1;
        
        
        for(int i=0;i<n;i++){
		    if(arr[i]>max){
		        max = arr[i];
		    }
		}
		
		
		
		for(int i=0;i<n;i++){
		    if(arr[i]>secondmax && arr[i]<max){
		        secondmax = arr[i];
		    }
		}
        
        
        return secondmax;
    }
}