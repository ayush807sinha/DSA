class Solution {
    public int[] intersection(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;

        Arrays.sort(a);
        Arrays.sort(b);

        ArrayList<Integer> ans = new ArrayList<>();

        int i=0;
        int j=0;

        while(i<n && j<m){
		    
		    if(a[i]==b[j]){
		        if(ans.size()==0 || ans.get(ans.size()-1) != a[i]){
		            ans.add(a[i]);
		        }
		        i++;
		        j++;
		    }
		    else if(a[i]<b[j]){
		        i++;
		    }else{
		        j++;
		    }
		    
		}

        int arr[] = new int[ans.size()];

        for(int k=0;k<arr.length;k++){
            arr[k] = ans.get(k);
        }

        return arr;


    }
}