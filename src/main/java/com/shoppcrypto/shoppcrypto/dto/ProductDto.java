package com.shoppcrypto.shoppcrypto.dto;

import com.shoppcrypto.shoppcrypto.model.Product;
import com.shoppcrypto.shoppcrypto.model.ProductCategory;

import java.util.Objects;
import java.util.UUID;

public class ProductDto {
    private String id;
    private String title;
    private String description;
    private Long fiatPrice;
    private UUID ownerId;
    private ProductCategory productCategory;

    public ProductDto(String id, String title, String description, Long fiatPrice, UUID ownerId, ProductCategory productCategory) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.fiatPrice = fiatPrice;
        this.ownerId = ownerId;
        this.productCategory = productCategory;
    }

    public ProductDto(Product product){
        this.description = product.getDescription();
        this.fiatPrice = product.getFiatPrice();
        this.ownerId = product.getOwnerId();
        this.id = product.getId();
        this.title = product.getTitle();
        this.productCategory = product.getProductCategory();
    }

    public  ProductDto(){}

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public UUID getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(UUID ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id.equals(that.id) && ownerId.equals(that.ownerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerId);
    }
}
