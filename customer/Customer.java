package PRODUCT_MANAGEMENT_PROJECT.customer;

public class Customer {
    private String id;
    private String name;
    private int yearOB;
    private String address;
    private String numberPhone;

    public Customer() {
    }

    public Customer(String id, String name, int yearOB, String address, String numberPhone) {
        this.id = id;
        this.name = name;
        this.yearOB = yearOB;
        this.address = address;
        this.numberPhone = numberPhone;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOB() {
        return this.yearOB;
    }

    public void setYearOB(int yearOB) {
        this.yearOB = yearOB;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return this.numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + this.id + '\'' +
                ", name='" + this.name + '\'' +
                ", yearOB=" + this.yearOB +
                ", address='" + this.address + '\'' +
                ", numberPhone='" + this.numberPhone + '\'' +
                '}';
    }
}
