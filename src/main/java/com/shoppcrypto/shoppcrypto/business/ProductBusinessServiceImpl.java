package com.shoppcrypto.shoppcrypto.business;

import com.shoppcrypto.shoppcrypto.dto.ProductDto;
import com.shoppcrypto.shoppcrypto.form.ProductForm;
import com.shoppcrypto.shoppcrypto.model.Product;
import com.shoppcrypto.shoppcrypto.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductBusinessServiceImpl implements ProductBusinessService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<ProductDto> createProduct(ProductForm productForm) {
        Product product = productForm.toProduct();
        Optional<Product> optionalProduct = Optional.of(productRepository.save(product));
        if(optionalProduct.isPresent()){
            return Optional.of(new ProductDto(optionalProduct.get()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProductDto> getProduct(String id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent())
            return Optional.of(new ProductDto(optionalProduct.get()));
        return Optional.empty();
    }

    @Override
    public List<ProductDto> listProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product->new ProductDto(product)).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> listProductsByTitle(String title) {
        List<Product> productList =productRepository.findAllByTitleLikeText(title);
        return productList.stream().map(product -> new ProductDto(product)).collect(Collectors.toList());
    }


}
