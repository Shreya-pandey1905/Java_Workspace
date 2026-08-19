package com.example.productcatalog1throughVersion.service;

import com.example.productcatalog1throughVersion.DTO.ReqDto;
import com.example.productcatalog1throughVersion.entity.Products;
import com.example.productcatalog1throughVersion.exception.ResourceNotFoundException;
import com.example.productcatalog1throughVersion.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductsRepo productsRepo;

    @Override
    public Page<Products> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
       return productsRepo.findAll(pageable);

    }

    @Override
    public Page<Products> getProductInOrder(int page, int size, String sortBy, String direction) {
        Sort sort;
        if (direction.equalsIgnoreCase("desc")){
            sort=Sort.by(sortBy).descending();
        }else {
            sort= Sort.by(sortBy).ascending();
        }
        Pageable pageable  = PageRequest.of(page,size,sort);
        return productsRepo.findAll(pageable);
    }

    //filteration
    @Override
    public List<Products> findByCategory(String category) {
        return productsRepo.findByCategory(category);
    }

    @Override
    public Products findById(Long id) {
        return productsRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Products not found"));
    }

    @Override
    public void deleteById(Long id) {
         productsRepo.deleteById(id);
    }

    @Override
    public void createAllProducts(List<ReqDto> reqDtos) {

        List<Products> products = new ArrayList<>();

        for (ReqDto reqDto : reqDtos) {

            Products product = new Products();

            product.setName(reqDto.getName());
            product.setCategory(reqDto.getCategory());
            product.setPrice(reqDto.getPrice());
            product.setStock(reqDto.getStock());


            products.add(product);
        }

         productsRepo.saveAll(products);
    }


}
