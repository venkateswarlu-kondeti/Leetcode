package com.treesandgraphs;

public class DiameterOfABinaryTree {
    public static int longestPath;
    public static int diameterOfBinaryTree(TreeNode root){
        longestPath=0;
        dfs(root);
        return longestPath;
    }
    public static int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=dfs(node.left);
        int right=dfs(node.right);
        longestPath=Math.max(longestPath, left+right);
        return 1+Math.max(left,right);
    }
    public static void main(String[] args){
        /*TreeNode root=new TreeNode(1);
        TreeNode two=new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        TreeNode three=new TreeNode(3);
        root.left=two;
        two.left=four;
        two.right=five;
        root.right=three;
        System.out.println("The longest path between two nodes is: "+DiameterOfABinaryTree.diameterOfBinaryTree(root));*/

        /*TreeNode root=new TreeNode(1);
        TreeNode two=new TreeNode(2);
        root.left=two;
        System.out.println("The longest path between two nodes is: "+DiameterOfABinaryTree.diameterOfBinaryTree(root));*/

        /*TreeNode root=new TreeNode(1);
        System.out.println("The longest path between two nodes is: "+DiameterOfABinaryTree.diameterOfBinaryTree(root));*/

        TreeNode root=new TreeNode(2);
        TreeNode three=new TreeNode(3);
        TreeNode one=new TreeNode(1);
        root.left=three;
        three.left=one;
        System.out.println("The longest path between two nodes is: "+DiameterOfABinaryTree.diameterOfBinaryTree(root));
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
