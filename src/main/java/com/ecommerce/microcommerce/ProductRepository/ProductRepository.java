package com.ecommerce.microcommerce.ProductRepository;

import com.ecommerce.microcommerce.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
