package com.trees.binary_trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeafSimilarTrees {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2){
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        return list1.equals(list2);

        //-------------------My Solution-------------------------------
        /*List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        System.out.println(list1);
        System.out.println(list2);
        if(list1.size()!=list2.size()){
            return false;
        }
        for(int i=0;i<list1.size();i++){
            if(list1.get(i).compareTo(list2.get(i))!=0){
                return false;
            }
        }
        return true;*/
    }
    public static void dfs(TreeNode root, List<Integer> list){
        if(root==null){
            return;
        }
        dfs(root.left,list);
        dfs(root.right,list);
        if(root.left==null && root.right==null){
            list.add(root.val);
        }
    }
    public static void main(String[] args){
       /* TreeNode root1=new TreeNode(3);
        TreeNode five1=new TreeNode(5);
        TreeNode six1=new TreeNode(6);
        TreeNode two1=new TreeNode(2);
        TreeNode seven1=new TreeNode(7);
        TreeNode four1=new TreeNode(4);
        TreeNode one1=new TreeNode(1);
        TreeNode nine1=new TreeNode(9);
        TreeNode eight1=new TreeNode(8);
        root1.left=five1;
        five1.left=six1;
        five1.right=two1;
        two1.left=seven1;
        two1.right=four1;
        root1.right=one1;
        one1.left=nine1;
        one1.right=eight1;

        TreeNode root2=new TreeNode(3);
        TreeNode five2=new TreeNode(5);
        TreeNode six2=new TreeNode(6);
        TreeNode two2=new TreeNode(2);
        TreeNode seven2=new TreeNode(7);
        TreeNode four2=new TreeNode(4);
        TreeNode one2=new TreeNode(1);
        TreeNode nine2=new TreeNode(9);
        TreeNode eight2=new TreeNode(8);
        root2.left=five2;
        five2.left=six2;
        five2.right=seven2;
        root2.right=one2;
        one2.left=four2;
        one2.right=two2;
        two2.left=nine2;
        two2.right=eight2;*/

        TreeNode root1=new TreeNode(1);
        TreeNode two1=new TreeNode(2);
        TreeNode twohundred1=new TreeNode(200);
        root1.left=two1;
        root1.right=twohundred1;

        TreeNode root2=new TreeNode(1);
        TreeNode two2=new TreeNode(2);
        TreeNode twohundred2=new TreeNode(200);
        root2.left=two2;
        root2.right=twohundred2;
        System.out.println("Leaf similar Tree? "+LeafSimilarTrees.leafSimilar(root1,root2));
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
