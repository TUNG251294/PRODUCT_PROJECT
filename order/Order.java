package PRODUCT_MANAGEMENT_PROJECT.order;

import java.util.Date;

public class Order {
    private int oderID;
    private String productID;
    private String customerID;
    private Date purchaseDate;
    private int Oquantity;
    private static int count = 0;

    public Order() {
    }

    public Order(String customerID, String productID, int Oquantity, Date purchaseDate) {
        this.oderID = ++count;
        this.customerID = customerID;
        this.productID = productID;
        this.Oquantity = Oquantity;
        this.purchaseDate = purchaseDate;
    }

    public int getOderID() {
        return this.oderID;
    }

    public void setOderID(int oderID) {
        this.oderID = oderID;
    }

    public static int getCount() {
        return Order.count;
    }

    public static void setCount(int count) {
        Order.count = count;
    }

    public String getProductID() {
        return this.productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getOquantity() {
        return this.Oquantity;
    }

    public void setOquantity(int Oquantity) {
        this.Oquantity = Oquantity;
    }

    public String getCustomerID() {
        return this.customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return this.oderID +
                "," + this.customerID +
                "," + this.productID +
                "," + this.Oquantity +
                "," + this.purchaseDate;
    }
}
