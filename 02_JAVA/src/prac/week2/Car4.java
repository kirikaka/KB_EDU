package prac.week2;

public class Car4 {
    int gas;
    Car4(){}

    void setGas(int gas) {
        this.gas = gas;
    }
    boolean isLeftGas() {
        if (gas<=0){
            System.out.println("gas를 없습니다.");
            return false;
        } else{
            System.out.println("gas가 있습니다.");
            return true;
        }

    }
    void run(){
        System.out.println("출발합니다.");

        while(isLeftGas()) {
            System.out.printf("달립니다.(gas잔량 : %d)\n", this.gas);
            this.gas--;
        }
        System.out.printf("멈춥니다.(gas잔량 : %d)\n",this.gas);
        System.out.println("gas를 주입하세요");



    }
}
