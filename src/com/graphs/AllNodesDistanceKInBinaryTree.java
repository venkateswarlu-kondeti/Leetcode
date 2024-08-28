package com.graphs;

import javax.swing.tree.TreeNode;
import java.util.*;

// 863. All Nodes Distance K in Binary Tree
public class AllNodesDistanceKInBinaryTree {
    public static Map<TreeNode, TreeNode> parents=new HashMap<>();
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        dfs(root,null);
        Queue<TreeNode> queue=new LinkedList<>();
        Set<TreeNode> seen=new HashSet<>();
        queue.add(target);
        seen.add(target);
        int distance=0;
        while(!queue.isEmpty() && distance<k){
            int currentLength= queue.size();
            for(int i=0;i<currentLength;i++){
                TreeNode node=queue.remove();
                for(TreeNode neighbor : new TreeNode[]{node.left,node.right,parents.get(node)}){
                    if(neighbor!=null && !seen.contains(neighbor)){
                        seen.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            distance++;
        }
        List<Integer> ans=new ArrayList<>();
        for(TreeNode node : queue){
            ans.add(node.val);
        }
        return ans;
    }
    public static void dfs(TreeNode node, TreeNode parent){
        if(node==null){
            return;
        }
        parents.put(node,parent);
        dfs(node.left,node);
        dfs(node.right,node);
    }
    public static void main(String[] args){
        TreeNode root=new TreeNode(3);
        TreeNode target=new TreeNode(5);
        int k=2;

        TreeNode six=new TreeNode(6);
        TreeNode two=new TreeNode(2);
        TreeNode seven=new TreeNode(7);
        TreeNode four=new TreeNode(4);
        TreeNode one=new TreeNode(1);
        TreeNode zero=new TreeNode(0);
        TreeNode eight=new TreeNode(8);
        root.left=target;
        target.left=six;
        target.right=two;
        two.left=seven;
        two.right=four;
        root.right=one;
        one.left=zero;
        one.right=eight;

        System.out.println("All the nodes with distance K in Binary Tree is: "+AllNodesDistanceKInBinaryTree.distanceK(root,target,k));
    }
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val=val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val=val;
            this.left=left;
            this.right=right;
        }
    }
}
