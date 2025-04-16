package prac.week2;

public class Computer {

    int sum(int a, int b, int c) {
        return a+b+c;
    }
    int sum(int a, int b, int c,int d,int e) {
        return a+b+c+d+e;
    }
    int sum(int ... values){
        int sumArr=0;
        for(int i=0;i<values.length;i++){
            sumArr+=values[i];
        }
        return sumArr;
    }
//    int sum(int ... values)

}
