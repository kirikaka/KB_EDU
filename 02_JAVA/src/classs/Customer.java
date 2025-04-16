package classs;

public class Customer {
    String name="아직 몰라요";
    int  age=0;
    int price=0;
    boolean blacklist=false;

    Customer(){}
    Customer(String name,int age,int price,boolean blacklist){
        this.name=name;
        this.age=age;
        this.price=price;
        this.blacklist=blacklist;
    }

    void printCustomer(){
        System.out.println("고객의 이름은 ? "+this.name);
        System.out.println("고객의 나이는 ? "+this.age);
        System.out.println("고객의 총 사용한 금액은 ? "+this.price);
        System.out.println("고객의 블랙리스트 여부? "+this.blacklist);
    }
}
