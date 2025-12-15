package com.GREMIO.LAB_7;

import jakarta.persistence.*; // Important imports for Database
import java.util.List;

@Entity // Marks this class as a database table
public class Product {

    @Id // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
    private Long id;

    private String name;
    private Double price;

    // Relationship to Invoice (Many-to-Many)
    // "mappedBy" means "products" is the field name inside Invoice.java that owns the relationship
    @ManyToMany(mappedBy = "products")
    private List<Invoice> invoices;

    // 1. Empty Constructor (Required by JPA)
    public Product() {
    }

    // 2. Constructor with Arguments
    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // 3. MANUAL GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    // Getter and Setter for Invoices (New)
    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}