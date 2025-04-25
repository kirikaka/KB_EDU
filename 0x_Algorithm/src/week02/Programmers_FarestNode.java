package week02;

import java.util.*;

public class Programmers_FarestNode {
    static boolean[] visited;
    static boolean[] visitedBFS;
    static List<List<Integer>> graph;
    static int answer = 0;
    static int answer2 = 0;

    static int[] distDFS;
    static int[] distBFS;

    public static int solution(int n, int[][] edge) {

        visited = new boolean[n];
        distDFS = new int[n];
        distBFS = new int[n];

        graph = makeGraph(n, edge);
        System.out.println(graph);
//
//        dfs(0);
//        distDFS[0] = 0;
        distBFS[0]=0;

        Queue<Integer> queue = new LinkedList<>();
        visitedBFS=new boolean[n];
        queue.offer(0);

        while(!queue.isEmpty()){
            int curVertex = queue.poll();
            visitedBFS[curVertex]=true;

            for(int next:graph.get(curVertex)){
                if(!visitedBFS[next]){

                    visitedBFS[next]=true;

                    queue.add(next);
                    distBFS[next]=distBFS[curVertex]+1;
                }
            }

        }

        Arrays.sort(distBFS);
        int max=distBFS[n-1];
        for(int i=0;i<n;i++){
            if(max==distBFS[i]){
                answer++;
            }
        }

        return answer;
    }
    public static void dfs(int node){
        visited[node] = true;

        for(int nextNode:graph.get(node)){
            if(!visited[nextNode]){
                distDFS[nextNode] = distDFS[node]+1;
                dfs(nextNode);

            }
        }
    }

    public static List<List<Integer>> makeGraph(int n, int[][] edges) {
        List<List<Integer>> graph =new ArrayList<List<Integer>>();

        int nodeLength = edges.length;
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<nodeLength;i++){
//            System.out.println(edges[i][0]+" "+edges[i][1]);
            graph.get(edges[i][0]-1).add(edges[i][1]-1);
            graph.get(edges[i][1]-1).add(edges[i][0]-1);
        }

        return graph;
    }

    public static void main(String[] args) {
        int [][]vertex=new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        int ans=solution(6,vertex);

        System.out.println(ans);
    }
}
