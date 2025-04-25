package week01;

import java.util.*;

public class temp {
    public static void main(String[] args) {
        Stack<Character> bracket=new Stack<>();
        Stack<Character> closed=new Stack<>();
        String s="([])";
        char[] open={'[','{','('};
        char[] close={']','}',')'};

        boolean ans=true;

        char[] arr=s.toCharArray();

        for(char c:arr){
            bracket.add(c);
        }


        while(!bracket.isEmpty()){
            System.out.println(closed);
            char cur=bracket.pop();
            System.out.println(" 현재 아웃 "+cur);
            int idx=0;
            if(cur=='[' || cur==']'){
                idx=0;
                System.out.println("확인된 것 : "+idx);

            } else if(cur=='{' || cur=='}'){
                idx=1;
                System.out.println("확인된 것 : "+idx);

            }  else if(cur=='(' || cur==')'){
                idx=2;
                System.out.println("확인된 것 : "+idx);
            }

            if((cur=='[') || (cur=='{') || (cur=='(')){
                System.out.println("개행");
                if( closed.getLast()==close[idx]){
                    System.out.println(closed.getLast()+ "  " + close[idx]);
                    System.out.println();
                    closed.pop();
                    System.out.println("pop하고 나서"+closed);
                    break;
                }
                else {
                    ans= false;
                }
            } else{
//                System.out.println(cur);
                closed.push(cur);
            }
        }
        System.out.println(ans);
    }
}
