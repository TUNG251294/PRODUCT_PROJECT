//package PRODUCT_MANAGEMENT_PROJECT.product;
//
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Scanner;
//
//public class ProductManagementMenu {
//    ProductManagement productManagement = ProductManagement.getProductManagement();
//    Scanner scanner = new Scanner(System.in);
//
//    public void menu() {
//        System.out.println("Product Management");
//        System.out.println("1.Add a product");
//        System.out.println("2.Update a product");
//        System.out.println("3.Remove a product");
//        System.out.println("4.Display almost expired product list");
//        System.out.println("5.Search by product ID");
//        System.out.println("6.Search by product name");
//        System.out.println("7.Display all products");
//        System.out.println("0.Exit");
//    }
//
//
//    public void handleMenu() throws IOException {
//        int choice = -1;
//        do {
//            menu();
//            System.out.println("Input your choice");
//            choice = scanner.nextInt();
//            scanner.nextLine();
//            switch (choice) {
//                case 1:
//                    add();
//                    break;
//                case 2:
//                    update();
//                    break;
//                case 3:
//                    remove();
//                    break;
//                case 4: alertExpired();     /*in ra arraylist nhung product co expiry < 30days*/
//                    break;
//                case 5:
//                    searchID();
//                    break;
//                case 6:
//                    searchName();
//                    break;
//                case 7:
//                    displayAll();
//                    break;
//                case 0:
//                    break;
//                default:
//                    break;
//            }
//        } while (choice != 0);
//    }
//
//    private void add() {
//        System.out.println("Input product's ID");
//        String id = scanner.nextLine();
//
//        if(productManagement.searchByID(id) != null){
//            System.err.println("Product id da ton tai");
//            add();      /*dang su dung de quy*/
//            return;
//        }
//
//        System.out.println("Input product's name");
//        String name = scanner.nextLine();
//
//        boolean flag = true;
//        double price = 0;
//        while(flag){
//            try {
//                Scanner scanner = new Scanner(System.in);       /*Scanner chi ghi 1 lan o tren dau tien co dung khong*/
//                System.out.println("Input product's price");
//                price = scanner.nextDouble();
//                scanner.nextLine(); /*phải có .nextLine() hoặc dùng cách:    Double price = Double.parseDouble(scanner.nextLine());  */
//                flag = false;
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//
//
//        System.out.println("Input expiry: MM/dd/yyyy");
//        String str = scanner.nextLine();
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        Date expiry;
//        try {
//            expiry = dateFormat.parse(str);
//        } catch (ParseException e) {
//            e.printStackTrace();
//            add();
//            return;
//        }
//        System.out.println("Input quantity");
//        int quantity = scanner.nextInt();
//        scanner.nextLine();
//
//        Product newProduct = new Product(id, name, price, expiry, quantity);
//        productManagement.add(newProduct);
//    }
//
//    private void update(){
//        System.out.println("Input ID");
//        String id = scanner.nextLine();
//        System.out.println("Input new name");
//        String name = scanner.nextLine();
//        System.out.println("Input price");
//        Double price = scanner.nextDouble();
//        scanner.nextLine();
//
//        System.out.println("Input expiry");
//        String str = scanner.nextLine();
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        Date expiry;
//        try {
//            expiry = dateFormat.parse(str);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("Input quantity");
//
//        int quantity = scanner.nextInt();
//        scanner.nextLine();
//
//        productManagement.update(id,name,price,expiry,quantity);
//    }
//    private void remove(){
//        System.out.println("Input ID");
//        String id = scanner.nextLine();
//        productManagement.remove(id);
//    }
//
//    private void alertExpired(){
//        System.out.println(productManagement.almostExpired());
//    }
//
//    private void searchID(){
//        System.out.println("Input product's ID");
//        String id = scanner.nextLine();
//        System.out.println(productManagement.searchByID(id));
//    }
//
//    private void searchName(){ /*BUG- cho vong for chay qua arraylist de xuong hang khi ra ket qua*/
//        System.out.println("Input product's name");
//        String name = scanner.nextLine();
//        System.out.println(productManagement.searchByName(name));
//    }
//
////    private void save(){
////        productManagement.saveToFile();
////    }
////
////    private void read(){
////        productManagement.readFromFile();
////    }
//    public void displayAll(){
//        System.out.println(productManagement.display());
//    }
//}