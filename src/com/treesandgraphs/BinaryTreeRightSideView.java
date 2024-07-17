package com.treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 199. Binary Tree Right Side View
public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> ans=new ArrayList<>();
        while(!queue.isEmpty()){
            int currentLength= queue.size();
            int prev=0;
            for(int i=0;i<currentLength;i++){
                TreeNode node=queue.remove();
                prev=node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ans.add(prev);
        }
        return ans;
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode two=new TreeNode(2);
        TreeNode three=new TreeNode(3);
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        root.left=two;
        root.right=three;
        three.left=four;
        three.right=five;
        System.out.println("The right side view of items is: "+BinaryTreeRightSideView.rightSideView(root));
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
            this.right=right;
            this.left=left;
        }
    }
}
