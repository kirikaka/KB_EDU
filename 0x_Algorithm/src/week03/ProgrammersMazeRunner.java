package week03;

import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersMazeRunner {
    static boolean[][] visited;
    static int[][] dist;
    static char[][] maze;
    static int level;
    static int exit;


    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    static int rowLength,colLength;

    static boolean isValid(int row,int col){
        return row>=0 && row<rowLength && col>=0 && col<colLength;
    }

    public static void main(String[] args) {
        String[] maps={"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
//        String[] maps={"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
        rowLength=maps.length;
        colLength=maps[0].length();

        maze=new char[rowLength][colLength];
        dist=new int[rowLength][colLength];

        int startRow=0,startCol=0;
        for(int i=0;i<rowLength;i++){
            for(int j=0;j<colLength;j++){
                maze[i][j]=maps[i].charAt(j);
                if(maze[i][j]=='S'){
                    startRow=i;
                    startCol=j;
                }
            }
        }
        int[] newStart=bfsLevel(startRow,startCol);
        int answer = bfsExit(newStart[0],newStart[1]);

        System.out.println(answer);


    }

    static int[] bfsLevel(int row,int col){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        visited = new boolean[rowLength][colLength];
        int[] noLevel = {-1,-1};
        dist[row][col]=0;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            System.out.println(currRow+" "+currCol+" "+dist[currRow][currCol]);


            if(maze[currRow][currCol]=='L'){
                System.out.println("FIND LEVEL");
                System.out.println(currRow+" "+currCol);
                return curr; //레버를 찾으면
            }

            for(int i=0;i<4;i++){
                int nextRow = currRow+dr[i];
                int nextCol = currCol+dc[i];
                if(isValid(nextRow,nextCol)){
                    if(!visited[nextRow][nextCol] && maze[nextRow][nextCol]!='X'){
                        dist[nextRow][nextCol]=dist[currRow][currCol]+1;
                        queue.offer(new int[]{nextRow,nextCol});
                        visited[nextRow][nextCol]=true;
                    }
                }
            }
        }

        return noLevel; // 레버를 못찾으면
    }
    static int bfsExit(int row,int col){
        if(row ==-1 && col ==-1){
            return -1;
        }


        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});

        visited = new boolean[rowLength][colLength];
        visited[row][col]=true;

        System.out.println("LEVEL DIST : " + dist[row][col]);
        System.out.println(row+" "+col);


        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            System.out.println(currRow+" "+currCol+" "+dist[currRow][currCol]);

            if(maze[currRow][currCol]=='E'){
                System.out.println("FIND EXIT");
                System.out.println(currRow+" "+currCol+" "+dist[currRow][currCol]);
                return dist[currRow][currCol];
            }

            for(int i=0;i<4;i++){
                int nextRow = currRow+dr[i];
                int nextCol = currCol+dc[i];
                if(isValid(nextRow,nextCol)){
                    if(!visited[nextRow][nextCol] && maze[nextRow][nextCol]!='X'){
                        dist[nextRow][nextCol]=dist[currRow][currCol]+1;
                        queue.offer(new int[]{nextRow,nextCol});
                        visited[nextRow][nextCol]=true;
                    }
                }
            }
        }
        return -1;
    }

}
