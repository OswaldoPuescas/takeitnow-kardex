package com.newhorizons.takeitnow.kardex.application.mainmodule.dto;

import com.newhorizons.takeitnow.kardex.domain.entity.Product;

public class KardexDto {

    private ProductDto product;
    private long quantity;


    public KardexDto() {
    }

    public KardexDto(ProductDto product, long quantity) {
        this.product = product;
        this.quantity = quantity;

    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }


    public String getInformation()
    {
        return "El producto: " + product.getName() + " cuenta con " + quantity + "unidades en stock";
    }
}