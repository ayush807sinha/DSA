import java.util.*;

class Solution {

    public static boolean isSafe(int row, int col, int n, List<String> board) {

        int r = row;
        int c = col;

  
        while (r >= 0 && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r--;
            c--;
        }

        r = row;
        c = col;


        while (c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            c--;
        }

        r = row;
        c = col;

      
        while (r < n && c >= 0) {
            if (board.get(r).charAt(c) == 'Q') return false;
            r++;
            c--;
        }

        return true;
    }

    
    public void find(int col, List<List<String>> ans, List<String> board, int n) {

       
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for (int row = 0; row < n; row++) {

            if (isSafe(row, col, n, board)) {

                char[] arr = board.get(row).toCharArray();
                arr[col] = 'Q';
                board.set(row, new String(arr));

                find(col + 1, ans, board, n);

                
                arr[col] = '.';
                board.set(row, new String(arr));
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();

    
        for (int i = 0; i < n; i++) {
            board.add(".".repeat(n));
        }

        find(0, ans, board, n);
        return ans;
    }
}
