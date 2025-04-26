package com.trees.binary_search_trees;

import java.util.LinkedList;
import java.util.Queue;

public class SearchInaBinarySearchTree {
    public static TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val==val){
            return root;
        }
        return val< root.val ? searchBST(root.left, val) : searchBST(root.right, val);

        //----------------------------Another solution--------------------------------

        /*while(root!=null && root.val!=val){
            root=val< root.val ? root.left : root.right;
        }
        return root;*/

        //------------------------------My Solution----------------------------------
        /*Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        TreeNode node;
        while(!queue.isEmpty()){
            node=queue.poll();
            if(node.val==val){
                return node;
            }
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return null;*/
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(4);
        TreeNode two=new TreeNode(2);
        TreeNode seven=new TreeNode(7);
        TreeNode one=new TreeNode(1);
        TreeNode three=new TreeNode(3);
        root.left=two;
        root.right=seven;
        two.left=one;
        two.right=three;
        int val=2;
        System.out.println("The search in a Binary Search Tree is: "+SearchInaBinarySearchTree.searchBST(root,val));
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val) {
            this.val=val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
           this.val=val;
           this.left=left;
           this.right=right;
        }
    }
}
