package classs;

public class CustomerMain {
    public static void main(String[] args) {
        Customer customer1=new Customer("안태현",27,1230000,true);
        customer1.printCustomer();

        Customer customer2=new Customer();
        customer2.printCustomer();



    }
}
