package week04;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_AllPathFromSourceToTarget {
    static public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        path.add(0);
        dfsSearch(graph, 0, res, path);

        return res;
    }

    static void dfsSearch(int[][] graph, int node, List<List<Integer>> res, List<Integer> path) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int nextNode : graph[node]) {
            path.add(nextNode);
            dfsSearch(graph, nextNode, res, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[][] graph1 = {{1, 2}, {3}, {3},{}};
        int[][] graph2 = {{4,3,1}, {3,2,4}, {3},{4},{}};

        List<List<Integer>> res = allPathsSourceTarget(graph1);

        res =allPathsSourceTarget(graph2);
        for(List<Integer> list : res){
            System.out.println(list);
        }



    }
}
