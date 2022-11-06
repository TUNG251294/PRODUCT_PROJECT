package PRODUCT_MANAGEMENT_PROJECT.customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerManagement {
    private List<Customer> customers;
    private static CustomerManagement customerManagement = new CustomerManagement();
    public static CustomerManagement getCustomerManagement(){
        return customerManagement;
    }
    private final String PATH = "PRODUCT_MANAGEMENT_PROJECT/customer/customerList.csv";

    private CustomerManagement(){
        customers = new ArrayList<>();
        saveToFile();   /*neu chua co file thi ham nay tao ra file*/

        Customer c1 = new Customer("c01","Tung",1994,"DongNai","0353879313");
        customers.add(c1);
        saveToFile();

        readFromFile();
    }
    public void add(Customer c){
        customers.add(c);
        saveToFile();
    }
    public boolean remove(String id){
        Customer customerSearch = searchByCustomerID(id);
        if(customerSearch != null){
            customers.remove(customerSearch);
            saveToFile();
            return true;
        }
        return false;
    }
    public Customer searchByCustomerID(String id){
        for (Customer c: customers){
            if (c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }
    public ArrayList<Customer> searchByName(String name){
        ArrayList<Customer> arrayList = new ArrayList<>();
        for (Customer c: customers){
            if(c.getName().equals(name)){
                arrayList.add(c);
            }
        }
        return arrayList;
    }
    public Customer update(String id, String name, int yearOB, String address, String numberPhone){
        for (Customer c: customers){
            if(c.getId().equals(id)){
                c.setName(name);
                c.setYearOB(yearOB);
                c.setAddress(address);
                c.setNumberPhone(numberPhone);

                saveToFile();
            }
            return c;
        }
        return null;
    }
    public void saveToFile(){
        try {
            FileWriter fWriter = new FileWriter(PATH);
            BufferedWriter cache = new BufferedWriter(fWriter);
            for(Customer c: customers){
                cache.write(c.toString());
                cache.newLine();
            }
            cache.close();
            fWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readFromFile(){
        customers.clear();
        try {
            FileReader fReader = new FileReader(PATH);
            BufferedReader cache02 = new BufferedReader(fReader);
            String line;
            Customer c;
            while ((line = cache02.readLine()) != null) {
                c = handLine(line);
                customers.add(c);
            }
            cache02.close();
            fReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public Customer handLine(String line){
        String[] str = line.split(",");
        Customer newCustomer = new Customer(str[0],str[1],Integer.parseInt(str[2]),str[3],str[4]);
        return newCustomer;
    }
    @Override
    public String toString() {  /*WHAT THE HELL*/
        String listCustomer = "";
        for (Customer c: customers) {
            listCustomer += c.toString() +"\n";
        }
        return listCustomer;
    }
}

