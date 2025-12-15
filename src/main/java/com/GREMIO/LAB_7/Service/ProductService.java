package com.GREMIO.LAB_7.Service;

import com.GREMIO.LAB_7.Product;
import com.GREMIO.LAB_7.Repository.ProductRepository; // <--- IMPORTANTE: Ito ang kulang mo!
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository; // Magiging okay na ito pagkatapos mong i-import

    // CREATE
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    // READ ALL
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // READ ONE
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // UPDATE
    public Optional<Product> updateProduct(Long id, Product productDetails) {
        return productRepository.findById(id).map(existingProduct -> {
            existingProduct.setName(productDetails.getName());
            existingProduct.setPrice(productDetails.getPrice());
            return productRepository.save(existingProduct);
        }).or(() -> Optional.empty()); // Added safety for Optional
    }

    // DELETE
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}