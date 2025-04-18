package superr;

public class Child extends Parent {
    String name="자식 클래스";

    @Override
    void hello() {
        System.out.println("자식 클래스입니다. 안녕하세요!");
    }
    void superCall(){
        System.out.println("자신의 이름을 가져와 봅니다. "+this.name);
        System.out.println("부모의 이름을 가져옵니다. "+super.name);

        this.hello();
        super.hello();
    }
}
