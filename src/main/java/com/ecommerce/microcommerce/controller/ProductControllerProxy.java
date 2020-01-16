package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.Model.Client;
import com.ecommerce.microcommerce.proxy.MicroServiceProduitProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class ProductControllerProxy {
    @Autowired
    private MicroServiceProduitProxy.MicroserviceProduitsProxy ProduitsProxy;

    @RequestMapping("/")
    public List<Client> getList (Model model){

        List<> produits =  ProduitsProxy.listeDesClient();

        model.addAttribute("produits", Client);

        return getList();
    }
}
