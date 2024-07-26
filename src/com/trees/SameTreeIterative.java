package com.trees;

import java.util.Stack;

public class SameTreeIterative {
    public static boolean isSameTree(TreeNode p, TreeNode q){
        Stack<Pair> stack=new Stack<>();
        stack.push(new Pair(p,q));

        while (!stack.empty()){
            Pair pair=stack.pop();
            TreeNode node1=pair.p;
            TreeNode node2=pair.q;

            if(node1==null && node2==null){
                continue;
            }
            if(node1==null || node2==null){
                return false;
            }
            if(node1.val!=node2.val){
                return false;
            }
            stack.push(new Pair(node1.left, node2.left));
            stack.push(new Pair(node1.right, node2.right));
        }
        return true;
    }
    public static void main(String[] args){
        TreeNode p=new TreeNode(1);
        TreeNode two1=new TreeNode(2);
        TreeNode four1=new TreeNode(4);
        TreeNode five1=new TreeNode(5);
        TreeNode six1=new TreeNode(6);
        TreeNode three1=new TreeNode(3);
        p.left=two1;
        two1.left=four1;
        two1.right=five1;
        five1.right=six1;
        p.right=three1;

        TreeNode q=new TreeNode(1);
        TreeNode two2=new TreeNode(2);
        TreeNode four2=new TreeNode(4);
        TreeNode five2=new TreeNode(5);
        TreeNode six2=new TreeNode(6);
        TreeNode three2=new TreeNode(3);
        q.left=two2;
        two2.left=four2;
        two2.right=five2;
        five2.right=six2;
        q.right=three2;
        System.out.println("Same Tree? "+isSameTree(p,q));
    }
    public static class Pair{
        TreeNode p;
        TreeNode q;
        Pair(TreeNode p, TreeNode q){
            this.p=p;
            this.q=q;
        }
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
