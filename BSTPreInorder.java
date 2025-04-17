// we use inLeft, inRight, preLeft, preRight
// to optimise we do inorder traversal inside hashmap
// get root from preorder and then left of root is left subtree and right of root is right subtree.
// Time : O(n)
// Space : O(n) for hashmap

import java.util.*;

class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.map = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.idx = 0;

        return helper(preorder, 0, preorder.length - 1);
        
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        // base case

        if(start > end) return null;

        int rootVal = preorder[idx];
        idx++;

        int rootIdx = map.get(rootVal);

        TreeNode root = new TreeNode(rootVal);

        root.left = helper(preorder, start, rootIdx - 1);
        root.right = helper(preorder,rootIdx + 1, end);

        return root;
    }
}