package ch15.sec03.exam03;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set= new HashSet<String>();

        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String element = it.next();
            System.out.println(element);

        }
        System.out.println();

        for(String element:set){
            System.out.println(element);
        }
    }
}
