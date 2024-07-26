package com.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumAbsoluteDifferenceInBSTIterative {
    public static int getMinimumDifferenceIterative(TreeNode root){
        List<Integer> values=iterativeInorder(root);
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<values.size();i++){
            ans=Math.min(ans,Math.abs(values.get(i)-values.get(i-1)));
        }
        return ans;
    }
    public static List<Integer> iterativeInorder(TreeNode root){
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> values=new ArrayList<>();
        TreeNode curr=root;
        while(!stack.empty() || curr!=null){
            if(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }else{
                curr=stack.pop();
                values.add(curr.val);
                curr=curr.right;
            }
        }
        return values;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(9);
        TreeNode five=new TreeNode(5);
        TreeNode one=new TreeNode(1);
        TreeNode seven=new TreeNode(7);
        TreeNode fifteen=new TreeNode(15);
        root.left=five;
        five.left=one;
        five.right=seven;
        root.right=fifteen;
        System.out.println("The minimum absolute difference in BST using iterative is: "+MinimumAbsoluteDifferenceInBSTIterative.getMinimumDifferenceIterative(root));
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
