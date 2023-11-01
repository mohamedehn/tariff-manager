package dev.wcs.nad.tariffmanager.customer;

import dev.wcs.nad.tariffmanager.customer.model.Customer;
import dev.wcs.nad.tariffmanager.customer.model.EmployeeCustomer;
import dev.wcs.nad.tariffmanager.customer.model.JuniorCustomer;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class EmployeeCustomerTest {

    @Test
    public void shouldTestNewEmployeeCustomer() {
        // Arrange
        EmployeeCustomer employee1 = new EmployeeCustomer("1", "Alfred", "alfred@web.de", LocalDate.now().minusYears(22), LocalDate.now().minusDays(100));
        EmployeeCustomer employee2 = new EmployeeCustomer("2", "Achim", "achim@web.de", LocalDate.now().minusYears(24), LocalDate.now().minusDays(100));
        JuniorCustomer employee3 = new JuniorCustomer(15,"3", "Egon", "egon@web.de", LocalDate.now().minusYears(54), LocalDate.now().minusDays(100));

        List<Customer> customers = new ArrayList<>();
        customers.add(employee1);
        customers.add(employee2);
        customers.add(employee3);
        System.out.println(customers);

        // Act & Assert
        assertThat(employee1.calculateDiscountedPrice(100)).isEqualTo(15);
        assertThat(employee2.calculateDiscountedPrice(200)).isEqualTo(30);
    }
}
