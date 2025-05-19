package week03;

import java.util.LinkedList;
import java.util.Queue;

public class ProgrammersCovid {
    static char[][] tables;
    static boolean[][] visited;
    static int[][] dist;


    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};

    static int[] answer;

    static boolean result;


    static boolean isValid(int row,int col){
        return row>=0 && row<5 && col>=0 && col<5;
    }

    //

    static void bfs(int row,int col){
        System.out.println("BFS 시작 : "+row+","+col);



        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{row,col});
        dist[row][col]=0;
        visited[row][col]=true;

        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int currRow=curr[0];
            int currCol=curr[1];

            if(dist[currRow][currCol]==2){
                // 거리두기를 안지키면
                System.out.println( "거리두기 실패 : "+ currRow+" "+currCol+" "+dist[currRow][currCol]);
                continue;
            }

            for(int i=0;i<4;i++){
                int nextRow=currRow+dr[i];
                int nextCol=currCol+dc[i];
                //범위 내에 있고 방문하지 않음.
                if(isValid(nextRow,nextCol) ){
                    // 다음이 파티션이면
                    if(tables[nextRow][nextCol]=='X'){
                        continue;
                    }
                    // 현재가 O이며 다음이 O이면 SKIP
                    if(tables[currRow][currCol]=='O' && tables[nextRow][nextCol]=='O' ){
                        continue;
                    }
                    // 현재가 P이며 다음이 O이면 dist+1 하고 queue에 넣기
                    if(tables[currRow][currCol]=='P' && tables[nextRow][nextCol]=='O'&& !visited[nextRow][nextCol]){
                        queue.add(new int[]{nextRow,nextCol});
                        visited[nextRow][nextCol]=true;
                        dist[nextRow][nextCol]=dist[currRow][currCol]+1;
                        continue;
                    }
                    // 현재가 P이며 다음도 P면 dist+1하고 queue에 넣기
                    if(tables[currRow][currCol]=='P' && tables[nextRow][nextCol]=='P' && !visited[nextRow][nextCol]){
                        queue.add(new int[]{nextRow,nextCol});
                        visited[nextRow][nextCol]=true;
                        dist[nextRow][nextCol]=2;
                        result=false;
                        continue;
                    }
                    //현재가 O인데 다음이 P이면 dist+1하고 queue에 넣기
                    // 현재가 O일 경우는 P 다음에 O가 온 것이므로
                    if(tables[currRow][currCol]=='O' && tables[nextRow][nextCol]=='P' && !visited[nextRow][nextCol]){
                        queue.add(new int[]{nextRow,nextCol});
                        visited[nextRow][nextCol]=true;
                        dist[nextRow][nextCol]=dist[currRow][currCol]+1;
                        continue;
                    }
                }
            }
            //queue에 들어갈 수 있는 것은 P, O


        }

    }

    public static void main(String[] args) {
        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXX", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };
        answer=new int[5];
        int index=0;


        for(String[] place:places){
            result = true;
            System.out.println("새로운 대기실 번호 : "+(index+1));

            tables=new char[5][5];
            visited=new boolean[5][5];
            dist =new int[5][5];

            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    tables[i][j]=place[i].charAt(j);
                }
            }

            for(int r=0;r<5;r++){
                for(int c=0;c<5;c++){
                    if(tables[r][c]=='P' && !visited[r][c]){
                        bfs(r,c);
                    }
                }
            }
            for(int r=0;r<5;r++){
                for(int c=0;c<5;c++){
                    if(dist[r][c]==2){
                        result = false;
                    }
                }
            }
            if(result){
                answer[index]=1;
            } else{
                answer[index]=0;
            }

            index++;

        }
        for(int i=0;i<5;i++){
            System.out.println(answer[i]);
        }

    }
}
