package week02;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int[] dp=new int[amount+1];

        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        dp[0]=0;

        while(!q.isEmpty()){
            int cur=q.poll();
            for(int i=0;i<coins.length;i++){
//                System.out.println("현재 수 : "+(cur+coins[i]));
               if(coins[i]>amount){
                   continue;
               }
               if(cur+coins[i]<=amount && dp[cur+coins[i]]==0){

                   dp[cur+coins[i]]=dp[cur]+1;
                   q.add(cur+coins[i]);
               }
            }
            if(dp[amount]!=0){ break;}
        }
        if(dp[amount]==0) return -1;



        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins=new int[]{1,2,5};
        coinChange(coins,11);

        int[] coins1=new int[]{2};
        coinChange(coins1,3);

        int[] coins2=new int[]{1};
        coinChange(coins2,0);
    }
}
