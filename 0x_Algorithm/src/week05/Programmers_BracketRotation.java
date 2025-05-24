package week05;

import java.util.*;

public class Programmers_BracketRotation {
    public static void main(String[] args) {
        String s="[](){}";

        int answer=solution(s);
        System.out.println(answer);
    }
    public static int solution(String s) {
        int answer=0;
        for(int i=0;i<s.length();i++){
            StringBuilder sb=new StringBuilder();
            for(int idx=1;idx<s.length();idx++){
                sb.append(s.charAt(idx));
            }

            sb.append(s.charAt(0));
            s=sb.toString();
            char[] bracket = sb.toString().toCharArray();
            Stack<String> stack=new Stack<>();
            stack.push(String.valueOf(bracket[0]));
            for(int j=1;j<bracket.length;j++){
                if(stack.isEmpty()){
                    stack.push(String.valueOf(bracket[j]));
                    continue;
                }
                String popBracket=stack.pop();

                if(!matchedBracket(popBracket,String.valueOf(bracket[j]))){
                    stack.push(popBracket);
                    stack.push(String.valueOf(bracket[j]));

                }

            }

            if(stack.isEmpty()){
                answer++;
            }


        }



        return answer;
    }
    public static boolean matchedBracket(String a, String b) {
        if(a.equals("[")){
            if(b.equals("]")) return true;
        }
        if(a.equals("{")){
            if(b.equals("}")){ return  true;}
        }
        if(a.equals("(")){
            if(b.equals(")")){ return  true;}
        }
        return false;
    }
}
