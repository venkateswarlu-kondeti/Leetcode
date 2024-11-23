package com.trees.binary_trees;

public class SameTree {
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p!=null && q!=null && p.val!=q.val){
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
    public static void main(String[] args){
        TreeNode pRoot=new TreeNode(1);
        TreeNode pTwo=new TreeNode(2);
        TreeNode pThree=new TreeNode(3);
        pRoot.left=pTwo;
        pRoot.right=pThree;

        TreeNode qRoot=new TreeNode(1);
        TreeNode qTwo=new TreeNode(2);
        TreeNode qThree=new TreeNode(3);
        qRoot.left=qTwo;
        qRoot.right=qThree;

        /*TreeNode pRoot=new TreeNode(1);
        TreeNode pTwo=new TreeNode(2);
        pRoot.left=pTwo;

        TreeNode qRoot=new TreeNode(1);
        TreeNode qTwo=new TreeNode(2);
        qRoot.right=qTwo;*/

        System.out.println("Same Tree? "+SameTree.isSameTree(pRoot,qRoot));
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
