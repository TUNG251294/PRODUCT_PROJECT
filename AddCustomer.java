package PRODUCT_MANAGEMENT_PROJECT;

import PRODUCT_MANAGEMENT_PROJECT.customer.Customer;
import PRODUCT_MANAGEMENT_PROJECT.customer.CustomerManagement;

import java.util.Scanner;

public class AddCustomer {
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
    protected void addCustomer(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("create new account! Input customer's ID:");
        String id = scanner.nextLine();
        System.out.println("Input customer's name");
        String name = scanner.nextLine();
        System.out.println("Input customer's Year of birth");
        int yearOB = Integer.parseInt(scanner.nextLine());
        System.out.println("Input customer's address");
        String address = scanner.nextLine();
        System.out.println("Input customer's numberPhone");
        String phone = scanner.nextLine();

        Customer newCustomer = new Customer(id,name,yearOB,address,phone);
        customerManagement.add(newCustomer);
    }
}
