package com.GREMIO.LAB_7.Controller; // 1. TAMA NA ANG PACKAGE NAME

// 2. IMPORTANTE: Kailangan i-import ang mga classes galing sa labas (Main package)
import com.GREMIO.LAB_7.Customer;
import com.GREMIO.LAB_7.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @MutationMapping
    public Customer createCustomer(@Argument String name, @Argument String email) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        return customerService.createCustomer(customer);
    }

    @QueryMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}