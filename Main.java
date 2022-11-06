package PRODUCT_MANAGEMENT_PROJECT;

import PRODUCT_MANAGEMENT_PROJECT.customer.CustomerManagementMenu;

import PRODUCT_MANAGEMENT_PROJECT.order.OrderManagementMenu;
import PRODUCT_MANAGEMENT_PROJECT.product.ProductManagementMenu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("Menu");
            System.out.println("1.Display product menu");
            System.out.println("2.Display customer menu");
            System.out.println("3.Display order menu");
            System.out.println("0.Exit");

            System.out.println("Input your choice");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                ProductManagementMenu productManagementMenu = new ProductManagementMenu();
                productManagementMenu.handleMenu();
                break;
                case 2:
                CustomerManagementMenu customerManagementMenu = new CustomerManagementMenu();
                customerManagementMenu.handleMenu();
                break;
                case 3:
                OrderManagementMenu orderManagementMenu = new OrderManagementMenu();
                orderManagementMenu.handleMenu();
                break;
                case 0:
                    break;
                default:
                    break;
            }
        }while(choice != 0);
    }
}
