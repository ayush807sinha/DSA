/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    static TreeNode ans = null;
    public static void find(TreeNode node,TreeNode p,TreeNode q){
         if(node == null){
            return;
        }

        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);

        if(node.val < min){
            find(node.right, p, q);
        }
        else if(node.val > max){
            find(node.left, p, q);
        }
        else{
            ans = node;
            return;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        find(root,p,q);
        return ans;
    }
}