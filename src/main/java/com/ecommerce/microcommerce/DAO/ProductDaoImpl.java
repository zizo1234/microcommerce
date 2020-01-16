package com.ecommerce.microcommerce.DAO;

import com.ecommerce.microcommerce.Model.Product;
import com.ecommerce.microcommerce.ProductRepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//@Repository : cette annotation est appliquée à la classe afin d'indiquer à Spring qu'il s'agit d'une classe qui
// gère les données,ce qui nous permettra de profiter de certaines fonctionnalités comme les translations des erreurs

@Service
public class ProductDaoImpl implements ProductDao {
    @Autowired
    ProductRepository repository ;






    @Override
    public List<Product>findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id).get();
    }






    @Override
    public Product addProduct(Product product) {
      return repository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        repository.save(product) ;

    }


    @Override
    public void deleteP(Long id) {
        repository.deleteById(id);
    }


}