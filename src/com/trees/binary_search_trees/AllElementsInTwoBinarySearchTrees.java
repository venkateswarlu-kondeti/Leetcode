package com.trees.binary_search_trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class AllElementsInTwoBinarySearchTrees {
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans=new ArrayList<>();
        Stream.of(inOrder(root1,new ArrayList<>()),inOrder(root2,new ArrayList<>())).forEach(ans::addAll);
        Collections.sort(ans);
        return ans;
    }
    public static List<Integer> inOrder(TreeNode node, List<Integer> ans){
        if(node==null){
            return ans;
        }
        inOrder(node.left,ans);
        ans.add(node.val);
        inOrder(node.right,ans);
        return ans;
    }
    //---------------------My Method 1---------------------------------------
    /*public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans=new ArrayList<>();
        dfs(root1,ans);
        dfs(root2,ans);
        Collections.sort(ans);
        return ans;
    }
    public static List<Integer> dfs(TreeNode node, List<Integer> ans){
        if(node==null){
            return ans;
        }
        ans.add(node.val);
        dfs(node.left,ans);
        dfs(node.right,ans);
        return ans;
    }*/

    //----------------------My Method 2---------------------------------
    /*public static List<Integer> ans;
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ans=new ArrayList<>();
        dfs(root1);
        dfs(root2);
        Collections.sort(ans);
        return ans;
    }
    public static void dfs(TreeNode node){
        if(node==null){
            return;
        }
        ans.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }*/

    public static void main(String[] args){
        TreeNode root1=new TreeNode(2);
        TreeNode one=new TreeNode(1);
        TreeNode four=new TreeNode(4);
        root1.left=one;
        root1.right=four;

        TreeNode root2=new TreeNode(1);
        TreeNode zero=new TreeNode(0);
        TreeNode three=new TreeNode(3);
        root2.left=zero;
        root2.right=three;

        System.out.println("All the elements in two BSTs is : "+AllElementsInTwoBinarySearchTrees.getAllElements(root1,root2));
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
