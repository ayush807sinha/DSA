class Solution {
    public class Pair{
        char first;
        int second;

        Pair(char first, int second){
            this.first = first;
            this.second = second;
        }

    }
    public String removeDuplicates(String s, int k) {
        int n = s.length();

        Stack<Pair> st = new Stack();

        for(int i=0;i<n;i++){

            char ch= s.charAt(i);

            if(st.isEmpty() || st.peek().first != ch){
                st.push(new Pair(ch,1));
            }else if (st.peek().second < (k-1)){
                char c = st.peek().first;
                int freq = st.peek().second;
                st.pop();
                st.push(new Pair(c,freq+1));
            }else{
                st.pop();
            }

        }
        
        StringBuilder str = new StringBuilder();

        while(!st.isEmpty()){
            Pair p = st.pop();

            for(int i =0;i<p.second;i++){
                str.append(p.first);
            }
        }

        return str.reverse().toString();

        

    }
}