package com.treesandgraphs;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> subList;
        List<List<Integer>> ans=new ArrayList<>();
        int count=0;
        while(!queue.isEmpty()){
            int currLen= queue.size();
            subList=new ArrayList<>();
            for(int i=0;i<currLen;i++){
                TreeNode node=queue.remove();
                subList.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            count++;
            if(count%2==0){
                Collections.reverse(subList);
            }
            ans.add(subList);
        }
        return ans;
    }
    public static void main(String[] args){
        /*TreeNode root=new TreeNode(3);
        TreeNode nine=new TreeNode(9);
        TreeNode twenty=new TreeNode(20);
        TreeNode fifteen=new TreeNode(15);
        TreeNode seven=new TreeNode(7);
        root.left=nine;
        root.right=twenty;
        twenty.left=fifteen;
        twenty.right=seven;
        System.out.println("The binary tree zigzag level order traversal is: "+BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(root));*/

        /*TreeNode root=new TreeNode(1);
        System.out.println("The binary tree zigzag level order traversal is: "+BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(root));*/

        TreeNode root=new TreeNode();
        System.out.println("The binary tree zigzag level order traversal is: "+BinaryTreeZigzagLevelOrderTraversal.zigzagLevelOrder(root));
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
