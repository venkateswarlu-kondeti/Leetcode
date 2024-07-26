package com.trees;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDifferenceInBST {
    public static int getMinimumDifference(TreeNode root){
        List<Integer> values=new ArrayList<>();
        dfs(root,values);
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<values.size();i++){
            ans=Math.min(ans,Math.abs(values.get(i)-values.get(i-1)));
        }
        return ans;
    }
    public static void dfs(TreeNode node, List<Integer> values){
        if(node==null){
            return;
        }
        dfs(node.left,values);
        values.add(node.val);
        dfs(node.right,values);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(9);
        TreeNode five=new TreeNode(5);
        TreeNode one=new TreeNode(1);
        TreeNode seven=new TreeNode(7);
        TreeNode fifteen=new TreeNode(15);
        root.left=five;
        five.left=one;
        five.right=seven;
        root.right=fifteen;
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
