package com.trees;

import java.util.Stack;

public class PathSumIterative {
    public static boolean hasPathSum(TreeNode root, int targetSum){
        if(root==null){
            return false;
        }
        Stack<Pair> stack=new Stack<>();
        stack.push(new Pair(root,0));

        while(!stack.empty()){
            Pair pair=stack.pop();
            TreeNode node=pair.node;
            int curr=pair.curr;

            if(node.left==null && node.right==null){
                if((curr+node.val)==targetSum){
                    return true;
                }
            }
            curr+=node.val;
            if(node.left!=null){
                stack.push(new Pair(node.left,curr));
            }
            if(node.right!=null){
                stack.push(new Pair(node.right,curr));
            }
        }
        return false;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(5);
        TreeNode fourLeft=new TreeNode(4);
        TreeNode eleven=new TreeNode(11);
        TreeNode seven=new TreeNode(7);
        TreeNode two=new TreeNode(2);
        TreeNode eight=new TreeNode(8);
        TreeNode thirteen=new TreeNode(13);
        TreeNode fourRight=new TreeNode(4);
        TreeNode one=new TreeNode(1);

        root.left=fourLeft;
        fourLeft.left=eleven;
        eleven.left=seven;
        eleven.right=two;
        root.right=eight;
        eight.left=thirteen;
        eight.right=fourRight;
        fourRight.right=one;
        int targetSum=22;

        System.out.println("Is there a path sum? "+hasPathSum(root,targetSum));
    }
    public static class Pair{
        TreeNode node;
        int curr;
        Pair(TreeNode node, int curr){
            this.node=node;
            this.curr=curr;
        }
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
