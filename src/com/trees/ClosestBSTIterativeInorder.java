package com.trees;

import java.util.LinkedList;

public class ClosestBSTIterativeInorder {
    public static int closestValueIterativeInorder(TreeNode root, double target){
        LinkedList<TreeNode> stack=new LinkedList<>();
        long pred=Long.MIN_VALUE;
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.add(root);
                root=root.left;
            }
            root=stack.removeLast();
            if(pred<=target && target<root.val){
                return Math.abs(pred-target)<=Math.abs(root.val-target)? (int)pred : root.val;
            }
            pred= root.val;;
            root=root.right;
        }
        return (int)pred;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(4);
        TreeNode two=new TreeNode(2);
        TreeNode one=new TreeNode(1);
        TreeNode three=new TreeNode(3);
        TreeNode five=new TreeNode(5);
        root.left=two;
        root.right=five;
        two.left=one;
        two.right=three;
        System.out.println("The closest binary search tree value is: "+ClosestBSTIterativeInorder.closestValueIterativeInorder(root,3.714286));
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
