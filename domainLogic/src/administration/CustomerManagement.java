package administration;

import java.util.ArrayList;

public class CustomerManagement {
    private final ArrayList<CustomerImpl> kundenliste = new ArrayList<>();

    public ArrayList<CustomerImpl> getKundenliste() {
        return kundenliste;
    }

    public boolean addCustomer(String name) {
        for (CustomerImpl customer : kundenliste) {
            if (customer.getName().equals(name)) {
                return false;
            }
        }
            CustomerImpl customer1 = new CustomerImpl(name);
            kundenliste.add(customer1);
            return true;

    }

    public boolean removeCustomer(String name) {
        for (CustomerImpl customer : kundenliste) {
            if (customer.getName().equals(name)) {
                kundenliste.remove(customer);
                return true;
            }
        }
        return false;
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
