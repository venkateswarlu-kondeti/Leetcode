package com.trees;

public class InsertBSTIterative {
    public static TreeNode insertIntoBSTIterative(TreeNode root, int val){
        TreeNode node=root;
        while(node!=null){
            if(val>node.val){
                if(node.right==null){
                    node.right=new TreeNode(val);
                    return root;
                }else{
                    node=node.right;
                }
            }else{
                if(node.left==null){
                    node.left=new TreeNode(val);
                    return root;
                }else{
                    node=node.left;
                }
            }
        }
        return new TreeNode(val);
    }
    // Another accepted solution by replacing the root with the val
    /*public static TreeNode insertIntoBSTIterative(TreeNode root, int val){
        TreeNode insertNode=root;
        TreeNode newRoot=new TreeNode(val);
        newRoot.left=root.left;
        newRoot.right= root.right;
        return dfs(newRoot, insertNode.val);
    }
    public static TreeNode dfs(TreeNode newRoot, int val){
        TreeNode node=newRoot;
        while(node!=null){
            if(val>node.val){
                if(node.right==null){
                    node.right=new TreeNode(val);
                    return newRoot;
                }else{
                    node=node.right;
                }
            }else{
                if(node.left==null){
                    node.left=new TreeNode(val);
                    return newRoot;
                }else{
                    node=node.left;
                }
            }
        }
        return new TreeNode(val);
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
        System.out.println("BST after insert into the BST is: "+InsertBSTIterative.insertIntoBSTIterative(root,5).right.left.val);
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
