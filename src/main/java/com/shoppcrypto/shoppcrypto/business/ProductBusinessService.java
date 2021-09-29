package com.shoppcrypto.shoppcrypto.business;

import com.shoppcrypto.shoppcrypto.dto.ProductDto;
import com.shoppcrypto.shoppcrypto.form.ProductForm;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductBusinessService {
    public Optional<ProductDto> createProduct(final ProductForm productForm);

    public Optional<ProductDto> getProduct(String id);

    public List<ProductDto> listProducts();

    public List<ProductDto> listProductsByTitle(String title);
}
