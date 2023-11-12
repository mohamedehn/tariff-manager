package dev.wcs.nad.tariffmanager.customer.reporting.util;

import dev.wcs.nad.tariffmanager.customer.model.Customer;
import dev.wcs.nad.tariffmanager.customer.model.shared.CustomerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataImport {

    public static List<Customer> filterCustomersForType(List<Customer> customers, CustomerType type) {
        // Use Streams for Filtering
        List<Customer> customersOfType = customers.stream().filter(customer -> customer.getCustomerType() == type).collect(Collectors.toList());
        return customersOfType;
    }

    public static List<Customer> sortByName(List<Customer> customers) {
        List<Customer> mutableCustomerList = new ArrayList<>(customers);
        // with Comparator
        Collections.sort(mutableCustomerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer c1, Customer c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        // with Lambdas
        mutableCustomerList.sort((customer1, customer2) -> customer1.getName().compareTo(customer2.getName()));
        // with Method References
        mutableCustomerList.sort(Comparator.comparing(Customer::getName));
        return mutableCustomerList;
    }

    public static List<Customer> sortByLastPurchase(List<Customer> customers) {
        List<Customer> mutableCustomerList = new ArrayList<>(customers);
        // with Lambdas
        mutableCustomerList.sort((customer1, customer2) -> customer1.getLastPurchase().compareTo(customer2.getLastPurchase()));
        // with Method References
        mutableCustomerList.sort(Comparator.comparing(Customer::getLastPurchase));
        return mutableCustomerList;
    }

    public static List<Customer> sendNewsletter(List<Customer> customers) {
        List<Customer> customersSentNewsletter = new ArrayList<>();

        for (Customer customer : customers) {
            // On vérifie si le client est de type VI ou StandardCustomerWithPotential
            if (customer.getCustomerType().equals(CustomerType.VI)
                    || customer.getCustomerType().equals(CustomerType.STANDARD_WITH_POTENTIAL)) {
                // Envoie du bulletin d'information au client
                System.out.println("Hello " + customer.getName() + ", you are invited to our new product demo.");
                // Ajout du client à la liste des clients auxquels le bulletin d'information a été envoyé
                customersSentNewsletter.add(customer);
            }
        }
        return customersSentNewsletter;
    }
}
