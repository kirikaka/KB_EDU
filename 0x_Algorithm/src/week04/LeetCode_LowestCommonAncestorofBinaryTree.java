package week04;

import java.util.ArrayList;

public class LeetCode_LowestCommonAncestorofBinaryTree {
    static ArrayList<Integer>depth;
    static ArrayList<Integer> ancestor;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){
            this.val = val;
        }

    }

    static public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null){
            return null;
        }

        if(root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left!=null && right!=null){
            return root;
        }

        return left==null? right : left;

    }

    public static void main(String[] args) {
        int[] root= {3,5,1,6,2,0,8,-1,-1,7,4};
        TreeNode rootNode=new TreeNode(root[0]);
        TreeNode node1= new TreeNode(root[1]);
        TreeNode node2= new TreeNode(root[2]);
        TreeNode node3= new TreeNode(root[3]);
        TreeNode node4= new TreeNode(root[4]);
        TreeNode node5= new TreeNode(root[5]);
        TreeNode node6= new TreeNode(root[6]);
        TreeNode node7= new TreeNode(root[7]);
        TreeNode node8= new TreeNode(root[8]);
        TreeNode node9= new TreeNode(root[9]);
        TreeNode node10= new TreeNode(root[10]);

        rootNode.left=node1;
        rootNode.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node3.left=node7;
        node3.right=node8;
        node4.left=node9;
        node4.right=node10;
        TreeNode ans= lowestCommonAncestor(rootNode,node1,node10);
        System.out.println(ans.val);



    }

}
