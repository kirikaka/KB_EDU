package week03;

public class BasicDFS {
    public class ImplicitGraphDFS {
        static boolean[][] visited;
        static int[][] grid;
        static int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
        static int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
        static int rowLength;
        static int colLength;

        public static boolean isValid(int r, int c) {
            return 0 <= r && r < rowLength && 0 <= c && c<colLength;
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
            dfs(0, 0);
        }

        public static void dfs(int r, int c) {
            visited[r][c]=true;
            for(int i=0;i<4;i++){
                int nextR = r+dr[i];
                int nextC = c+dc[i];
                if(isValid(nextR,nextC)){
                   if(!visited[nextR][nextC]){
                       dfs(nextR, nextC);
                   }
                }
            }


            // ===================
        }
    }
}
