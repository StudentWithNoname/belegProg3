package administration;

import java.util.ArrayList;

public class CustomerManagement {
    private final ArrayList<CustomerImpl> kundenliste = new ArrayList<>();
    public ArrayList<CustomerImpl> getKundenliste() {
        return kundenliste;
    }
    public void addCustomer(CustomerImpl customer) {
        kundenliste.add(customer);
    }
    public void removeCustomer(CustomerImpl customer) {
        kundenliste.remove(customer);
    }
    public void removeCustomer(String name) {
        for (CustomerImpl customer : kundenliste) {
            if (customer.getName().equals(name)) {
                kundenliste.remove(customer);
                break;
            }
        }
    }
    public CustomerImpl getCustomer(String name) {
        for (CustomerImpl customer : kundenliste) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
    public void printCustomers() {
        for (CustomerImpl customer : kundenliste) {
            System.out.println(customer.getName());
        }
    }


}
