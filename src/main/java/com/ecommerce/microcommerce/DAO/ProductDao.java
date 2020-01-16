package com.ecommerce.microcommerce.DAO;

import com.ecommerce.microcommerce.Model.Product;
import java.util.List;

public interface ProductDao {
    public List<Product>findAll();
    public Product findById(Long id);
    public Product addProduct(Product product);
    public void updateProduct(Product product);
     public void deleteP (Long id);
}