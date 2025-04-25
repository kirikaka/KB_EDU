package ex0423.module;

public class MeasureRunTimeExample {
    public static void main(String[] args) {
        long time1=System.nanoTime();
        int sum=0;
        for(int i=1;i<=1000000;i++){
            sum+=i;
        }
        long time2=System.nanoTime();
        System.out.println("1~1000000까지의 합 "+sum);
        System.out.println(time2-time1+"가 소요됨.");

    }
}
