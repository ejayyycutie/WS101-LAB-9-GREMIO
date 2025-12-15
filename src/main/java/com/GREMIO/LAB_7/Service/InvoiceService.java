package com.GREMIO.LAB_7;

import com.GREMIO.LAB_7.Repository.CustomerRepository;
import com.GREMIO.LAB_7.Repository.InvoiceRepository;
import com.GREMIO.LAB_7.Repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    public Invoice createInvoice(Long customerId, List<Long> productIds) {
        // 1. Hanapin ang Customer
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        // 2. Hanapin ang lahat ng Products
        List<Product> products = productRepository.findAllById(productIds);

        // 3. Compute Total Amount
        Double totalAmount = products.stream().mapToDouble(Product::getPrice).sum();

        // 4. Buuin ang Invoice
        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setProducts(products);
        invoice.setTotalAmount(totalAmount);

        // 5. Save sa Database
        return invoiceRepository.save(invoice);
    }
}