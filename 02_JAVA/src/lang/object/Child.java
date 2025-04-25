package lang.object;

public class Child extends Parent {

    private String name="child";
    private int age=20;

    public void childMethod(){

        System.out.println("자식 메서드");
    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


}
