package com.shoppcrypto.shoppcrypto.controller;


import com.shoppcrypto.shoppcrypto.business.ProductBusinessService;
import com.shoppcrypto.shoppcrypto.dto.ProductDto;
import com.shoppcrypto.shoppcrypto.form.ProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static final String path = "/products/{id}";

    @Autowired
    private ProductBusinessService productBusinessService;

    @PostMapping()
    @Transactional
    public ResponseEntity<ProductDto> createProduct (@RequestBody ProductForm productForm, UriComponentsBuilder uriComponentsBuilder){
        Optional<ProductDto> optionalProductDto = productBusinessService.createProduct(productForm);

        if(optionalProductDto.isPresent()){
           URI uri = uriComponentsBuilder.path(path).buildAndExpand(optionalProductDto.get().getId()).toUri();
           return ResponseEntity.created(uri).body(optionalProductDto.get());
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProduct (@PathVariable String id){
    Optional<ProductDto> optionalProductDto = productBusinessService.getProduct(id);

        if(optionalProductDto.isPresent()){
            return ResponseEntity.ok(optionalProductDto.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping()
    public List<ProductDto> listProducts(){
        return productBusinessService.listProducts();
    }

    @GetMapping("/search")
    public List<ProductDto> searchProducts(@RequestParam String searchText){
        return productBusinessService.listProductsByTitle(searchText);
    }
}
