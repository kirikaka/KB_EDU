package poly4;

import java.util.Scanner;

public class PayMain {
    public static void main(String[] args) {
        PaySystem paySystem = new PaySystem();

        paySystem.selectPay();
        paySystem.selectAmount();
    }
}
