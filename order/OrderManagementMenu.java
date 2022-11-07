package PRODUCT_MANAGEMENT_PROJECT.order;

import PRODUCT_MANAGEMENT_PROJECT.AddCustomer;
import PRODUCT_MANAGEMENT_PROJECT.customer.CustomerManagement;
import PRODUCT_MANAGEMENT_PROJECT.product.ProductManagement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class OrderManagementMenu extends AddCustomer {
    OrderManagement orderManagement = OrderManagement.getOrderManagement();
    ProductManagement productManagement = ProductManagement.getProductManagement();
    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
    Scanner scanner = new Scanner(System.in);
    public void menu(){
        System.out.println("Order Management Menu");
        System.out.println("1.Add an order");
        System.out.println("2.Remove an order");
        System.out.println("3.Search by an order's ID");
        System.out.println("4.Search by a products ID");
        System.out.println("5.Search by a customer ID");
        System.out.println("6.Display all orders");
        System.out.println("0.Exit");
    }
    public void handleMenu(){
        int choice = -1;
        do{
            menu();
            System.out.println("Input your choice");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1: addOrder();
                break;
                case 2: removeOrder();
                break;
                case 3: searchOrderID();
                break;
                case 4: searchProductID();
                break;
                case 5: searchCustomerID();
                break;
                case 6: displayAllOrder();
                break;
                case 0:
                    break;
                default:
                    break;
            }
        }while(choice != 0);
    }
    public void addOrder(){
        System.out.println("Input customer ID");
        String cId = scanner.nextLine();
        System.out.println("Input product ID");
        String pId = scanner.nextLine();
        System.out.println("Input products quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Input purchaseDate: MM/dd/yyyy");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date purchaseDate = null;
        try {
            purchaseDate = dateFormat.parse(scanner.nextLine());
        }catch (ParseException e){
            e.printStackTrace();
        }
        if(customerManagement.searchByCustomerID(cId) == null){
            addCustomer();  /*khi tao don hang neu phat hien customer chua có tai khoan id thi se tao*/
        }
        if(productManagement.searchByID(pId) == null){  /*de quy*/
            System.out.println("Product ID not found");
            addOrder();
            return;
        }
        Order order = new Order(cId,pId,quantity,purchaseDate);
        orderManagement.add(order);
        System.out.println(order);  /*in ra don hang*/
    }

    public void removeOrder(){
        System.out.println("Input order id need to remove");
        int id = Integer.parseInt(scanner.nextLine());
        orderManagement.remove(id);
    }

    public void searchOrderID(){
        System.out.println("Input an order id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println(orderManagement.searchByOrderID(id));
    }

    public void searchProductID(){
        System.out.println("Input a products id");
        String id = scanner.nextLine();
        System.out.println(orderManagement.searchByProductID(id));
    }
    public void searchCustomerID(){
        System.out.println("Input a customer id");
        String id = scanner.nextLine();
        System.out.println(orderManagement.searchByCustomerId(id));
    }
    public void displayAllOrder(){
        System.out.println(orderManagement.displayOrder());
    }
}
