package com.ecommerce.microcommerce.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.microcommerce.DAO.ProductDao;

import com.ecommerce.microcommerce.Model.Product;

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

    @PostMapping("/add")
    public void add(@RequestBody Product a) {
        productDao.save(a);
    }
}
