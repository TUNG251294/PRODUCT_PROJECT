//package PRODUCT_MANAGEMENT_PROJECT.order;
//
//import PRODUCT_MANAGEMENT_PROJECT.customer.Customer;
//import PRODUCT_MANAGEMENT_PROJECT.customer.CustomerManagement;
//import PRODUCT_MANAGEMENT_PROJECT.product.ProductManagement;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Scanner;
//
//public class OrderManagementMenu{
//    OrderManagement orderManagement = OrderManagement.getOrderManagement();
//    ProductManagement productManagement = ProductManagement.getProductManagement();
//    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
//    Scanner scanner = new Scanner(System.in);
//    public void menu(){
//        System.out.println("Order Management Menu");
//        System.out.println("1.Add an order");
//        System.out.println("2.Remove an order");
//        System.out.println("3.Search by an order's ID");
//        System.out.println("4.Search by a products ID");
//        System.out.println("5.Search by a customer ID");
//        System.out.println("6.Display product sales");
//        System.out.println("7.Display all orders");
//        System.out.println("0.Exit");
//    }
//    public void handleMenu(){
//        int choice = -1;
//        do{
//            menu();
//            System.out.println("Input your choice");
//            choice = Integer.parseInt(scanner.nextLine());
//
//            switch (choice){
//                case 1: addOrder();
//                break;
//                case 2: removeOrder();
//                break;
//                case 3: searchOrderID();
//                break;
//                case 4: searchProductID();
//                break;
//                case 5: searchCustomerID();
//                break;
//                case 6: displaySales();
//                break;
//                case 7: displayAllOrder();
//                break;
//                case 0:
//                    break;
//                default:
//                    break;
//            }
//        }while(choice != 0);
//    }
//    public void addOrder(){
//        productManagement.expired();    /*truoc khi tao order thi loai bo san pham da qua han trong kho, khac voi displayAllProduct vi tao object truoc khi chay ham add nen phai de ham xu ly ben managementMenu*/
//        System.out.println("Input customer ID");
//        String customerID = scanner.nextLine();
//        System.out.println("Input purchaseDate: MM/dd/yyyy");
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        Date purchaseDate = null;
//        try {
//            purchaseDate = dateFormat.parse(scanner.nextLine());
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        if(customerManagement.searchByCustomerID(customerID) == null){
//            try{
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("create new account! Input customer's ID:");
//            String id = scanner.nextLine();
//            System.out.println("Input customer's name");
//            String name = scanner.nextLine();
//            System.out.println("Input customer's Year of birth");
//            int yearOB = Integer.parseInt(scanner.nextLine());
//            System.out.println("Input customer's address");
//            String address = scanner.nextLine();
//            System.out.println("Input customer's numberPhone");
//            String phone = scanner.nextLine();
//            Customer newCustomer = new Customer(id,name,yearOB,address,phone);
//            customerManagement.add(newCustomer);  /*khi tao don hang neu phat hien customer chua có tai khoan id thi se tao*/
//            }catch (Exception e){
//                System.err.println("Error format or id invalid");
//                addOrder();
//            }
//        }
//        Order order = new Order(customerID,purchaseDate);
//        int choice = 1;
//        do {
//            System.out.println("Menu");
//            System.out.println("1.add new product");
//            System.out.println("0.complete the order!");
//            System.out.println("Input your choice");
//            choice = Integer.parseInt(scanner.nextLine());
//            switch (choice){
//                case 1:
//                    try {
//                    System.out.println("input product id");
//                    String id = scanner.nextLine();
//                    System.out.println("input product quantity on the order");
//                    int quantity = Integer.parseInt(scanner.nextLine());
//                    order.addSp(id,quantity);
//                }catch (Exception e){
//                    System.err.println("Error format or id invalid");
//                }
//                case 0:
//                    break;
//                default:
//                    break;
//            }
//        } while (choice != 0);
//
//        orderManagement.add(order);
//        System.out.println(order);  /*in ra don hang*/
//    }
//
//    public void removeOrder(){
//        System.out.println("Input order id need to remove");
//        int id = Integer.parseInt(scanner.nextLine());
//        Order order = orderManagement.searchByOrderID(id);
//        orderManagement.remove(order);
//    }
//
//    public void searchOrderID(){
//        System.out.println("Input an order id");
//        int id = Integer.parseInt(scanner.nextLine());
//        System.out.println(orderManagement.searchByOrderID(id));
//    }
//
//    public void searchProductID(){
//        System.out.println("Input a products id");
//        String id = scanner.nextLine();
//        System.out.println(orderManagement.searchByProductID(id));
//    }
//    public void searchCustomerID(){
//        System.out.println("Input a customer id");
//        String id = scanner.nextLine();
//        System.out.println(orderManagement.searchByCustomerId(id));
//    }
//    public void displaySales(){
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        try {
//            System.out.println("Input begin day to make statistics");
//            Date beginDay = dateFormat.parse(scanner.nextLine());
//            System.out.println("Input end day to make statistics");
//            Date endDay = dateFormat.parse(scanner.nextLine());
//
//            System.out.println(orderManagement.productSales(beginDay,endDay));
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//    }
//    public void displayAllOrder(){
//        System.out.println(orderManagement.displayOrder());
//    }
//}
