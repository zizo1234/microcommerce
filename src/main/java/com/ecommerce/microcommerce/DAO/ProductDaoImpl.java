package com.ecommerce.microcommerce.DAO;

import com.ecommerce.microcommerce.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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


    @Override
    public Product addProduct(Product product) {
        Random random = new Random();
        int nextId = random.nextInt(1000) + 10;

        product.setId(nextId);
        products.add(product);

        return product;
    }

    @Override
    public void updateProduct(Product product) {
        for(Product oldProduct : products) {
            if(oldProduct.getId() == product.getId()) {
                oldProduct.setMontant(product.getMontant());
                oldProduct.setProductname(product.getProductname());
                oldProduct.setTransaction(product.isTransaction());
            }
        }

    }

    @Override
    public void deleteProduct(int id) {
        for(Product c : products) {
            if(c.getId() == id) {
                products.remove(c);
                break;
            }
        }

    }
}