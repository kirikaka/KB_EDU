package nested.anonymous.dice;

import java.util.Random;

public class CompletedMain {
    public static void complicatedProgram(Dice dice){
        System.out.println("프로그램 시작 작업");

        //받아온 코드 실행
        dice.run();

        System.out.println("프로그램 종료 작업");
    }
    static class DiceProgram implements Dice {
        @Override
        public void run() {
            //코드 조각 시작
            int rand=new Random().nextInt(6)+1;
            System.out.println("주사위 값은 "+rand);
        }
    }

    public static void main(String[] args) {
        complicatedProgram(new DiceProgram());
    }
}
