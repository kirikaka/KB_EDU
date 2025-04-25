package week02;

import java.util.*;

public class BFS {
    public void bfs(List<List<Integer>> graph, int startVertex) {
        //====== 코드 작성 =====
        Queue<Integer> queue = new LinkedList<>();
        int N=graph.size();
        boolean[] visited = new boolean[N];

        queue.add(startVertex);
        visited[startVertex]=true;
        while(!queue.isEmpty()){

            int curVertex = queue.poll();
            System.out.println(curVertex);
            for(int nextVertex:graph.get(curVertex)){
                if(!visited[nextVertex]){
                    visited[nextVertex]=true;
                    queue.add(nextVertex);
                }
            }
        }
        //====================
    }

    public void solve(List<List<Integer>> graph) {
        bfs(graph, 0);
    }

    // 실행용 메소드
    public static void main(String[] args) {
        (new BFS()).solve(makeGraph());
    }

    public static List<List<Integer>> makeGraph() {
        return new ArrayList<>() {{
            add(List.of(1, 3, 6));
            add(List.of(0, 3));
            add(List.of(3));
            add(List.of(0, 1, 2, 7));
            add(List.of(5));
            add(List.of(4, 6, 7));
            add(List.of(0, 5));
            add(List.of(3, 5));
        }};
    }
}
