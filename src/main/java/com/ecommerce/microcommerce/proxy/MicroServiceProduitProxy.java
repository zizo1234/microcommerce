package com.ecommerce.microcommerce.proxy;

import com.ecommerce.microcommerce.Model.Client;
import com.ecommerce.microcommerce.Model.Product;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class MicroServiceProduitProxy {
    @FeignClient(name = "ServiceClient", url = "localhost:9001")
    public interface MicroserviceProduitsProxy {

        @GetMapping(value = "/Client")
        List<Client> listeDesClient();



    }
}
