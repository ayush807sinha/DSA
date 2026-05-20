/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int res = 0;
    public void find(TreeNode node,int sum){
        if(node == null){
            return;
        }

        sum = sum *10 + node.val;

        if(node.left == null && node.right ==null){
            res = res+ sum;
            return;
        }

        find(node.left,sum);
        find(node.right,sum);
        return;

    }


    public int sumNumbers(TreeNode root) {
        find(root,0);
        return res;
    }
}