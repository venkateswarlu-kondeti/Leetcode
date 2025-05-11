package com.trees.binary_search_trees;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorOfBinarySearchTree {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val<root.val && q.val<root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    //-----------------Iterative approach---------------------------------------------

    /*public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(p.val> root.val && q.val> root.val){
                root=root.right;
            } else if (p.val< root.val && q.val<root.val) {
                root=root.left;
            }else{
                return root;
            }
        }
        return null;
    }*/

    //-------------------------My Method------------------------------------------------
    /*public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if((root.val>p.val && root.val<q.val)||(root.val<p.val && root.val>q.val)){
                return root;
            }
            if(root.val==p.val || root.val==q.val){
                return  root;
            }
            root=root.val>Math.max(p.val,q.val) ? root.left : root.right;
        }
        return null;
    }*/

    public static void main(String[] args){
        TreeNode root=new TreeNode(6);
        TreeNode two=new TreeNode(2);
        TreeNode eight=new TreeNode(8);
        TreeNode zero=new TreeNode(0);
        TreeNode four=new TreeNode(4);
        TreeNode three=new TreeNode(3);
        TreeNode five=new TreeNode(5);
        TreeNode seven=new TreeNode(7);
        TreeNode nine=new TreeNode(9);
        root.left=two;
        root.right=eight;
        two.left=zero;
        two.right=four;
        four.left=three;
        four.right=five;
        eight.left=seven;
        eight.right=nine;
        TreeNode p=new TreeNode(2);
        TreeNode q=new TreeNode(8);
        System.out.println("The LCA of BST is: "+LowestCommonAncestorOfBinarySearchTree.lowestCommonAncestor(root, p, q));
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
