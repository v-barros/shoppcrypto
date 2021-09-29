package com.shoppcrypto.shoppcrypto.form;

import com.shoppcrypto.shoppcrypto.model.Product;

import java.util.UUID;

public class ProductForm {

    private String title;
    private String description;
    private Long fiatPrice;
    private UUID ownerId;

    public ProductForm(String title, String description, Long fiatPrice, UUID ownerId) {
        this.title = title;
        this.description = description;
        this.fiatPrice = fiatPrice;
        this.ownerId = ownerId;
    }

    public Product toProduct(){
        Product product = new Product();
        product.setDescription(this.description);
        product.setFiatPrice(this.fiatPrice);
        product.setTitle(this.title);
        product.setOwnerId(this.ownerId);
        return product;
    }

    @Override
    public String toString() {
        return "ProductForm{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", fiatPrice=" + fiatPrice.toString() +
                ", ownerId=" + ownerId +
                '}';
    }

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFiatPrice() {
        return fiatPrice;
    }

    public void setFiatPrice(Long fiatPrice) {
        this.fiatPrice = fiatPrice;
    }
}
