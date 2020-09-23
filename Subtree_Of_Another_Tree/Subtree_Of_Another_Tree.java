
//Definition for a binary tree node.
public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
}
 
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        
        //Check if root is similar to t or left subtree or right subtree of s is similar to t
        if(s!=null && (similar(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t))){
            return true;
        }
        return false;
    }
    
    
    //code to check if both tree are equal
    public boolean similar(TreeNode s, TreeNode t){
        //if both nodes are null then they are similar
        if(s==null && t==null)
            return true;
        //if one node is null and other is not null then they are not similar
        if(s==null || t==null)
            return false;
        //if node values are equal and subtrees are similar then t is subtree of s
        if(s.val==t.val && similar(s.left, t.left) && similar(s.right,t.right))
            return true;
        else
            return false;
    }
}
