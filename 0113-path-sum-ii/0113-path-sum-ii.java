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
    List<List<Integer>> res  = new ArrayList<>();

    public void find(TreeNode node,int target,List<Integer> ans,int sum){
        if(node == null){
            return;
        }

        sum = sum  + node.val;
        ans.add(node.val);
        

        if(node.left == null && node.right == null){
            if(sum == target){
                res.add(new ArrayList(ans));
            }

            ans.remove(ans.size()-1);
            
            return;
        }

        find(node.left,target,ans,sum);
        find(node.right,target,ans,sum);
        ans.remove(ans.size()-1);
        return;
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> ans = new ArrayList<>();
        find(root,targetSum,ans,0);
        return res;
    }
}