package com.trees;

import java.util.Stack;

public class MaximumDepthOfBinaryTreeIterative {
    public static int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }

        Stack<Pair> stack=new Stack<>();
        stack.push(new Pair(root,1));
        int ans=0;

        while(!stack.empty()){
            Pair pair=stack.pop();
            TreeNode node=pair.node;
            int depth=pair.depth;

            ans=Math.max(ans,depth);
            if(node.left!=null){
                stack.push(new Pair(node.left,depth+1));
            }
            if(node.right!=null){
                stack.push(new Pair(node.right, depth+1));
            }
        }
        return ans;
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

        System.out.println("The maximum depth of binary tree using stack is: "+maxDepth(root));
    }
    public static class Pair{
        TreeNode node;
        int depth;
        Pair(TreeNode node, int depth){
            this.node=node;
            this.depth=depth;
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
