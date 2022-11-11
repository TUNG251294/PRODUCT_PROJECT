//package PRODUCT_MANAGEMENT_PROJECT.product;
//
//import java.io.*;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//
//public class ProductManagement {
//    private ArrayList<Product> products;
//    private final Integer MILLI_SECOND_ON_DAY = 86400000;
//    private final String PATH = "PRODUCT_MANAGEMENT_PROJECT/product/productList.csv";
//    private static ProductManagement productManagement = new ProductManagement(); /*static chi new 1 lan khi chay ung dung*/
//    public static ProductManagement getProductManagement(){
//        return productManagement;
//    }
//    public ProductManagement(){
//        products = new ArrayList<>();
//        saveToFile();   /*neu chua co file thi ham nay tao ra file*/
//
//        Product p1 = new Product("vina01","Vinamilk",35000,new Date(122,12,31),100);    /*add cung*/
//        Product p2 = new Product("vina02","Vinamilk",37000,new Date(123,01,31),200);
//        Product p3 = new Product("milo01","Milo",28000,new Date(123,06,30),150);
//        products.add(p1);
//        products.add(p2);
//        products.add(p3);
//        saveToFile();
//
//        readFromFile();
//    }
//
//    public void add(Product p){ /*BUG- do xem id da ton tai chua*/
//        products.add(p);
//        saveToFile();
//    }
//
//    public void remove(String id){
//        Product productSearch = searchByID(id);
//        if(productSearch != null){
//            products.remove(productSearch);
//            saveToFile();
//        }
//    }
//
//    public void update(String id, String name,double price,Date expiry, int quantity){
//        Product productSearch = searchByID(id);
//        if(productSearch != null){
//            productSearch.setId(id);
//            productSearch.setName(name);
//            productSearch.setPrice(price);
//            productSearch.setExpiry(expiry);
//            productSearch.setQuantity(quantity);
//            saveToFile();
//        }
//    }
//
////    public void expired(){
////        Iterator productsIterator = products.iterator();
////        while (productsIterator.hasNext()){
////            Product p = products.iterator().next();
////            Date date = new Date();                           /*de tham khao chu sai roi*/
////            if(date.after(p.getExpiry())){
////                products.remove(p);
////            }
////        }
////        saveToFile();
////    }
//
//
//    public void expired(){
//        for (int i = 0; i < products.size(); i++) {
//            Date date = new Date();
//            Product p = products.get(i);
//            if (date.after(p.getExpiry())) {
//                products.remove(p);
//            }
//        }
//        saveToFile();
//    }
//
//    public long dayDiff(String id){ /*tra ve so ngay giua HSD va hien tai*/
//        Product p = searchByID(id);
//        Date date = new Date();
//        Date dateExpiry = p.getExpiry();
//        long diff = dateExpiry.getTime() - date.getTime();
//        long dayDiff = diff/(MILLI_SECOND_ON_DAY);
//        return dayDiff;
//    }
//
//    public ArrayList<Product> almostExpired(){  /*tra ve arraylist product co expiry <30days*/
//        ArrayList<Product> arrayList = new ArrayList<>();
//        for(Product p: products){
//            String id = p.getId();
//            if(dayDiff(id) <= 30){
//                arrayList.add(p);
//            }
//        }
//        return arrayList;   /*nhung ham khong co anh huong len kho thi khong co saveToFile()
//         */
//    }
//    public ArrayList<Product> searchByName(String name){    /*Neu Map thi dung Set<Product> keys = products.keySet(); de duyet phan tu*/
//        ArrayList<Product> arrList = new ArrayList<>();
//        for (Product p: products){
//            if(p.getName().equals(name)){
//                arrList.add(p);
//            }
//        }
//        return arrList;
//    }
//
//    public Product searchByID(String id){
//        for (Product p: products){    /*Neu Map thi dung for (Map.Entry<Product,Integer> p: products.entrySet()) de duyet*/
//            if(p.getId().equals(id)){
//                return p;
//            }
//        }
//        return null;
//    }
//    public void saveToFile(){
//        try {
//            FileWriter fileWriter = new FileWriter(PATH);
//            BufferedWriter cache = new BufferedWriter(fileWriter);
//            for (Product p: products){
//                cache.write(p.toString());  //Neu dung Map thi co them 1 dau phay va 1 gia tri value nên se them cache.write(",");
//                cache.newLine();            //cache.write(p.getValue().toString());
//            }
//            cache.close();
//            fileWriter.close();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public void readFromFile(){
//        products.clear();
//        try {
//            FileReader fileReader = new FileReader(PATH);
//            BufferedReader cache02 = new BufferedReader(fileReader);
//
//            String line = "";
//            Product p;
//            while ((line = cache02.readLine()) != null){
//                p = handLine(line);
//                products.add(p);
//            }
//            cache02.close();
//            fileReader.close();
//        } catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//
//    public Product handLine(String line){
//        String[] str = line.split(",");
//        DateFormat dateFormat= new SimpleDateFormat("MM/dd/yyyy");
//        Product newProduct;
//        try {
//            newProduct = new Product(str[0],str[1],Double.parseDouble(str[2]), dateFormat.parse(str[3]) ,Integer.parseInt(str[4]));
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        return newProduct;
//    }
//
//    String display(){
//        productManagement.expired();    /*khi cho ra san pham co trong kho thi loai bo san pham da qua han truoc*/
//        String productList = "";
//        for (Product p: products){
//            productList += p.toString() + "\n";
//        }
//        return productList;
//    }
//}