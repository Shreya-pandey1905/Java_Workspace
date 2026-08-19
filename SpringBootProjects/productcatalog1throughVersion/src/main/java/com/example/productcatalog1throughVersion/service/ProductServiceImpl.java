package com.example.productcatalog1throughVersion.service;

import com.example.productcatalog1throughVersion.entity.Products;
import com.example.productcatalog1throughVersion.repository.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    @Override
    public Page<Products> findByCategory(int page, int size, String sortBy, String direction) {
        Sort sort;
        if (direction.equalsIgnoreCase("desc")){
            sort=Sort.by(sortBy).descending();
        }else {
            sort= Sort.by(sortBy).ascending();
        }
        Pageable pageable  = PageRequest.of(page,size,sort);
        return productsRepo.findBy()
    }

}
