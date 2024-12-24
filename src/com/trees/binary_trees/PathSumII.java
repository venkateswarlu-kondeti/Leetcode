package com.trees.binary_trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    public static List<List<Integer>> ans=new ArrayList<>();
    public static List<Integer> currList=new ArrayList<>();
    public static int currSum=0;
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return ans;
        }
        currList.add(root.val);
        currSum+=root.val;
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        if(root.left==null && root.right==null && currSum==targetSum){
            ans.add(new ArrayList<>(currList));
            System.out.println(ans);
        }
        currSum-=root.val;
        currList.remove(currList.size()-1);
        return ans;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(5);
        TreeNode four=new TreeNode(4);
        TreeNode eleven=new TreeNode(11);
        TreeNode seven=new TreeNode(7);
        TreeNode two=new TreeNode(2);
        TreeNode eight=new TreeNode(8);
        TreeNode thirteen=new TreeNode(13);
        TreeNode fourright=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        TreeNode one=new TreeNode(1);
        root.left=four;
        four.left=eleven;
        eleven.left=seven;
        eleven.right=two;
        root.right=eight;
        eight.left=thirteen;
        eight.right=fourright;
        fourright.left=five;
        fourright.right=one;
        int targetSum=22;

        System.out.println("The path sum II is: "+ PathSumII.pathSum(root,targetSum));
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
