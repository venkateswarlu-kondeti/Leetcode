package com.trees.binary_trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PathSumIII {
    public static  int count=0;
    public static Map<Long, Integer> pathMap=new HashMap<>();
    public static int k;
    public static int pathSum(TreeNode root, int targetSum){
        k=targetSum;
        long currSum=0;
        dfs(root,currSum);
        return count;
    }
    public static void dfs(TreeNode node,long currSum){
        if(node==null){
            return;
        }
        currSum+= node.val;
        if(currSum==k){
            count++;
        }
        count+=pathMap.getOrDefault(currSum-k,0);
        pathMap.put(currSum, pathMap.getOrDefault(currSum,0)+1);


        dfs(node.left, currSum);
        dfs(node.right, currSum);
        pathMap.put(currSum, pathMap.get(currSum)-1);

    }
    public static void main(String[] args){
        /*TreeNode root=new TreeNode(10);
        TreeNode five=new TreeNode(5);
        TreeNode three=new TreeNode(3);
        TreeNode three1=new TreeNode(3);
        TreeNode mtwo=new TreeNode(-2);
        TreeNode two=new TreeNode(2);
        TreeNode one=new TreeNode(1);
        TreeNode mthree=new TreeNode(-3);
        TreeNode eleven=new TreeNode(11);
        root.left=five;
        five.left=three;
        three.left=three1;
        three.right=mtwo;
        five.right=two;
        two.right=one;
        root.right=mthree;
        mthree.right=eleven;
        int targetSum=8;
        System.out.println("The number of path III sum is "+PathSumIII.pathSum(root,targetSum));*/

        /*TreeNode root=new TreeNode(1000000000);
        TreeNode one1=new TreeNode(1000000000);
        TreeNode two1=new TreeNode(294967296);
        TreeNode one2=new TreeNode(1000000000);
        TreeNode one3=new TreeNode(1000000000);
        TreeNode one4=new TreeNode(1000000000);
        root.left=one1;
        one1.left=two1;
        two1.left=one2;
        one2.left=one3;
        one3.left=one4;
        int targetSum=8;
        System.out.println("The number of path III sum is "+PathSumIII.pathSum(root,targetSum));*/

        TreeNode root=new TreeNode(5);
        TreeNode four=new TreeNode(4);
        TreeNode eleven=new TreeNode(11);
        TreeNode seven=new TreeNode(7);
        TreeNode two=new TreeNode(2);
        TreeNode eight=new TreeNode(8);
        TreeNode thirteen=new TreeNode(13);
        TreeNode four1=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        TreeNode one=new TreeNode(1);
        root.left=four;
        four.left=eleven;
        eleven.left=seven;
        eleven.right=two;
        root.right=eight;
        eight.left=thirteen;
        eight.right=four1;
        four1.left=five;
        five.right=one;
        int targetSum=22;
        System.out.println("The number of path III sum is "+PathSumIII.pathSum(root,targetSum));
    }
    public static  class TreeNode{
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
