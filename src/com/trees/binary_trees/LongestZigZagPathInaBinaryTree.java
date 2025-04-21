package com.trees.binary_trees;

public class LongestZigZagPathInaBinaryTree {
    public static int longestPath=0;
    public static int longestZigZag(TreeNode root){
        boolean goLeft=true;
        dfs(root,goLeft,0);
        return longestPath;
    }
    public static void dfs(TreeNode node, boolean goLeft, int step){
        if(node==null){
            return ;
        }
        longestPath=Math.max(longestPath,step);
        if(goLeft){
            dfs(node.left, false,step+1);
            dfs(node.right,true,1);
        }else{
            dfs(node.left,false,1);
            dfs(node.right,true,step+1);
        }
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode one1=new TreeNode(1);
        TreeNode one2=new TreeNode(1);
        TreeNode one3=new TreeNode(1);
        TreeNode one4=new TreeNode(1);
        TreeNode one5=new TreeNode(1);
        TreeNode one6=new TreeNode(1);
        TreeNode one7=new TreeNode(1);
        root.right=one1;
        one1.left=one2;
        one1.right=one3;
        one3.left=one4;
        one3.right=one5;
        one4.right=one6;
        one6.right=one7;

        System.out.println("The longest zig zag path in a binary tree is: "+LongestZigZagPathInaBinaryTree.longestZigZag(root));
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
