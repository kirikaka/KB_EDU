package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        boolean []visiited=new boolean[k+1];
        HashSet<String> visited=new HashSet<>();
        String new_id="...!@BaT#*..y.abcdefghijklm";
        HashSet<Character> characters=new HashSet<>();



        ArrayDeque<Character> id=new ArrayDeque<>();
        char[] arr= new_id.toCharArray();
        System.out.println(arr.toString());
        id.toString();
        boolean flag=false;


        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{n,0});
        int time;
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int point=curr[0];
            time=curr[1];
            visiited[point]=true;

            if (point==k) break;



            if(point>0 && point<=k){
                if(!visiited[point]){
                    queue.offer(new int[]{point-1,time+1});

                }
            }

        }



    }

}
