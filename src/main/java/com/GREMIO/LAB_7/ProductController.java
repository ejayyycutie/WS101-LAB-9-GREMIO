package com.GREMIO.LAB_7;

import com.GREMIO.LAB_7.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // ------------------------------------------
    // QUERIES (Para sa pagkuha ng data)
    // ------------------------------------------

    @QueryMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @QueryMapping
    public Optional<Product> getProductById(@Argument Long id) {
        return productService.getProductById(id);
    }

    // ------------------------------------------
    // MUTATIONS (Para sa save, update, delete)
    // ------------------------------------------

    @MutationMapping
    public Product createProduct(@Argument String name, @Argument Double price) {
        // Gumawa tayo ng bagong product object manually
        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);
        return productService.createProduct(newProduct);
    }

    @MutationMapping
    public Product updateProduct(@Argument Long id, @Argument String name, @Argument Double price) {
        // I-set natin yung bagong details
        Product productDetails = new Product();
        productDetails.setName(name);
        productDetails.setPrice(price);

        // Return null kapag walang nahanap (safe sa GraphQL)
        return productService.updateProduct(id, productDetails).orElse(null);
    }

    @MutationMapping
    public boolean deleteProduct(@Argument Long id) {
        return productService.deleteProduct(id);
    }
}