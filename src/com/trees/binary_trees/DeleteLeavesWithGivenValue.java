package com.trees.binary_trees;

public class DeleteLeavesWithGivenValue {
    public static TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root.val==target && root.left==null && root.right==null){
            return null;
        }
        dfs(root, target);
        return (root.val==target && root.left==null && root.right==null)? null: root;
    }
    public static void dfs(TreeNode node, int target){
        if(node==null){
            return;
        }
        dfs(node.left, target);
        if(node.left!=null && node.left.val==target && node.left.left==null && node.left.right==null){
            node.left=null;
        }
        dfs(node.right,target);
        if(node.right!=null && node.right.val==target && node.right.left==null && node.right.right==null){
            node.right=null;
        }
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode two1=new TreeNode(2);
        TreeNode two2=new TreeNode(2);
        TreeNode three=new TreeNode(3);
        TreeNode two3=new TreeNode(2);
        TreeNode four=new TreeNode(4);
        root.left=two1;
        two1.left=two2;
        root.right=three;
        three.left=two3;
        three.right=four;
        System.out.println("The root after deleted nodes is: "+DeleteLeavesWithGivenValue.removeLeafNodes(root,2).right.val);
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode( int val){
            this.val=val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
}
