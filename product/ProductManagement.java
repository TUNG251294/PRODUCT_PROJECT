package PRODUCT_MANAGEMENT_PROJECT.product;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ProductManagement {
    private HashMap<Product,Integer> products;
    private final String PATH = "PRODUCT_MANAGEMENT_PROJECT/product/productList.csv";
    private static ProductManagement productManagement = new ProductManagement();
    public static ProductManagement getProductManagement(){
        return productManagement;
    }
    private ProductManagement(){
        products = new HashMap<>();
        Product product1 = new Product("1", "abc", 299, new Date(2022, 8, 10), 5);

        products.put(product1, product1.getQuantity());
    }

    public void add(Product p){
        products.put(p,p.getQuantity());
    }

    public void remove(String id){
        Product productSearch = searchByID(id);
        if(productSearch != null){
            products.remove(productSearch);
        }
    }

    public void update(String id, String name,double price,Date expiry, int quantity){
        Product productSearch = searchByID(id);
        if(productSearch != null){
            productSearch.setId(id);
            productSearch.setName(name);
            productSearch.setPrice(price);
            productSearch.setExpiry(expiry);
            productSearch.setQuantity(quantity);
        }
    }

    public ArrayList<Product> searchByName(String name){
        Set<Product> keys = products.keySet();
        ArrayList<Product> arr = null;
        for (Product p: keys){
            if(p.getName().equals(name)){
                arr.add(p);
                return arr;
            }
        }
        return null;
    }

    public Product searchByID(String id){
        Set<Product> keys = products.keySet();
        for (Product p: keys){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }
    public void saveToFile(){
        try {
//            Set<Product> keys = products.keySet();

            FileWriter fileWriter = new FileWriter(PATH);
            BufferedWriter cache = new BufferedWriter(fileWriter);
            for (Map.Entry<Product, Integer> p: products.entrySet()){
                cache.write(p.getKey().toString());
                cache.write(",");
                cache.write(p.getValue());
                cache.newLine();
            }
            cache.close();
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        products.clear();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader cache02 = new BufferedReader(fileReader);
            String line;
            Product p;
            while ((line = cache02.readLine()) != null){
                p = handLine(line);
                System.out.println(p);
                products.put(p,p.getQuantity());
                System.out.println(products);

            }
            cache02.close();
            fileReader.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public Product handLine(String line){
        String[] str = line.split(",");
      DateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");
//        Date expiry = simpleDateFormat.format(str[3]);
        Product newProduct = null;
        try {
            newProduct = new Product(str[0],str[1],Double.parseDouble(str[2]), dateFormat.parse(str[3]) ,Integer.parseInt(str[4]));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return newProduct;
    }

    String display(){
        String productList = "";
//        Set<Product> keys = products.keySet();
//        System.out.println(keys);
        for (Map.Entry<Product, Integer> p: products.entrySet()){
            productList += p.toString() + "\n";
        }
        return productList;
    }
}