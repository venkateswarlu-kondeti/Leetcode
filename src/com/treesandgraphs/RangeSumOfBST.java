package com.treesandgraphs;

// 938. Range Sum of BST
public class RangeSumOfBST {
    public static int rangeSumBST(TreeNode root, int low, int high){
        if(root==null){
            return 0;
        }
        int ans=0;
        if(low<= root.val && root.val<=high){
            ans+=root.val;
        }
        if(low< root.val){
            ans+=rangeSumBST(root.left, low, high);
        }
        if(root.val<high){
            ans+=rangeSumBST(root.right,low,high);
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
        System.out.println("The range sum of BST is: "+RangeSumOfBST.rangeSumBST(root,7,15));
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
