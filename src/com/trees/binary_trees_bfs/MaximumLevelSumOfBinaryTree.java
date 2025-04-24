package com.trees.binary_trees_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfBinaryTree {
    public static int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int ans = 0;
        int level = 0;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            level++;
            int sumAtCurrentLevel=0;
            for(int sz=q.size();sz>0;--sz){
                TreeNode node=q.poll();
                sumAtCurrentLevel+=node.val;

                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            if(maxSum<sumAtCurrentLevel){
                maxSum=sumAtCurrentLevel;
                ans=level;

            }
        }
        return ans;
    }

    //------------My Solution-------------------------------------------
    /*public static int maxLevelSum(TreeNode root) {
        Map<Integer,List<Integer>> maxValueToLevelMap=new HashMap<>();
        Queue<TreeNode> queue=new LinkedList<>();
        int level=0;
        queue.add(root);

        while(!queue.isEmpty()){
            int length= queue.size();
            int sum=0;
            for(int i=0;i<length;i++){
                TreeNode node=queue.remove();
                sum+=node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            level++;
            if(!maxValueToLevelMap.containsKey(sum)){
                maxValueToLevelMap.put(sum,new ArrayList<>());
            }
            maxValueToLevelMap.get(sum).add(level);
        }
        int maxValue= Collections.max(maxValueToLevelMap.keySet());
        return Collections.min(maxValueToLevelMap.get(maxValue));
    }*/
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode seven=new TreeNode(7);
        TreeNode zero=new TreeNode(0);
        TreeNode seven1=new TreeNode(7);
        TreeNode eightminus=new TreeNode(-8);
        root.left=seven;
        root.right=zero;
        seven.left=seven1;
        seven.right=eightminus;
        System.out.println("The maximum level sum of binary tree is: "+MaximumLevelSumOfBinaryTree.maxLevelSum(root));
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
