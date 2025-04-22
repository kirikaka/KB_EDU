package poly3.ex1;

public class HumanMain {
    public static void main(String[] args) {
        Human []human={new Korean(),new American(),new Spanish()};

        for(Human h:human){
            h.speak();
            h.eat();
            h.hello();
        }
    }
}
