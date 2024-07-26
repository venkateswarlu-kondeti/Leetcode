package com.trees;

public class PathSum {
    static int target;
    public static boolean hasPathSum(TreeNode root, int targetSum){
        target=targetSum;
        return dfs(root,0);
    }
    public static boolean dfs(TreeNode node, int curr){
        if(node==null){
            return false;
        }
        if(node.left==null && node.right==null){
            return curr+ node.val==target;
        }
        curr+= node.val;;
        boolean left=dfs(node.left,curr);
        boolean right=dfs(node.right,curr);
        return left || right;
    }

    public static void main(String[] args){
        TreeNode root=new TreeNode(5);
        TreeNode fourLeft=new TreeNode(4);
        TreeNode eleven=new TreeNode(11);
        TreeNode seven=new TreeNode(7);
        TreeNode two=new TreeNode(2);
        TreeNode eight=new TreeNode(8);
        TreeNode thirteen=new TreeNode(13);
        TreeNode fourRight=new TreeNode(4);
        TreeNode one=new TreeNode(1);

        root.left=fourLeft;
        fourLeft.left=eleven;
        eleven.left=seven;
        eleven.right=two;
        root.right=eight;
        eight.left=thirteen;
        eight.right=fourRight;
        fourRight.right=one;
        int targetSum=22;

        System.out.println("Is there a path sum? "+hasPathSum(root,targetSum));
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
