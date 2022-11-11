//package PRODUCT_MANAGEMENT_PROJECT.customer;
//
//import java.util.Scanner;
//
//public class CustomerManagementMenu{
//    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
//    Scanner scanner = new Scanner(System.in);
//    public void menu(){
//        System.out.println("Customer Management");
//        System.out.println("1.Add a customer");
//        System.out.println("2.Update a customer");
//        System.out.println("3.Remove a customer");
//        System.out.println("4.Search by customer's ID");
//        System.out.println("5.Search by customer's name");
//        System.out.println("6.Display all customers");
//        System.out.println("0.Exit");
//    }
//    public void handleMenu(){
//        int choice = -1;
//        do {
//            menu();
//            System.out.println("Input your choice");
//            choice = scanner.nextInt();
//            scanner.nextLine();
//            switch (choice){
//                case 1: addCustomer();
//                break;
//                case 2: updateCustomer();
//                break;
//                case 3: removeCustomer();
//                break;
//                case 4: searchID();
//                break;
//                case 5: searchName();
//                break;
//                case 6: displayAll();
//                break;
//                case 0:
//                    break;
//                default:
//                    break;
//            }
//        } while (choice != 0);
//    }
//
//    public void addCustomer(){
//            Scanner scanner = new Scanner(System.in);
//                int yearOB = 0;
//                System.out.println("create new account! Input customer's ID:");
//                String id = scanner.nextLine();
//
//                if(customerManagement.searchByCustomerID(id) != null){
//                    System.err.println("Customer id da ton tai");
//                    addCustomer();
//                    return;
//                }
//
//                System.out.println("Input customer's name");
//                String name = scanner.nextLine();
//                try {                                           /*BUG- sua nhu ham add ProductManagementMenu*/
//                    System.out.println("Input customer's Year of birth");
//                    yearOB = Integer.parseInt(scanner.nextLine());
//                } catch (NumberFormatException e){
//                    System.err.println("Nhap kieu du lieu Integer vao!");
//                    return;
//                }
//                System.out.println("Input customer's address");
//                String address = scanner.nextLine();
//                System.out.println("Input customer's numberPhone");
//                String phone = scanner.nextLine();
//            Customer newCustomer = new Customer(id,name,yearOB,address,phone);
//            customerManagement.add(newCustomer);
//
//    }
//    private void updateCustomer(){
//        System.out.println("Input customer's id");
//        String id = scanner.nextLine();
//        System.out.println("Input customer's new name");
//        String name = scanner.nextLine();
//        System.out.println("Input customer's new Year of birth");
//        int yearOB = scanner.nextInt();
//        scanner.nextLine();
//        System.out.println("Input customer's new address");
//        String address = scanner.nextLine();
//        System.out.println("Input customer's new number phone");
//        String phone = scanner.nextLine();
//
//        customerManagement.update(id,name,yearOB,address,phone);
//    }
//    private void removeCustomer(){
//        System.out.println("Input customer's id");
//        String id = scanner.nextLine();
//        customerManagement.remove(id);
//    }
//    private void searchID(){
//        System.out.println("Input customer's ID");
//        String id = scanner.nextLine();
//        System.out.println(customerManagement.searchByCustomerID(id));
//    }
//    private void searchName(){  /*BUG- cho vong for chay qua arraylist de xuong hang khi ra ket qua*/
//        System.out.println("Input customer's name");
//        String name = scanner.nextLine();
//        System.out.println(customerManagement.searchByName(name));
//    }
//    private void displayAll(){
//        System.out.println(customerManagement.toString());
//    }
//
//
//}
