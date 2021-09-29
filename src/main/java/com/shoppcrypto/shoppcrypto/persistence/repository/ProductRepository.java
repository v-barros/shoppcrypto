package com.shoppcrypto.shoppcrypto.persistence.repository;

import com.shoppcrypto.shoppcrypto.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query("{ 'title' : { '$regex' : ?0 , $options: 'i'}}")
    List<Product> findAllByTitleLikeText(String text);
}
