package com.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Find largest value in each tree row
public class FindLargestValueInEachTreeRow {
    public static List<Integer> largestValues(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> ans=new ArrayList<>();
        while(!queue.isEmpty()){
            int currentLength= queue.size();
            int currMax=Integer.MIN_VALUE;
            for(int i=0;i<currentLength;i++){
                TreeNode node=queue.remove();
                currMax=Math.max(currMax,node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ans.add(currMax);
        }
        return ans;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode three=new TreeNode(3);
        TreeNode five=new TreeNode(5);
        TreeNode three_1=new TreeNode(3);
        TreeNode two=new TreeNode(2);
        TreeNode nine=new TreeNode(9);
        root.left=three;
        three.left=five;
        three.right=three_1;
        root.right=two;
        two.right=nine;
        System.out.println("The largest values at each level is: "+FindLargestValueInEachTreeRow.largestValues(root));
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
