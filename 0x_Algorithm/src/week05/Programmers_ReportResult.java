package week05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Programmers_ReportResult {

    public static void main(String[] args) {
        String []id_list={"muzi", "frodo", "apeach", "neo"};
        String[] report={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k=2;

        int[] ans=solution(id_list,report,k);

        System.out.println(Arrays.toString(ans));

    }

    static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // id_list의 사용자를 키로 가지는 HashMap을 생성해서
        // 해당 사람이 신고한 사람을 가지는 HashSet을 넣는다.
        // -> 한 사람이 여러번 신고했어도 한번만 카운트 된다.
        HashMap<String, HashSet<String>> reportList = new HashMap<>();

        //신고횟수를 세는 HashMap을 생성해서 신고횟수 카운트하기.
        HashMap<String,Integer> reportCount=new HashMap<>();

        for(int i=0;i<id_list.length;i++){
            reportList.put(id_list[i], new HashSet<String>());
            reportCount.put(id_list[i],0);
        }
        for(String s:report){
            String[] temp=s.split(" ");
            String report_name=temp[0];
            String reported_name=temp[1];
            reportList.get(report_name).add(reported_name);
        }


        for(int i=0;i<id_list.length;i++){
            String curName=id_list[i];
            // 현재 이름이 신고한 curReport를받아서
            HashSet<String> curReport=reportList.get(curName);
            if(curReport==null){
                continue;
            }
            // 이름이 몇번 신고당했는지 세기.
            for(String s:curReport){
//                reportCount.compute(s, (key, count) -> count + 1);
                int count=reportCount.get(s);
                reportCount.put(s,count+1);
            }

        }


        HashMap<String,Integer> count=new HashMap<>();
        for(String s:id_list){
            HashSet<String>tempList= reportList.get(s);
            int respondCount=0;
            for(String reportName:tempList){
                System.out.println(s+"가 신고한 "+reportName+"이 신고당한 횟수"+reportCount.get(reportName));

                if(reportCount.get(reportName)>=k){
                    respondCount++;
                }
            }
            count.put(s,respondCount);
        }

        int index=0;
        for(String s:id_list){
            answer[index]=count.get(s);
            index++;
        }








        return answer;
    }
}
