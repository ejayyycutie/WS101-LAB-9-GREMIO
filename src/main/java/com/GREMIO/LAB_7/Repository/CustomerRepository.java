package com.GREMIO.LAB_7.Repository;

import com.GREMIO.LAB_7.Customer; // IMPORTANTE: Ito ang kulang
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}