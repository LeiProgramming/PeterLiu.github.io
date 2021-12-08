
package com.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Peter
 */
public class Binary_Tree_Inorder_Traversal_94 {

}

/**
 * Definition for a binary tree node.
 */
@SuppressWarnings("all")
class TreeNode {
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
@SuppressWarnings("all")
class Solution01 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    public void inOrder(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}

@SuppressWarnings("all")
class Solution02 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        list.add(node.val);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }
}

@SuppressWarnings("all")
class Solution03 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    public void postOrder(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        postOrder(node.right, list);
        postOrder(node.left, list);
        list.add(node.val);
    }
}