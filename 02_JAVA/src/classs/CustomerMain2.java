package classs;

public class CustomerMain2 {
    public static void main(String[] args) {
        Customer customer1=new Customer();
        System.out.println(customer1);

        Customer customer2=null;
        System.out.println(customer2);

        customer2=customer1;
        System.out.println(customer2);
        System.out.println(customer2.name);

    }
}
