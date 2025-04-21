package poly2.instance;

public class InstanceMain2 {
    public static void main(String[] args) {
        Parent[] family ={new Parent(),new Child(),new GrandChild()};

        for(Parent p:family){
            testInstanceOf(p);
        }
    }

    static void testInstanceOf(Parent p){
        p.parentMethod();

        if(p instanceof Child){  //타입 가드로 인스턴스 확인했으니 사라진다.
            System.out.println("매개 변수로 들어온 p가 Child의 인스턴스가 맞음");
            ((Child)p).childMethod(); //명시적 형변환
        }
        if(p instanceof GrandChild){  //타입 가드로 인스턴스 확인했으니 사라진다.
            System.out.println("매개 변수로 들어온 p가 GrandChild의 인스턴스가 맞음");
            ((GrandChild)p).grandChildMethod(); //명시적 형변환
        }
    }
}
