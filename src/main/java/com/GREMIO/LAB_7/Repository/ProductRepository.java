package com.GREMIO.LAB_7.Repository; // Tama na 'to

import com.GREMIO.LAB_7.Product; // IMPORTANTE: Need mo i-import yung Product kasi nasa ibang folder siya
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Wala nang "public class ProductRepository" na wrapper. Diretso interface na.
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}