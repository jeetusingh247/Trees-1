// root can be from -infinity to +infinity
// leftsubtree --> min --> same, max --> root.val
// rightsubtree --> min --> root.val, max --> same
// if root.val <= min or root.val >= max, return false
// if root == null, return true

// Time : O(n)
// Space : O(h)


import java.util.*;

class Solution {
    boolean flag;
    public boolean isValidBST(TreeNode root) {
        this.flag = true;
        helper(root, null, null);
        return flag;
    }

    private void helper(TreeNode root, Integer min, Integer max) {
        if(root == null) return;

        if(min != null && root.val <= min) {
            flag = false;
        }

        if(max != null && root.val >= max){
            flag = false;
        }

        helper(root.left, min, root.val);

        helper(root.right, root.val, max);
    }
}