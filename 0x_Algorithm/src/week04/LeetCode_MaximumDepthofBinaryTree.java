package week04;

public class LeetCode_MaximumDepthofBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;

        }

    }


    static int maxDepth(TreeNode root) {
        int depth=0;
        if (root==null){
            return 0;
        }
        depth=1+Math.max(maxDepth(root.left),maxDepth(root.right));



        return depth;
    }

    public static void main(String[] args) {
        int [] root= {3,9,20,-1,-1,15,7};
//        int [] root= {1,-1,2};
        TreeNode rootNode=new TreeNode(root[0]);
        TreeNode node1=new TreeNode(root[1]);
        TreeNode node2=new TreeNode(root[2]);
        TreeNode node3=new TreeNode(root[3]);
        TreeNode node4=new TreeNode(root[4]);
        TreeNode node5=new TreeNode(root[5]);
        TreeNode node6=new TreeNode(root[6]);

        rootNode.left=node1;
        rootNode.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;

        int res = maxDepth(rootNode);
        System.out.println(res);


    }

}
