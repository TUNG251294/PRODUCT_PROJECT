//package PRODUCT_MANAGEMENT_PROJECT.order;
//
//import PRODUCT_MANAGEMENT_PROJECT.product.ProductManagement;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class OrderManagement {
//    private ArrayList<Order> orders;
//    private static OrderManagement orderManagement = new OrderManagement();
//    private final String PATH = "PRODUCT_MANAGEMENT_PROJECT/order/orderList.csv";
//    ProductManagement productManagement = ProductManagement.getProductManagement();
//
//    public OrderManagement(){
//        orders = new ArrayList<>();
//        readFromFile(); /*Neu chua co file csv thi se bao ngoai le, nhung khong sao, chuong trinh van chay binh thuong*/
//
////        Order order1 = new Order("c01",new Date(122,11,30));
////        Order order2 = new Order("c01",new Date("11/07/2022"));
////        orders.add(order1);
////        orders.add(order2);
////        saveToFile();
//
//    }
//    public static OrderManagement getOrderManagement(){
//        return orderManagement;
//    }
//
//    public void add(Order order){
//        orders.add(order);
//        saveToFile();
//    }
//
//    public void remove(Order order){
//        orders.remove(order);       /*BUG- tra ve san pham lai kho hang khi remove don hang*/
//        saveToFile();
//    }
//
//    public HashMap<String,Integer> getOrderHashMap(Order order){
//        return order.getHashMap();
//    }
//    public Order searchByOrderID(int id){
//        for (Order o: orders){
//            if (o.getOderID() == id){
//                return o;
//            }
//        }
//        return null;
//    }
//
//    public HashMap<String,Integer> productSales(Date beginDay, Date endDate){
//        HashMap<String,Integer> hashMap = new HashMap<>();
//        for(Order order: orders){
//            if(order.getPurchaseDate().getTime() >= beginDay.getTime() && order.getPurchaseDate().getTime() <= endDate.getTime()){
//                HashMap<String,Integer> OrderHashMap = getOrderHashMap(order);
//
//                for(String productId: OrderHashMap.keySet()){
//                    if (hashMap.containsKey(productId)){
//                        hashMap.put(productId,OrderHashMap.get(productId) + hashMap.get(productId));
//                    } else {
//                    hashMap.put(productId,OrderHashMap.get(productId));}
//                }
//            }
//        }
//        return hashMap;
//    }
//
////        int max = Collections.max(hashMap.values());
////        for (Map.Entry<String, Integer> entry : hashMap.entrySet()){
////            if(entry.getValue() == max){
////                hashMap.put("Max sales: " + entry.getKey(),entry.getValue());
////                hashMap.remove(entry.getKey());
////            }
////        }
//
//
//    public ArrayList<Order> searchByProductID(String id){
//        ArrayList<Order> arrayList = new ArrayList<>();   /*1 loai sp co 1 id, nhung co so luong lon*/
//        for (Order o: orders){                            /*khong duoc khai bao arrayList = null*/
//            if(o.getProductID().equals(id)){
//                arrayList.add(o);
//            }
//        }
//        return arrayList;
//    }
//    public ArrayList<Order> searchByCustomerId(String id){
//        ArrayList<Order> arrayList = new ArrayList<>();  /*Customer chi co 1 id nhung co the co nhieu Order*/
//        for(Order o: orders){
//            if(o.getCustomerID().equals(id)){
//                arrayList.add(o);
//            }
//        }
//        return arrayList;
//    }
//    public void saveToFile(){
//        try {
//            FileWriter fWriter = new FileWriter(PATH);
//            BufferedWriter cache = new BufferedWriter(fWriter);
//            for (Order o: orders){
//                cache.write(o.toString());
//                cache.newLine();
//            }
//            cache.close();
//            fWriter.close();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public void readFromFile(){
//        orders.clear();
//        try {
//            FileReader fReader = new FileReader(PATH);
//            BufferedReader cache02 = new BufferedReader(fReader);
//            String line;
//            ArrayList<Order> arrList = new ArrayList<>();
//            Order o;
//            while ((line = cache02.readLine()) != null){
//                o = handleLine(line);
//                arrList.add(o);
//            }
//            cache02.close();
//            fReader.close();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    public Order handleLine(String line){
//        String[] str = line.split(",");
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        Order order = null;
//        try {
//            order = new Order(str[1],dateFormat.parse(str[4]));
//        }catch (ParseException e){
//            e.printStackTrace();
//        }
//        return order;
//    }
//    String displayOrder(){
//        String orderList = "";
//        for (Order o: orders){
//            orderList += o.toString() + "\n";
//        }
//        return orderList;
//    }
//}
