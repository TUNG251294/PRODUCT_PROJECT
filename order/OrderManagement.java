package PRODUCT_MANAGEMENT_PROJECT.order;

import PRODUCT_MANAGEMENT_PROJECT.product.Product;
import PRODUCT_MANAGEMENT_PROJECT.product.ProductManagement;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class OrderManagement {
    private ArrayList<Order> orders;
    private static OrderManagement orderManagement = new OrderManagement();
    private final String PATH = "PRODUCT_MANAGEMENT_PROJECT/order/orderList.csv";
    ProductManagement productManagement = ProductManagement.getProductManagement();

    public OrderManagement(){
        orders = new ArrayList<>();
        saveToFile();
        readFromFile();
    }
    public static OrderManagement getOrderManagement(){
        return orderManagement;
    }

    public void add(Order order){
        orders.add(order);
        String pId = order.getProductID();
        Product product = productManagement.searchByID(pId);

            int HavingProductsQuantity = product.getQuantity();
            int ProductsQuantityOnOrder = order.getOquantity();
            if(HavingProductsQuantity >= ProductsQuantityOnOrder){
            product.setQuantity(HavingProductsQuantity-ProductsQuantityOnOrder);
            } else {
                System.out.println(ProductsQuantityOnOrder - HavingProductsQuantity + " products missing!");
            }
        saveToFile();
    }

    public void remove(int id){ /*Order id dang de static dung orders.remove() bao loi, de nhat la chuyen so luong hang dat ve 0*/
        Order order = searchByOrderID(id);
        String pId = order.getProductID();
        Product product = productManagement.searchByID(pId);

        int HavingProductsQuantity = product.getQuantity();
        int ProductsQuantityOnOrder = order.getOquantity();
        product.setQuantity(HavingProductsQuantity+ProductsQuantityOnOrder);            /*Khi huy order thi so luong da order duoc cong lai vao kho*/
        order.setOquantity(0);
        saveToFile();
    }
    public Order searchByOrderID(int id){
        for (Order o: orders){
            if (o.getOderID() == id){
                return o;
            }
        }
        return null;
    }
    public ArrayList<Order> searchByProductID(String id){
        ArrayList<Order> arrayList = new ArrayList<>();   /*1 loai sp co 1 id, nhung co so luong lon*/
        for (Order o: orders){                            /*khong duoc khai bao arrayList = null*/
            if(o.getProductID().equals(id)){
                arrayList.add(o);
            }
        }
        return arrayList;
    }
    public ArrayList<Order> searchByCustomerId(String id){
        ArrayList<Order> arrayList = new ArrayList<>();  /*Customer chi co 1 id nhung co the co nhieu Order*/
        for(Order o: orders){
            if(o.getCustomerID().equals(id)){
                arrayList.add(o);
            }
        }
        return arrayList;
    }
    public void saveToFile(){
        try {
            FileWriter fWriter = new FileWriter(PATH);
            BufferedWriter cache = new BufferedWriter(fWriter);
            for (Order o: orders){
                cache.write(o.toString());
                cache.newLine();
            }
            cache.close();
            fWriter.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void readFromFile(){
        orders.clear();
        try {
            FileReader fReader = new FileReader(PATH);
            BufferedReader cache02 = new BufferedReader(fReader);
            String line;
            ArrayList<Order> arrList = new ArrayList<>();
            Order o;
            while ((line = cache02.readLine()) != null){
                o = handleLine(line);
                arrList.add(o);
            }
            cache02.close();
            fReader.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Order handleLine(String line){
        String[] str = line.split(",");
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Order order = null;
        try {
            order = new Order(str[1], str[2], Integer.parseInt(str[3]), dateFormat.parse(str[4]));
        }catch (ParseException e){
            e.printStackTrace();
        }
        return order;
    }
    String displayOrder(){
        String orderList = "";
        for (Order o: orders){
            orderList += o.toString() + "\n";
        }
        return orderList;
    }
}
