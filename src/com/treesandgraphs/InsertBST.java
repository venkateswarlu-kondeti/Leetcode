package com.treesandgraphs;

public class InsertBST {
    public static TreeNode insertIntoBST(TreeNode root, int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val>val){
            TreeNode leftInsert=insertIntoBST(root.left,val);
            root.left=leftInsert;
        }else{
            TreeNode rightInsert=insertIntoBST(root.right,val);
            root.right=rightInsert;
        }
        return root;
    }

    // The other accepted tree wherein we replace the input root with the val
    /*public static TreeNode insertIntoBST(TreeNode root, int val){
        TreeNode insertNode=root;
        TreeNode node=new TreeNode(val);
        node.left=root.left;
        node.right=root.right;
       return dfs(node, insertNode.val);
    }
    public static TreeNode dfs(TreeNode node, int val){
        if(node==null){
           return new TreeNode(val);
        }
        if(node.val>val){
            TreeNode leftInsert=dfs(node.left,val);
            node.left=leftInsert;
        }else{
            TreeNode rightInsert=dfs(node.right,val);
            node.right=rightInsert;
        }
        return node;
    }*/

    public static void main(String[] args){
        TreeNode root=new TreeNode(4);
        TreeNode two=new TreeNode(2);
        TreeNode one=new TreeNode(1);
        TreeNode three=new TreeNode(3);
        TreeNode seven=new TreeNode(7);
        root.left=two;
        root.right=seven;
        two.left=one;
        two.right=three;
        System.out.println("BST after insert into the BST is: "+InsertBST.insertIntoBST(root,5).right.left.val);
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
