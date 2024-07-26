package com.trees;

public class ClosestBinarySearchTreeValue {
    public static int closestValue(TreeNode root, double target){
        double val, closest=root.val;
        while(root!=null){
            val= root.val;;
            closest=Math.abs(val-target)<Math.abs(closest-target)|| Math.abs(val-target)==Math.abs(closest-target) && val<closest? val : closest;
            root= val< root.val? root.left : root.right;
        }
        return (int)closest;
    }

    ///--------------------------My Solution-------------------------------------------
    /*public static int closestValue(TreeNode root, double target){
        Map<Double,Integer> diffToNodevalueMap=new HashMap<>();
        dfs(root,diffToNodevalueMap, target);
        System.out.println(diffToNodevalueMap);
        double val=Integer.MAX_VALUE;
        int ans=0;
        for(Map.Entry<Double,Integer> e : diffToNodevalueMap.entrySet()){
            val=Math.min(val,e.getKey());
        }
        return diffToNodevalueMap.get(val);
    }
    public static void dfs(TreeNode node, Map<Double,Integer> diffToNodeMap, double target){
        if(node==null){
            return;
        }
        if(node.val>=target){
            if(!diffToNodeMap.containsKey((double)node.val-target) || diffToNodeMap.containsKey((double)node.val-target) && node.val<diffToNodeMap.get((double)node.val-target)){
                diffToNodeMap.put((double)node.val-target,node.val);
            }
            dfs(node.left,diffToNodeMap,target);
        }
        if(node.val<=target){
            if(!diffToNodeMap.containsKey(target- (double)node.val) || diffToNodeMap.containsKey(target- (double)node.val) && node.val<diffToNodeMap.get(target- (double)node.val)){
                diffToNodeMap.put(target- (double)node.val,node.val);
            }
            dfs(node.right,diffToNodeMap,target);
        }
    }*/
    public static void main(String[] args){
        TreeNode root=new TreeNode(4);
        TreeNode two=new TreeNode(2);
        TreeNode one=new TreeNode(1);
        TreeNode three=new TreeNode(3);
        TreeNode five=new TreeNode(5);
        root.left=two;
        root.right=five;
        two.left=one;
        two.right=three;
        System.out.println("The closest binary search tree value is: "+ClosestBinarySearchTreeValue.closestValue(root,3.714286));
        /*TreeNode root=new TreeNode(1);
        System.out.println("The closest binary search tree value is: "+ClosestBinarySearchTreeValue.closestValue(root,4.428571));*/
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
