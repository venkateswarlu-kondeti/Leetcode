package com.trees.binary_search_trees;

public class DeleteNodeInBST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;
        }
        if(key>root.val){
            root.right=deleteNode(root.right,key);
        } else if (key< root.val) {
            root.left=deleteNode(root.left,key);
        }else{
            if(root.left==null && root.right==null){
                root=null;
            } else if (root.right!=null) {
                root.val=successor(root);
                root.right=deleteNode(root.right, root.val);
            }else{
                root.val=predecessor(root);
                root.left=deleteNode(root.left,root.val);
            }
        }
        return root;
    }
    public static int successor(TreeNode node){
        node=node.right;
        while(node.left!=null){
            node=node.left;
        }
        return node.val;
    }
    public static int predecessor(TreeNode node){
        node=node.left;
        while(node.right!=null){
            node=node.right;
        }
        return node.val;
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(5);
        TreeNode three=new TreeNode(3);
        TreeNode two=new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode six=new TreeNode(6);
        TreeNode seven=new TreeNode(7);
        root.left=three;
        three.left=two;
        three.right=four;
        root.right=six;
        six.right=seven;
        int key=3;
        System.out.println("The deleted node in a BST is: "+DeleteNodeInBST.deleteNode(root,key));
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
