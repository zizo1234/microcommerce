package com.ecommerce.microcommerce.Model;

public class Product {
    private int id;
    private boolean transaction;
    private  float montant;
    private String productname;
    private int quantite;
    private int clientid;
    private float productpriceunity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isTransaction() {
        return transaction;
    }

    public void setTransaction(boolean transaction) {
        this.transaction = transaction;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public float getProductpriceunity() {
        return productpriceunity;
    }

    public void setProductpriceunity(float productpriceunity) {
        this.productpriceunity = productpriceunity;
    }

    public Product(int id, boolean transaction, float montant, String productname, int quantite, int clientid, float productpriceunity) {
        this.id = id;
        this.transaction = transaction;
        this.montant = montant;
        this.productname = productname;
        this.quantite = quantite;
        this.clientid = clientid;
        this.productpriceunity = productpriceunity;
    }

    public Product() {
    }

}

