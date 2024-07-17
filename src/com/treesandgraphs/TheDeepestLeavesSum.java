package com.treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class TheDeepestLeavesSum {
    public static int deepestLeavesSum(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int ans=0;
        while(!queue.isEmpty()){
            int currLen= queue.size();
            int curr=0;
            for(int i=0;i<currLen;i++){
                TreeNode node=queue.remove();
                curr+= node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            ans=curr;
        }
        return ans;
    }
    public static void main(String[] args){
        /*TreeNode root=new TreeNode(1);
        TreeNode two=new TreeNode(2);
        TreeNode four=new TreeNode(4);
        TreeNode five=new TreeNode(5);
        TreeNode seven=new TreeNode(7);
        TreeNode three=new TreeNode(3);
        TreeNode six=new TreeNode(6);
        TreeNode eight=new TreeNode(8);
        root.left=two;
        two.left=four;
        two.right=five;
        four.left=seven;
        root.right=three;
        three.right=six;
        six.right=eight;
        System.out.println("The deepest leaves sum is: "+TheDeepestLeavesSum.deepestLeavesSum(root));*/

        TreeNode root=new TreeNode(6);
        TreeNode seven=new TreeNode(7);
        TreeNode two=new TreeNode(2);
        TreeNode nine=new TreeNode(9);
        TreeNode seven_1=new TreeNode(7);
        TreeNode one=new TreeNode(1);
        TreeNode four=new TreeNode(4);
        TreeNode eight=new TreeNode(8);
        TreeNode one_1=new TreeNode(1);
        TreeNode three=new TreeNode(3);
        TreeNode five=new TreeNode(5);
        root.left=seven;
        seven.left=two;
        two.left=nine;
        seven.right=seven_1;
        seven_1.left=one;
        seven_1.right=four;
        root.right=eight;
        eight.left=one_1;
        eight.right=three;
        three.right=five;
        System.out.println("The deepest leaves sum is: "+TheDeepestLeavesSum.deepestLeavesSum(root));
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
