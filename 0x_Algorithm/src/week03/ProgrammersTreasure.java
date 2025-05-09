package week03;

import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersTreasure {
    static int rowLength;
    static int colLength;

    static int[][] map;
    static boolean[][] visited;
    static int[][] time;

    static int[] dr={-1,1,0,0,};
    static int[] dc={0,0,-1,1,};

    static boolean shoes=false;

    static boolean isValid(int row,int col){
        return  row>=0&&row<rowLength&&col>=0&&col<colLength;
    }

    static int bfs(int row,int col){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{row,col});
        visited[row][col]=true;
        time[row][col]=0;

        while(!queue.isEmpty()){
            int [] curr=queue.poll();
            int currRow=curr[0];
            int currCol=curr[1];
            for(int i=0;i<4;i++){
                int nextRow=currRow+dr[i];
                int nextCol=currCol+dc[i];
                // 범위내와 방문 여부 확인.
                if(!isValid(nextRow,nextCol)){
                    //
                    if(map[nextRow][nextCol]==0 ){
                        queue.add(new int[]{nextRow,nextCol});
                        visited[nextRow][nextCol]=true;
                        time[nextRow][nextCol]=time[currRow][currCol]+1;

                    }
                }
            }

        }



        return time[rowLength-1][colLength-1];
    }

    public static void main(String[] args) {
        int n=4;
        int m=4;
        int[][] holes= {{2,3},{3,3}};
//        int[][] holes= {{1,4},{2,1},{2,2},{2,3},{2,4},{3,3},{4,1},{5,3}};

        int answer=0;

        rowLength=n;
        colLength=m;
        map=new int[rowLength][colLength];
        visited=new boolean[rowLength][colLength];
        time=new int[rowLength][colLength];

        // 지도에 함정 만들기.
        for(int i=0;i<holes.length;i++){
            int holeRow=holes[i][1]-1;
            int holeCol=holes[i][0]-1;

            map[holeRow][holeCol]=-1;
        }

        answer=bfs(0,0);

        if(shoes){
            System.out.println(answer-1);
//            return answer-1;
        } else{
            System.out.println(answer);
//            return answer;
        }


    }

}
