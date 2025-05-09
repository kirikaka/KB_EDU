package week03;

import java.util.LinkedList;
import java.util.Queue;

public class BasicBFS {
    static boolean[][] visited;
    static int[][] grid;
    static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    static int rowLength;
    static int colLength;

    public static boolean isValid(int r, int c) {
        return( 0 <= r) && (r < rowLength )&&( 0 <= c) && (c<colLength);
    }

    public static void main(String[] args) {
        grid = new int[][]{
                {1, 1, 1, 1},
                {0, 1, 0, 1},
                {0, 1, 0, 1},
                {1, 0, 1, 1}
        };
        rowLength = grid.length;
        colLength = grid[0].length;
        visited = new boolean[rowLength][colLength];
        bfs(0, 0);
    }

    public static void bfs(int r, int c) {
        // ===== 코드 작성 =====
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        visited[r][c] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int curR = curr[0];
            int curC = curr[1];
            for(int i = 0; i < 4; i++){
                int nextR = curr[0] + dr[i];
                int nextC = curr[1] + dc[i];
                if(isValid(nextR, nextC)){
                    if(!visited[nextR][nextC]){
                        visited[nextR][nextC] = true;
                        queue.offer(new int[]{nextR, nextC});
                    }
                }

            }

        }

        // ===================
    }
}
