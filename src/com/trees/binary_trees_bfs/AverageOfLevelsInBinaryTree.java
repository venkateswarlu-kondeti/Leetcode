package com.trees.binary_trees_bfs;

import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgList=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int length= queue.size();
            double sum=0;
            for(int i=0;i<length;i++){
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            avgList.add(sum/length);
        }
        return avgList;
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(3);
        TreeNode nine=new TreeNode(9);
        TreeNode twenty=new TreeNode(20);
        TreeNode fifteen=new TreeNode(15);
        TreeNode seven=new TreeNode(7);
        root.left=nine;
        root.right=twenty;
        twenty.left=fifteen;
        twenty.right=seven;
        System.out.println("The average of levels in a binary tree: "+AverageOfLevelsInBinaryTree.averageOfLevels(root));
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
