package com.shoppcrypto.shoppcrypto.persistence.repository;

import com.shoppcrypto.shoppcrypto.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
