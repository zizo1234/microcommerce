package com.ecommerce.microcommerce.DAO;

import com.ecommerce.microcommerce.Model.Product;
import java.util.List;

public interface ProductDao {
    public List<Product>findAll();
    public Product findById(int id);
    public void save(Product product);
}