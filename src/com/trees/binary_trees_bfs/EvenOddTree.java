package com.trees.binary_trees_bfs;

import java.util.*;

public class EvenOddTree {
    public static boolean isEvenOddTree(TreeNode root) {
        Map<Integer,Integer> valueToCountMap=new HashMap<>();
        int level=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int length= queue.size();
            int prevValue= queue.peek().val;
            for(int i=0;i<length;i++){
                TreeNode node=queue.poll();
                if((level%2==0 && (node.val%2==0 || prevValue>node.val))|| (level%2!=0 && (node.val%2!=0 || prevValue<node.val))){
                    return false;
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                prevValue= node.val;
                if(!valueToCountMap.containsKey(node.val)){
                    valueToCountMap.put(node.val, valueToCountMap.getOrDefault(node.val,0)+1);
                    continue;
                }
                return false;
            }
            level++;
            valueToCountMap.clear();
        }
        return true;
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        TreeNode ten=new TreeNode(10);
        TreeNode four=new TreeNode(4);
        TreeNode three=new TreeNode(3);
        TreeNode seven=new TreeNode(7);
        TreeNode nine=new TreeNode(9);
        TreeNode twelve=new TreeNode(12);
        TreeNode eight=new TreeNode(8);
        TreeNode six=new TreeNode(6);
        TreeNode two=new TreeNode(2);
        root.left=ten;
        root.right=four;
        ten.left=three;
        three.left=twelve;
        three.right=eight;
        four.left=seven;
        four.right=nine;
        seven.left=six;
        nine.right=two;
        System.out.println("The even odd tree is: "+EvenOddTree.isEvenOddTree(root));
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
