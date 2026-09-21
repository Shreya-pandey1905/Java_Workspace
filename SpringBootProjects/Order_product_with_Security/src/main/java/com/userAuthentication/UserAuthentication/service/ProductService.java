package com.userAuthentication.UserAuthentication.service;

import com.userAuthentication.UserAuthentication.dto.ProductRequest;
import com.userAuthentication.UserAuthentication.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);

    ProductResponse getProductById(Long id);

    List<ProductResponse> getAllProducts();

    ProductResponse updateProduct(Long id, ProductRequest request);

    void deleteProduct(Long id);
}
