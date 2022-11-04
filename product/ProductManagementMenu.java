package PRODUCT_MANAGEMENT_PROJECT.product;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProductManagementMenu {
    ProductManagement productManagement = ProductManagement.getProductManagement();
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        System.out.println("Product Management");
        System.out.println("1.Add a product");
        System.out.println("2.Update a product");
        System.out.println("3.Remove a product");
        System.out.println("4.Search by ID");
        System.out.println("5.Search by name");
        System.out.println("6.Save from file");
        System.out.println("7.Read to file");
        System.out.println("8.Display all");
    }


    public void handleMenu() throws IOException {
        int choice = -1;
        do {
            menu();
            System.out.println("Input your choice");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    searchID();
                    break;
                case 5:
                    searchName();
                    break;
                case 6:
                    save();
                    break;
                case 7:
                    read();
                    break;
                case 8:
                    displayAll();
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while (choice != 0);
    }

    private void add() {
        System.out.println("Input ID");
        String id = scanner.nextLine();
        System.out.println("Input name");
        String name = scanner.nextLine();
        System.out.println("Input price");
        Double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Input expiry");
        String str = scanner.nextLine();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date expiry;
        try {
            expiry = dateFormat.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Input quantity");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        Product newProduct = new Product(id, name, price, expiry, quantity);
        productManagement.add(newProduct);
    }

    private void update(){
        System.out.println("Input ID");
        String id = scanner.nextLine();
        System.out.println("Input new name");
        String name = scanner.nextLine();
        System.out.println("Input price");
        Double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Input expiry");
        String str = scanner.nextLine();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date expiry;
        try {
            expiry = dateFormat.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Input quantity");

        int quantity = scanner.nextInt();
        scanner.nextLine();

        productManagement.update(id,name,price,expiry,quantity);
    }
    private void remove(){
        System.out.println("Input ID");
        String id = scanner.nextLine();
        productManagement.remove(id);
    }

    private void searchID(){
        System.out.println("Input product's ID");
        String id = scanner.nextLine();
        productManagement.searchByID(id);
    }

    private void searchName(){
        System.out.println("Input product's name");
        String name = scanner.nextLine();
        productManagement.searchByID(name);
    }

    private void save(){
        productManagement.saveToFile();
    }

    private void read(){
        productManagement.readFromFile();
    }
    public void displayAll(){
        System.out.println(productManagement.display());
    }
}