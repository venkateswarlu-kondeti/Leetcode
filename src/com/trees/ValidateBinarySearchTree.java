package com.trees;

public class ValidateBinarySearchTree {
    public static boolean isValidBST(TreeNode root){
        return dfs(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean dfs(TreeNode node, long small, long large){
        if(node==null){
            return true;
        }
        if(small>=node.val || node.val>=large){
            return false;
        }
        boolean left=dfs(node.left,small,node.val);
        boolean right=dfs(node.right, node.val, large);
        return left && right;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(10);
        TreeNode five=new TreeNode(5);
        TreeNode two=new TreeNode(2);
        TreeNode eight=new TreeNode(8);
        TreeNode twelve=new TreeNode(12);
        TreeNode twentythree=new TreeNode(23);
        root.left=five;
        five.left=two;
        five.right=eight;
        root.right=twelve;
        twelve.right=twentythree;
        System.out.println("The valid binary search tree is: "+ValidateBinarySearchTree.isValidBST(root));
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
}
