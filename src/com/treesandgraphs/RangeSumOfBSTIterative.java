package com.treesandgraphs;

import java.util.Stack;

public class RangeSumOfBSTIterative {
    public static int rangeSumBSTIterative(TreeNode root, int low, int high){
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        int ans=0;
        while(!stack.empty()){
            TreeNode node=stack.pop();
            if(low<= node.val && node.val<=high){
                ans+=node.val;
            }
            if(node.left!=null && low<node.val){
                stack.push(node.left);
            }
            if(node.right!=null && node.val<high){
                stack.push(node.right);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(10);
        TreeNode five=new TreeNode(5);
        TreeNode three=new TreeNode(3);
        TreeNode seven=new TreeNode(7);
        TreeNode fifteen=new TreeNode(15);
        TreeNode eighteen=new TreeNode(18);
        root.left=five;
        five.left=three;
        five.right=seven;
        root.right=fifteen;
        fifteen.right=eighteen;
        System.out.println("The range sum of BST is: "+RangeSumOfBSTIterative.rangeSumBSTIterative(root,7,15));
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
