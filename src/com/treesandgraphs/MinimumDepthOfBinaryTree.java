package com.treesandgraphs;

public class MinimumDepthOfBinaryTree {
    public static int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return 1+minDepth(root.right);
        }
        if(root.right==null){
            return 1+minDepth(root.left);
        }
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(3);
        TreeNode nine=new TreeNode(9);
        TreeNode twenty=new TreeNode(20);
        TreeNode fifteen=new TreeNode(15);
        TreeNode seven=new TreeNode(7);

        root.left=nine;
        root.right=twenty;
        twenty.left=fifteen;
        twenty.right=seven;

        /*TreeNode root=new TreeNode(2);
        TreeNode three=new TreeNode(3);
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        TreeNode six=new TreeNode(6);

        root.right=three;
        three.right=four;
        four.right=five;
        five.right=six;*/

        System.out.println("The minimum depth of binary tree is: "+minDepth(root));
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
