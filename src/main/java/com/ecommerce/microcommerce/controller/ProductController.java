package com.ecommerce.microcommerce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.microcommerce.DAO.ProductDao;

import com.ecommerce.microcommerce.Model.Product;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;




@RestController
public class ProductController {
    //@Autowired afin que Spring se charge d'en fabriquer une instance. ProductDao a désormais accès à toutes
    // les méthodes que nous avons définies
    @Autowired
    private ProductDao productDao;

    //@RequestMapping(value="/Produitss", method= RequestMethod.GET)
    @GetMapping("/Produitss")
    public String listeProduitss() {
        return "Un exemple de produit";
    }


    @GetMapping(value = "/Produitss/{id}")
    public String afficherUnProdui(@PathVariable int id) {
        return "Vous avez demandé un produit avec l'id  " + id;
    }


    @RequestMapping(value = "/Produits", method = RequestMethod.GET)
    public List<Product> listeProduits() {
        return productDao.findAll();
    }

    //Récupérer un produit par son Id
    @GetMapping(value = "/Produits/{id}")
    public Product afficherUnProduit(@PathVariable int id) {
        return productDao.findById(id);
    }


    @PostMapping("/customer/")
    public ResponseEntity<Void> addProduct(@RequestBody Product newCustomer, UriComponentsBuilder builder){
        Product customer = productDao.addProduct(newCustomer);

        if(customer == null) {
            return ResponseEntity.noContent().build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }




    @PutMapping("/customer/")
    public ResponseEntity<Product> updateProduct(@RequestBody Product customer){
        Product c = productDao.findById(customer.getId());

        if(c == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        c.setMontant(customer.getMontant());
        c.setProductname(customer.getProductname());
        c.setTransaction(customer.isTransaction());

        productDao.updateProduct(c);
        return new ResponseEntity<Product>(c, HttpStatus.OK);
    }


    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<Product> deleteProduct(@PathVariable int productId){
        Product c = productDao.findById(productId);

        if(c == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }

        productDao.deleteProduct(productId);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }



}