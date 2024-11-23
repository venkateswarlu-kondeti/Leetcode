package com.trees.binary_trees;

public class InvertBinaryTree {
    public static TreeNode invertTree(TreeNode root){
        if(root==null){
            return null;
        }
        TreeNode left=invertTree(root.left);
        TreeNode right=invertTree(root.right);
        root.left=right;
        root.right=left;
        return root;
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(4);
        TreeNode two=new TreeNode(2);
        TreeNode one=new TreeNode(1);
        TreeNode three=new TreeNode(3);
        TreeNode seven=new TreeNode(7);
        TreeNode six=new TreeNode(6);
        TreeNode nine=new TreeNode(9);
        root.left=two;
        two.left=one;
        two.right=three;
        root.right=seven;
        seven.left=six;
        seven.right=nine;
        System.out.println("The inverted binary tree is: "+InvertBinaryTree.invertTree(root).left.val);
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
