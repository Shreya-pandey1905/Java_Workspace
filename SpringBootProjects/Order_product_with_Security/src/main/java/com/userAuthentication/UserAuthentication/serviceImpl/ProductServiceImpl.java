package com.userAuthentication.UserAuthentication.serviceImpl;

import com.userAuthentication.UserAuthentication.dto.ProductRequest;
import com.userAuthentication.UserAuthentication.dto.ProductResponse;
import com.userAuthentication.UserAuthentication.entity.Products;
import com.userAuthentication.UserAuthentication.repository.ProductRepository;
import com.userAuthentication.UserAuthentication.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProductResponse createProduct(ProductRequest request) {

        Products product = modelMapper.map(request, Products.class);
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());
        Products savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductResponse.class);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Products> products = productRepository.findAll();
        List<ProductResponse> productList = new ArrayList<>();
        for (Products product : products) {
            productList.add(modelMapper.map(product, ProductResponse.class));
        }
        return productList;
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {

        Products product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setItemname(request.getItemName());
        product.setProductDetails(request.getProductDetails());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        product.setDiscount(request.getDiscount());
        product.setUpdatedAt(LocalDateTime.now());
        Products updatedProduct = productRepository.save(product);
        return modelMapper.map(updatedProduct, ProductResponse.class);
    }

    @Override
    public void deleteProduct(Long id) {
        Products product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product is not found"));
       productRepository.delete(product);
    }
}