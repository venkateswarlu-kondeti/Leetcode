package com.trees.binary_trees;

public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root){
        return dfs(root.left,root.right);
    }
    public static boolean dfs(TreeNode rootL, TreeNode rootR){
        if(rootL==null && rootR==null) return true;
        if(rootL==null || rootR==null) return false;
        return (rootL.val==rootR.val) &&
                dfs(rootL.left,rootR.right) &&
                dfs(rootL.right,rootR.left);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode twoL=new TreeNode(2);
        TreeNode threeL=new TreeNode(3);
        TreeNode fourL=new TreeNode(4);
        TreeNode twoR=new TreeNode(2);
        TreeNode threeR=new TreeNode(3);
        TreeNode fourR=new TreeNode(4);
        root.left=twoL;
        twoL.left=threeL;
        twoL.right=fourL;
        root.right=twoR;
        twoR.left=fourR;
        twoR.right=threeR;
        System.out.println("Is symmetric tree? "+SymmetricTree.isSymmetric(root));
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val=val;
        }
        TreeNode(int val,TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
}
