package PRODUCT_MANAGEMENT_PROJECT.product;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
    private String id;
    private String name;
    private double price;
    private Date expiry;
    private int quantity;

    public Product() {
    }

    public Product(String id, String name, double price, Date expiry, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.expiry = expiry;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpiry() {
        return expiry;
    }

    public void setExpiry(Date expiry) {
        this.expiry = expiry;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String expiry = simpleDateFormat.format(this.expiry);
        return id +
                "," + name +
                "," + price +
                "," + expiry +
                "," + quantity;
    }
}

