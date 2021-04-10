package com.newhorizons.takeitnow.kardex.domain.entity;

public class Kardex {

    private Product product;
    private Long quantity;


    public Kardex(Product product, Long quantity) {
        this.product = product;
        this.quantity = quantity;

    }

    public Kardex() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


     public String getInformation()
    {
        return "El producto: " + product.getDescription() + " cuenta con " + quantity + "unidades en stock";
    }

}
