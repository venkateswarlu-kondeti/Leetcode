package com.trees.binary_trees_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }
        List<Integer> currList;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int length= queue.size();
            currList=new ArrayList<>();
            for(int i=0;i<length;i++){
                TreeNode node=queue.remove();
                int currValue=node.val;
                currList.add(currValue);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ans.add(currList);
        }
        return ans;
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
        System.out.println("The binary tree level order traversal is: "+BinaryTreeLevelOrderTraversal.levelOrder(root));

        /*TreeNode root=new TreeNode(1);
        System.out.println("The binary tree level order traversal is: "+BinaryTreeLevelOrderTraversal.levelOrder(root));*/

        /*TreeNode root=new TreeNode();
        System.out.println("The binary tree level order traversal is: "+BinaryTreeLevelOrderTraversal.levelOrder(root));*/
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
