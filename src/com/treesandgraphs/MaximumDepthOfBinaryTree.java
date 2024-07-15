package com.treesandgraphs;



public class MaximumDepthOfBinaryTree {
    public static int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(0);
        TreeNode one=new TreeNode(1);
        TreeNode two=new TreeNode(2);
        TreeNode three=new TreeNode(3);
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        TreeNode six=new TreeNode(6);

        root.left=one;
        one.left=three;
        one.right=four;
        root.right=two;
        two.right=five;
        five.right=six;

        System.out.println("The maximum depth of binary tree is: "+maxDepth(root));
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
