package week03;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestAmbulance {
    static int[] dr={1,1,-1,-1,1,-1,0,0};
    static int[] dc={-1,1,-1,1,0,0,1,-1};

    static int rowLength;
    static int colLength;

    static int[][] city;
    static boolean[][] visited;
    static int[][] distance;

    public static boolean isValid(int row,int col){
        return( row>=0 && row<rowLength && col>=0 && col<colLength);
    }

    public static void main(String[] args) {
        city=new int[][]{
                {0, 0, 1, 0},
                {1, 0, 1, 0},
                {1, 0, 0, 0},
        };
//        city=new int[][]{
//                {0, 1, 0},
//                {0, 1, 0},
//                {0, 0, 0},
//                {1, 1, 0},
//                {0, 0, 0}
//        };
//        city=new int[][]{
//                {0, 0, 0, 0},
//                {1, 1, 1, 0},
//                {1, 0, 0, 0},
//                {1, 1, 1, 1},
//        };
//        city=new int[][]{
//                {1, 0, 0, 0},
//                {1, 1, 1, 0},
//                {1, 0, 0, 0},
//                {1, 1, 1, 1},
//        };
        rowLength=city.length;
        colLength=city[0].length;

        visited=new boolean[rowLength][colLength];
        distance=new int[rowLength][colLength];

        bfs(0,0);

        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                System.out.print(distance[i][j]+" ");
            }
            System.out.println();
        }


        if(distance[rowLength-1][colLength-1]==0){
            System.out.println("-1");
        } else{
            System.out.println(distance[rowLength-1][colLength-1]);
        }

    }
    static void bfs(int row,int col){
        if(city[row][col]==1){
            return;
        }

        int curDistance =0;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{row,col});
        distance[row][col]=1;
        visited[row][col]=true;

        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int curCol=curr[1];
            int curRow=curr[0];
            System.out.println("ROW:"+curRow+" COL:"+curCol);
            curDistance =distance[curRow][curCol];


            for(int i=0;i<8;i++){
                int nextRow=curRow+dr[i];
                int nextCol=curCol+dc[i];
                if(isValid(nextRow,nextCol) && city[nextRow][nextCol]==0 && !visited[nextRow][nextCol]){
                    if(distance[nextRow][nextCol] !=0 && distance[nextRow][nextCol]<= curDistance){
                        System.out.println("PASS");
                        continue;
                    }
                    distance[nextRow][nextCol]= curDistance +1;
                    queue.offer(new int[]{nextRow,nextCol});
                    visited[nextRow][nextCol]=true;
                }
            }

        }



    }
}
