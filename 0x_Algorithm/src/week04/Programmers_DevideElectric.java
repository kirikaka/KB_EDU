package week04;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;

public class Programmers_DevideElectric {
    static boolean[] visited;
    static int[] childs;
    static ArrayList<ArrayList<Integer>> tree;


    static int solutions(int n,int[][] wires){
        int answer=-1;
        tree=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0;i< wires.length;i++){
            tree.get(wires[i][0]).add(wires[i][1]);
            tree.get(wires[i][1]).add(wires[i][0]);
        }
        System.out.println(tree);


        childs=new int[n+1];
        visited=new boolean[n+1];

        // 가장 많은 child를 가진 노드를 찾고
        // 해당 노드의 자식노드가 해당 노드와 연결이 끊어졌을 때의 연결 노드 수 찾아서 비교.
        // 가장 최대값 찾기.

        int max=0;
        int idx=0;
        for(int i=1;i<=n;i++){
            if(tree.get(i).size()>max){
                max=tree.get(i).size();
                idx=i;
            }
        }
        System.out.println("가장 많은 자식 노드가 있는 노드번호 : "+idx);
        childs[idx]=tree.get(idx).size();
        dfs(idx);
        for(int i=1;i<=n;i++){
            System.out.print(childs[i]+" ");
        }







        return  answer;
    }
    static void dfs(int rootIdx){

        visited[rootIdx]=true;



        for(int idx:tree.get(rootIdx)){
            if(!visited[idx]){
                dfs(idx);
                childs[idx]++;
            }
        }


    }



    public static void main(String[] args) {
        int n1=9;
        int n2=4;
        int n3=7;
        int [][]wires1={{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int [][]wires2={{1,2},{2,3},{3,4}};
        int [][]wires3={{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};

        int ans=solutions(n2,wires2);
    }
}
