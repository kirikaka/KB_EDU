package week05;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Programmers_QueueSum {
    static long sum1;
    static long sum2;
    static Queue<Integer> q1;
    static Queue<Integer> q2;
    static int count=0;
    static long ogSum1;
    static long ogSum2;

    static long qSize;

    public static int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        sum1=0;
        sum2=0;
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        qSize = queue1.length;


        for(int i=0;i<qSize;i++){
            sum1+=queue1[i];
            sum2+=queue2[i];
            q1.offer( queue1[i]);
            q2.offer( queue2[i]);
            ogSum1+=queue1[i];
            ogSum2+=queue2[i];
        }
        boolean flag = false;

        for(int i=0;i<qSize*3;i++){


            if(sum1==sum2){
                flag = true;
                break;
            } else if(sum1>sum2){
                count++;
                int temp=q1.poll();
                q2.offer(temp);
                sum2=sum2+temp;
                sum1=sum1-temp;
            } else{
                count++;
                int temp=q2.poll();
                q1.offer(temp);
                sum1=sum1+temp;
                sum2=sum2-temp;

            }
        }
        if(flag){
            return count;
        } else{
            return -1;
        }






    }


    public static void main(String[] args) {
        int[] queue1 = new int[]{3, 2, 7, 2};
        int[] queue2 = new int[]{4, 6, 5, 1};
        int ans=solution(queue1,queue2);
        System.out.println(ans);
    }
}
