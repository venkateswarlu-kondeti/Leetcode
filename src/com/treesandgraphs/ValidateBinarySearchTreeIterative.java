package com.treesandgraphs;

import java.util.Stack;

public class ValidateBinarySearchTreeIterative {
    public static boolean isValidBSTIterative(TreeNode root){
        Stack<State> stack=new Stack<>();
        stack.push(new State(root, Long.MIN_VALUE, Long.MAX_VALUE));
        while(!stack.empty()){
            State state=stack.pop();
            TreeNode node=state.node;
            long small=state.small;
            long large=state.large;
            if(small>= node.val || node.val>=large){
                return false;
            }
            if(node.left!=null){
                stack.push(new State(node.left, small, node.val));
            }
            if(node.right!=null){
                stack.push(new State(node.right, node.val, large));
            }
        }
        return true;
    }
    public static class State{
        TreeNode node;
        long small;
        long large;
        State(TreeNode node, long small, long large){
            this.node=node;
            this.small=small;
            this.large=large;
        }
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
        System.out.println("The valid binary search tree is: "+ValidateBinarySearchTreeIterative.isValidBSTIterative(root));
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
