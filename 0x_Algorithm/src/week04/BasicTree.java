package week04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;




public class BasicTree {
    static class Node2 {
        int val;
        Node2 left;
        Node2 right;
        Node2(){};
        Node2(int val){
            this.val = val;
        }
        Node2(int val, Node2 left, Node2 right){
            this.val = val;
            this.left = left;
            this.right = right;

        }
    }

    static class Node{
        int value;
        List<Node> children;
        Node(int value){
            this.value = value;
            this.children = new ArrayList<>();
        }
    }


    static int level;

    // level order Traversal - bfs
    static void levelOrder(Node root){
        if(root == null) return;

        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node currentNode=queue.poll();
            System.out.println(currentNode.value);

            for(Node child:currentNode.children){
                queue.add(child);
            }

        }
    }
    static void levelOrder2(Node2 root){
        if(root == null) return;


    }


    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2= new Node(2);
        Node node3= new Node(3);
        Node node4= new Node(4);
        Node node5= new Node(5);

        root.children.add(node2);
        root.children.add(node3);
        node2.children.add(node4);
        node3.children.add(node5);

        levelOrder(root);

    }


}






































