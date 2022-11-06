package PRODUCT_MANAGEMENT_PROJECT.customer;

import PRODUCT_MANAGEMENT_PROJECT.AddCustomer;

import java.util.Scanner;

public class CustomerManagementMenu extends AddCustomer {
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
    Scanner scanner = new Scanner(System.in);
    public void menu(){
        System.out.println("Customer Management");
        System.out.println("1.Add a customer");
        System.out.println("2.Update a customer");
        System.out.println("3.Remove a customer");
        System.out.println("4.Search by customer's ID");
        System.out.println("5.Search by customer's name");
        System.out.println("6.Display all");
        System.out.println("0.Exit");
    }
    public void handleMenu(){
        int choice = -1;
        do {
            menu();
            System.out.println("Input your choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1: add();
                break;
                case 2: updateCustomer();
                break;
                case 3: removeCustomer();
                break;
                case 4: searchID();
                break;
                case 5: searchName();
                break;
                case 6: displayAll();
                break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    public void add(){
        addCustomer();
    }
    private void updateCustomer(){
        System.out.println("Input customer's id");
        String id = scanner.nextLine();
        System.out.println("Input customer's new name");
        String name = scanner.nextLine();
        System.out.println("Input customer's new Year of birth");
        int yearOB = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Input customer's new address");
        String address = scanner.nextLine();
        System.out.println("Input customer's new number phone");
        String phone = scanner.nextLine();

        customerManagement.update(id,name,yearOB,address,phone);
    }
    private void removeCustomer(){
        System.out.println("Input customer's id");
        String id = scanner.nextLine();
        customerManagement.remove(id);
    }
    private void searchID(){
        System.out.println("Input customer's ID");
        String id = scanner.nextLine();
        System.out.println(customerManagement.searchByCustomerID(id));
    }
    private void searchName(){
        System.out.println("Input customer's name");
        String name = scanner.nextLine();
        System.out.println(customerManagement.searchByName(name));
    }
    private void displayAll(){
        System.out.println(customerManagement.toString());
    }


}
