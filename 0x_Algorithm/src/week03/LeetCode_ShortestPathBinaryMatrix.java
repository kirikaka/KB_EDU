package week03;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_ShortestPathBinaryMatrix {
    static int[][] grids;
    static  int rowLength,colLength;
    static boolean[][] visited;
    static int[][] dist;

    static int[] dr={1,1,-1,-1,1,-1,0,0};
    static int[] dc={-1,1,-1,1,0,0,1,-1};

    public static boolean isValid(int row,int col){
        return (row>=0 && row<rowLength && col>=0 && col<colLength);
    }

    public static void bfs(int row,int col){
        if(grids[row][col]==1){
            return;
        }

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{row,col});
        visited[row][col]=true;
        dist[row][col]=1;


        while(!q.isEmpty()){
            int[] cur=q.poll();
            int curRow=cur[0];
            int curCol=cur[1];
            int curDistance=dist[curRow][curCol];

            for(int i=0;i<8;i++){
                int nextRow=curRow+dr[i];
                int nextCol=curCol+dc[i];
                if(isValid(nextRow,nextCol)){
                    if(!visited[nextRow][nextCol] && grids[nextRow][nextCol]==0){
                        q.offer(new int[]{nextRow,nextCol});
                        visited[nextRow][nextCol]=true;
                        dist[nextRow][nextCol]=curDistance+1;
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        grids =new int[][]{
                {0,0,0},
                {1,1,0},
                {1,1,0},
        };
//        grids =new int[][]{
//                {1,0,0},
//                {1,1,0},
//                {1,1,0},
//        };

        rowLength=grids.length;
        colLength=grids[0].length;
        visited=new boolean[rowLength][colLength];
        dist=new int[rowLength][colLength];

        bfs(0,0);

        if(dist[rowLength-1][colLength-1]==0){
            System.out.println("-1");
        } else{
            System.out.println(dist[rowLength-1][colLength-1]);
        }

    }
}
