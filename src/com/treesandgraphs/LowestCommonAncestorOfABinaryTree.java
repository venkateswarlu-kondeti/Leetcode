package com.treesandgraphs;

public class LowestCommonAncestorOfABinaryTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return null;
        }
        // first case
        if(root==p || root==q){
            return root;
        }

        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);

        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        return right;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(3);
        TreeNode five=new TreeNode(5);
        TreeNode six=new TreeNode(6);
        TreeNode two=new TreeNode(2);
        TreeNode seven=new TreeNode(7);
        TreeNode four=new TreeNode(4);
        TreeNode one=new TreeNode(1);
        TreeNode zero=new TreeNode(0);
        TreeNode eight=new TreeNode(8);
        root.left=five;
        five.left=six;
        five.right=two;
        two.left=seven;
        two.right=four;
        root.right=one;
        one.left=zero;
        one.right=eight;

        System.out.println("The lowest common anchestor is: "+lowestCommonAncestor(root,six,two).val);
        System.out.println("The lowest common anchestor is: "+lowestCommonAncestor(root,one,eight).val);
        System.out.println("The lowest common anchestor is: "+lowestCommonAncestor(root,seven,zero).val);
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
