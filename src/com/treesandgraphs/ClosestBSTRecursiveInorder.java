package com.treesandgraphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ClosestBSTRecursiveInorder {
    public static int closestValueRecursiveInorder(TreeNode root, double target){
        List<Integer> nums=new ArrayList<>();
        inOrder(root,nums);
        return Collections.min(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1-target)<Math.abs(o2-target)?-1 :1;
            }
        });
    }
    public static void inOrder(TreeNode node, List<Integer> nums){
        if(node==null){
            return;
        }
        inOrder(node.left,nums);
        nums.add(node.val);
        inOrder(node.right,nums);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(4);
        TreeNode two=new TreeNode(2);
        TreeNode one=new TreeNode(1);
        TreeNode three=new TreeNode(3);
        TreeNode five=new TreeNode(5);
        root.left=two;
        root.right=five;
        two.left=one;
        two.right=three;
        System.out.println("The closest binary search tree value is: "+ClosestBSTRecursiveInorder.closestValueRecursiveInorder(root,3.714286));
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
