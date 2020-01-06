package com.ecommerce.microcommerce.DAO;

import com.ecommerce.microcommerce.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
//@Repository : cette annotation est appliquée à la classe afin d'indiquer à Spring qu'il s'agit d'une classe qui
// gère les données,ce qui nous permettra de profiter de certaines fonctionnalités comme les translations des erreurs

@Repository
public class ProductDaoImpl implements ProductDao {
    public static List<Product>products=new ArrayList<>();
    static {
        products.add(new Product(1,false,400000,"Gucci shoes",1,1,5000));
        products.add(new Product(2,false,500000,"Gucci shirt",1,1,40000));
        products.add(new Product(3,false,600000,"Gucci socks",1,1,3000));
    }


    @Override
    public List<Product>findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if(product.getId() ==id){
                return product;
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }
}