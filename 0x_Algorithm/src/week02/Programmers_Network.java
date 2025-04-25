package week02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Programmers_Network {
    static boolean[] visited;
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        List<List<Integer>> graph = makeGraph(n,computers);
        System.out.println(graph);
        Queue<Integer> queue = new LinkedList<>();
        visited = new boolean[n];

        for(int i=0;i<n;i++){
//            System.out.println(graph.get(i));;
            if(!visited[i]){
                queue.add(i);
                visited[i]=true;
                while(!queue.isEmpty()){
                    int curVertex = queue.poll();
                    for(int nextVertex : graph.get(curVertex)){
                        if(!visited[nextVertex]){
                            answer ++;
                            visited[nextVertex] = true;
                            queue.add(nextVertex);
                        }
                    }
                }
            }

        }



        return n-answer;
    }


    public static List<List<Integer>> makeGraph(int n,int[][] computers) {
        ArrayList<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n;i++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0; j<n;j++){
                if(computers[i][j]==1 && i!=j){
                    list.add(j);
                }
            }
            graph.add(list);
        }


        return graph;
    }


    public static void main(String[] args) {
        int [][]array1={{1,1,0},{1,1,0},{0,0,1}};
        int [][]array2={{1,1,0},{1,1,1},{0,1,1}};
        int [][]array3={{1,1,0,0},{1,1,0,0},{0,0,1,1},{0,0,1,1}};

        int ans1=solution(3,array1);
        int ans2=solution(3,array2);
        int ans3=solution(4,array3);

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }
}
