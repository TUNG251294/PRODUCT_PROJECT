//package PRODUCT_MANAGEMENT_PROJECT.order;
//
//import PRODUCT_MANAGEMENT_PROJECT.customer.CustomerManagement;
//import PRODUCT_MANAGEMENT_PROJECT.product.Product;
//import PRODUCT_MANAGEMENT_PROJECT.product.ProductManagement;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//public class Order {
//    ProductManagement productManagement = ProductManagement.getProductManagement();
//    CustomerManagement customerManagement = CustomerManagement.getCustomerManagement();
//
//    private int oderID;
//    private String productID;
//    private String customerID;
//    private Date purchaseDate;
//    private int orderQuantity;
//    private static int count = 0;
//    HashMap<String, Integer> hashMap = new HashMap<>();
// public HashMap<String, Integer> getHashMap(){
//     return hashMap;
// }
//    public Order() {
//    }
//
//    public Order(String customerID, Date purchaseDate) {
//        this.oderID = ++count;
//        this.customerID = customerID;
//        this.purchaseDate = purchaseDate;
//        getHashMap();
//    }
//    public void addSp(String productID, int orderQuantity){
//        Product product = productManagement.searchByID(productID);
//            int HavingProductsQuantity = product.getQuantity();
//            if(HavingProductsQuantity >= orderQuantity){
//            product.setQuantity(HavingProductsQuantity-orderQuantity);
//
//                getHashMap().put(productID,orderQuantity);  /*co du so luong san pham trong kho thi moi tao don*/
//            } else {
//                System.out.println(orderQuantity - HavingProductsQuantity + " products missing!");
//            }
//    }
//
//    public int getOderID() {
//        return this.oderID;
//    }
//
//    public static int getCount() {
//        return Order.count;
//    }
//
////    public static void setCount(int count) {
////        Order.count = count;
////    }
//
//    public String getProductID() {
//        return this.productID;
//    }
//
////    public void setProductID(String productID) {
////        this.productID = productID;
////    }
//
//    public int getorderQuantity() {
//        return this.orderQuantity;
//    }
//
//    public void setorderQuantity(int orderQuantity) {
//        this.orderQuantity = orderQuantity;
//    }
//
//    public String getCustomerID() {
//        return this.customerID;
//    }
//
////    public void setCustomerID(String customerID) {
////        this.customerID = customerID;
////    }
//
//    public Date getPurchaseDate() {
//        return this.purchaseDate;
//    }
//
//    public void setPurchaseDate(Date purchaseDate) {
//        this.purchaseDate = purchaseDate;
//    }
//
//    private String getHashMapAndTotal(){
//        String result = "";
//        int Total = 0;
//        for (Map.Entry<String,Integer> h: getHashMap().entrySet()){
//            result += "product id = " + h.getKey() +
//                    " name = " + productManagement.searchByID(h.getKey().toString()).getName() +
//                    " price = " + productManagement.searchByID(h.getKey().toString()).getPrice() +
//                    " quantity = " + h.getValue() + ",";
//            Total += h.getValue()*productManagement.searchByID(h.getKey().toString()).getPrice();
//        }
//        return result + "Total:," + Total;
//    }
//    @Override
//
//    public String toString() {
//        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//        String purchaseDateString = dateFormat.format(this.purchaseDate);   /*parse: String -> Date; format Date -> String*/
//        return this.oderID +
//                "," + this.customerID +
//                "," + customerManagement.searchByCustomerID(this.customerID).getName() +
//                "," + customerManagement.searchByCustomerID(this.customerID).getNumberPhone() +
//                "," + purchaseDateString +
//                "," + getHashMapAndTotal();
//    }
//}
