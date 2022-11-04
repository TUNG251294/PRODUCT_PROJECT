package PRODUCT_MANAGEMENT_PROJECT.customer;

public class Customer {
    private String id;
    private String name;
    private int yearOB;
    private String address;
    private String numberPhone;

    public Customer() {
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

    public int getYearOB() {
        return yearOB;
    }

    public void setYearOB(int yearOB) {
        this.yearOB = yearOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yearOB=" + yearOB +
                ", address='" + address + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                '}';
    }
}
