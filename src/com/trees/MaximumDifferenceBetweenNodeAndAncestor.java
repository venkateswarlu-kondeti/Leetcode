package com.trees;

public class MaximumDifferenceBetweenNodeAndAncestor {
    public static int maxAncestorDiff(TreeNode root){
        if(root==null){
            return 0;
        }
        return helper(root, root.val, root.val);
    }
    public static int helper(TreeNode root, int currMax, int currMin){
        if(root==null){
            return Math.abs(currMax-currMin);
        }
        currMax=Math.max(currMax,root.val);
        currMin=Math.min(currMin,root.val);
        int left=helper(root.left,currMax,currMin);
        int right=helper(root.right,currMax,currMin);
         return Math.max(left,right);
    }


    //----------------------------My solution after understanding the editorial----------------------------------------------------
    /*public static int result;
    public static int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = 0;
        helper(root, root.val, root.val);
        return result;
    }
    public static void helper(TreeNode root, int currMax, int currMin){
        if(root==null){
            result = Math.max(result, Math.abs(currMax - currMin));
            return;
        }
        currMax=Math.max(currMax,root.val);
        currMin=Math.min(currMin,root.val);
        helper(root.left,currMax,currMin);
        helper(root.right,currMax,currMin);
        return;
    }*/
    public static void main(String[] args){
        TreeNode root=new TreeNode(8);
        TreeNode three=new TreeNode(3);
        TreeNode one=new TreeNode(1);
        TreeNode six=new TreeNode(6);
        TreeNode four=new TreeNode(4);
        TreeNode seven=new TreeNode(7);
        TreeNode ten=new TreeNode(10);
        TreeNode fourteen=new TreeNode(14);
        TreeNode thirteen=new TreeNode(13);

        root.left=three;
        three.left=one;
        three.right=six;
        six.left=four;
        six.right=seven;
        root.right=ten;
        ten.right=fourteen;
        fourteen.left=thirteen;

        /*TreeNode root=new TreeNode(1);
        TreeNode two=new TreeNode(2);
        TreeNode zero=new TreeNode(0);
        TreeNode three=new TreeNode(3);

        root.right=two;
        two.right=zero;
        zero.left=three;*/

        System.out.println("The maximum difference between Node and Ancestor is "+maxAncestorDiff(root));
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
