package com.shoppcrypto.shoppcrypto.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;
import java.util.UUID;

@Document(collection = "products")
public class Product {
    @Id
    private String id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;
    private Long fiatPrice;
    private UUID ownerId;

    public Product(String id, String title, String description, Long fiatPrice, UUID ownerId,ProductCategory productCategory) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.fiatPrice = fiatPrice;
        this.ownerId = ownerId;
        this.productCategory = productCategory;
    }

    public Product(){}

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", productCategory=" + productCategory +
                ", fiatPrice=" + fiatPrice +
                ", ownerId=" + ownerId +
                '}';
    }

    public void setId(String id){
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getId() {
        return id;
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
