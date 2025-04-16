package classs;

public class FishBreadMan {
    public static void main(String[] args) {
//        FishBread fish1=new FishBread();
//
//        fish1.taste="슈크립";
//        fish1.shape="잉어";
//        fish1.price=800;
        FishBread fish1=new FishBread("피자","이무기",1000);
        FishBread fish2=new FishBread();

        fish1.printFishBread();
        fish2.printFishBread();

    }
}
