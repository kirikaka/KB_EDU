package week03;

import java.util.LinkedList;
import java.util.Queue;

public class CountingCloud {
    static int[][] sky;
    static int rowLength;
    static int colLength;
    static boolean[][] visited;
    static int[] dr={-1,1,0,0};
    static int[] dc ={0,0,-1,1};

    public static boolean isValid(int i, int j) {
        return i >= 0 && i < rowLength && j >= 0 && j < colLength;
    }

    public static int solve(int[][] sky) {
        int answer=0;
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r <rowLength; r++){
            for(int c = 0; c <colLength; c++){
                if(sky[r][c]==1 && !visited[r][c]){
//                    System.out.println("R : "+r+" C : "+c);
                    q.offer(new int[]{r, c});
                    visited[r][c]=true;
                    answer++;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        for(int k = 0; k < 4; k++){
                            int nextR = cur[0] + dr[k];
                            int nextC = cur[1] + dc[k];
                            if(isValid(nextR, nextC)){
                                if(!visited[nextR][nextC] && sky[nextR][nextC]==1){
                                    q.offer(new int[]{nextR, nextC});
                                    visited[nextR][nextC]=true;
                                }
                            }
                        }
                    }
                }
            }
        }



        return (answer);
    }

    public static void main(String[] args) {
//        sky=new int[][]{
//                {0, 1, 1, 1, 0},
//                {1, 0, 1, 1, 0},
//                {1, 0, 0, 0, 0},
//                {0, 0, 0, 1, 0}
//        };
//        sky=new int[][]{
//                {1,1,1,0,0},
//                {1,0,0,0,0},
//                {1,0,0,0,1},
//                {0,0,1,1,0}
//        };
        sky=new int[][]{
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,1,1,0},
                {0,0,0,1,1}
        };
        rowLength=sky.length;
        colLength=sky[0].length;

        visited=new boolean[rowLength][colLength];
        int an=solve(sky);
        System.out.println(an);


    }
}
