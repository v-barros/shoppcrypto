package com.shoppcrypto.shoppcrypto.controller;


import com.shoppcrypto.shoppcrypto.dto.ProductDto;
import com.shoppcrypto.shoppcrypto.dto.UserDto;
import com.shoppcrypto.shoppcrypto.form.ProductForm;
import com.shoppcrypto.shoppcrypto.model.Product;
import com.shoppcrypto.shoppcrypto.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final String path = "/products/{id}";

    @Autowired
    private ProductRepository productRepository;

    @PostMapping()
    @Transactional
    public ResponseEntity<ProductDto> createProduct (@RequestBody ProductForm productForm, UriComponentsBuilder uriComponentsBuilder){
        Product product = productForm.toProduct();
        Optional<Product> optionalProduct = Optional.of(productRepository.save(product));

        if(optionalProduct!=null){
           URI uri = uriComponentsBuilder.path(path).buildAndExpand(optionalProduct.get().getId()).toUri();
           return ResponseEntity.created(uri).body(new ProductDto(optionalProduct.get()));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProduct (@PathVariable String id){
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isPresent()){
            return ResponseEntity.ok(new ProductDto(optionalProduct.get()));
        }
        return ResponseEntity.notFound().build();
    }

}
