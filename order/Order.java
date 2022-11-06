package PRODUCT_MANAGEMENT_PROJECT.order;

import java.util.Date;

public class Order {
    private String oderID;
    private String productID;
    private String customerID;
    private Date purchaseDate;
    private int quantity;

    public Order() {
    }

    public Order(String oderID, String customerID, String productID, int quantity, Date purchaseDate) {
        this.oderID = oderID;
        this.customerID = customerID;
        this.productID = productID;
        this.quantity =quantity;
        this.purchaseDate = purchaseDate;
    }

    public String getOderID() {
        return this.oderID;
    }

    public void setOderID(String oderID) {
        this.oderID = oderID;
    }

    public String getProductID() {
        return this.productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
                "," + this.quantity +
                "," + this.purchaseDate;
    }
}
