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
    ArrayList<TreeNode> ans = new ArrayList<>();

    public void find(TreeNode node){
        if(node==null){
            return;
        }

        find(node.left);
        ans.add(node);
        find(node.right);
    }


    public boolean findTarget(TreeNode root, int k) {
        find(root);
        int i =0;int j=ans.size()-1;
        
        while(i<j){
            int  val = ans.get(i).val + ans.get(j).val;

            if(val == k){
                return true;
            }else if(val > k){
                j--;
            }else{
                i++;
            }
        }

        return false;
    }
}