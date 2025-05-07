package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapBasic2 {
    public static void main(String[] args) {
        ArrayList<Member> list = new ArrayList<Member>();
        list.add(new Member("testID1", "김길동1", 21, 10000.123));
        list.add(new Member("testID1", "김길동1", 21, 10000.123)); // 완전동일
        list.add(new Member("testID3", "김길동3", 23, 444000.123));
        list.add(new Member("testID2", "홍길동3", 41, 3300.123)); // ID 만 다름
        list.add(new Member("testID2", "김길동2", 22, 10000.123));

        //선언법
        Map<String,Member> map=new HashMap<>();

        //1.데이터 삽입법
        for(Member m:list){
//            map.put(m.getId(),m);

            // 덮어쓰지 않고 데이터 넣는 방법1 : 중복이면 기존과 새로운 데이터에서 판별.
            // get으로 null체크해서 넣기
            if(map.get(m.getId())==null){
                map.put(m.getId(),m);
            }
            // 덮어쓰지 않고 데이터 넣는 방법2
            if(!map.containsKey(m.getId())){
                map.put(m.getId(),m);
            }
            // 덮어쓰지 않고 데이터 넣는 방법3
            map.putIfAbsent(m.getId(),m);
        }
        map.forEach((k,v)-> System.out.println("k : "+k+" v : "+v));

        //2. 순회하는 방법
        //1) keySet - 표준 방법
        Set<String> keySet = map.keySet();
        for(String k:keySet){
            System.out.println(k+" : "+map.get(k));
        }
        System.out.println("-------------------------------------------------------");

        // 2) entrySet - key-value 둘다 쌍으로 가져오는 방법
        Set<Map.Entry<String,Member>> entrySet = map.entrySet();
        for(Map.Entry<String,Member> entry:entrySet){
            System.out.println(entry.getKey()+" : "+entry.getValue());

        }
        System.out.println("---------------------------------------------------------");

        // 3) forEach
        map.forEach((k,v)-> System.out.println(k+" : "+v));
        System.out.println("---------------------------------------------------------");

        // 3. 데이터 가져오는 방법
        // get : key를 통해 value 가져오기 key없으면 null
        System.out.println(map.get("testID1"));
        System.out.println(map.get("testID8"));

        // getOrDefault
        Member member=map.get("testID1");
        if(member==null){
            member=new Member();
        }
        System.out.println(member);




        // 4. 데이터 삭제
        Member m2=map.remove("testID1");
        System.out.println(m2);
        if(m2==null){
            System.out.println("데이터 없음");
        } else{
            System.out.println("데이터가 잇어서 삭제완료");
        }
        System.out.println("-------------------------------------------------------------");

        // 5. 수정하는 방법
        // 기본적으로 map은 덮어쓰기가 됨으로 put으로 충분
        // replace로 put과 같이 사용 가능.
        map.put("testID2",new Member("testID2", "최길동", 41, 3300.123));
        System.out.println(map.get("testID2"));
        map.replace("testID2",new Member("testID2", "최길동", 23, 3300.123));
        System.out.println(map.get("testID2"));
        System.out.println("-------------------------------------------------------------");

        // Value에 있는 개체 일부값만 변경하고 싶을때.
        map.get("testID2").setAge(254);
        System.out.println(map.get("testID2"));

        //안전한 방법
        Member m3=map.get("testID2");
        if(m3!=null){
            m3.setAge(23);
        }
        System.out.println(map.get("testID2"));

        // 6. map의 사이즈
        System.out.println(map.size());
        System.out.println(map.isEmpty());

        // 7. map 비우기
        map.clear();
        System.out.println(map);
        map=null;
        System.out.println(map);

    }
}


























