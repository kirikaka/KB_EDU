package classs;

import java.util.Date;

public class FishBread {
    String taste="팥";
    String shape="붕어";
    int price=700;
    Date makeTime=new Date();

    FishBread(){}
    FishBread(String taste,String shape,int price){
        this.taste=taste;
        this.shape=shape;
        this.price=price;
    }
    void printFishBread(){
        System.out.println("붕아빵은 무슨맛임  : "+this.taste);
        System.out.println("붕아빵은 가격은  : "+this.shape);
        System.out.println("붕아빵은 모양은  : "+this.price);
        System.out.println("붕아빵은 만든 시각  : "+this.makeTime);
    }

}
