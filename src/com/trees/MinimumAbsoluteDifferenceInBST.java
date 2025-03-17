package com.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {
    public static List<Integer> valList;
    public static int getMinimumDifference(TreeNode root){
        valList=new ArrayList<>();
        dfs(root);
        Collections.sort(valList);
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<valList.size();i++){
            ans=Math.min(ans,Math.abs(valList.get(i)-valList.get(i-1)));
        }
        return ans;
    }
    public static void dfs(TreeNode node){
        if(node==null){
            return;
        }
        valList.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
    public static void main(String[] args){
        /*TreeNode root=new TreeNode(9);
        TreeNode five=new TreeNode(5);
        TreeNode one=new TreeNode(1);
        TreeNode seven=new TreeNode(7);
        TreeNode fifteen=new TreeNode(15);
        root.left=five;
        five.left=one;
        five.right=seven;
        root.right=fifteen;*/

        TreeNode root=new TreeNode(4);
        TreeNode two=new TreeNode(2);
        TreeNode one=new TreeNode(1);
        TreeNode three=new TreeNode(3);
        TreeNode six =new TreeNode(6);
        root.left=two;
        two.left=one;
        two.right=three;
        root.right= six;
        System.out.println("The minimum absolute difference of BST is: "+MinimumAbsoluteDifferenceInBST.getMinimumDifference(root));
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
