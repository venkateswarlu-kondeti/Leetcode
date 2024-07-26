package com.trees;

public class SameTree {
    public static boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        boolean left=isSameTree(root1.left, root2.left);
        boolean right=isSameTree(root1.right,root2.right);
        return left && right;
    }
    public static void main(String[] args){
        TreeNode root1=new TreeNode(1);
        TreeNode two1=new TreeNode(2);
        TreeNode four1=new TreeNode(4);
        TreeNode five1=new TreeNode(5);
        TreeNode six1=new TreeNode(6);
        TreeNode three1=new TreeNode(3);
        root1.left=two1;
        two1.left=four1;
        two1.right=five1;
        five1.right=six1;
        root1.right=three1;

        TreeNode root2=new TreeNode(1);
        TreeNode two2=new TreeNode(2);
        TreeNode four2=new TreeNode(4);
        TreeNode five2=new TreeNode(5);
        TreeNode six2=new TreeNode(6);
        TreeNode three2=new TreeNode(3);
        root2.left=two2;
        two2.left=four2;
        two2.right=five2;
        five2.right=six2;
        root2.right=three2;
        System.out.println("Same Tree? "+isSameTree(root1,root2));
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
