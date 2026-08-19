package com.example.productcatalog1throughVersion.Controller;

import com.example.productcatalog1throughVersion.entity.Products;
import com.example.productcatalog1throughVersion.response.ApiResponse;
import com.example.productcatalog1throughVersion.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductsController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<ApiResponse<Page<Products>>> getAll(@RequestParam(defaultValue = "0") int page,
                                                              @RequestParam(defaultValue = "5") int size){
        Page<Products> products= productService.getAll(page,size);
        ApiResponse<Page<Products>> apiResponse =
                ApiResponse.<Page<Products>>builder().success(true).
                msg("Data retrieved successfully").data(products).build();
        return ResponseEntity.ok().body(apiResponse);


    }

    @GetMapping("/getAllBySort")
    public  ResponseEntity<ApiResponse<Page<Products>>> getBySort(@RequestParam(defaultValue = "0") int page,
                                                                  @RequestParam(defaultValue = "5") int size,
                                                                  @RequestParam(defaultValue = "id" ) String sortBy,
                                                                  @RequestParam(defaultValue = "ascending") String direction ){
        Page<Products> products= productService.getProductInOrder(page,size,sortBy,direction);
        ApiResponse<Page<Products>> apiResponse= ApiResponse.<Page<Products>>builder().success(true).
                msg("Data sorted successfully").data(products).build();
        return ResponseEntity.ok().body(apiResponse);

    }


    @GetMapping("/getByCategory/{category}")
     public ResponseEntity<ApiResponse<List<Products>>> findByCategory(@PathVariable String category){
        List<Products> products= productService.findByCategory(category);
        ApiResponse<List<Products>> apiResponse= ApiResponse.<List<Products>>builder().success(true).
                msg("Data sorted successfully").data(products).build();
        return ResponseEntity.ok().body(apiResponse);
    }


    @GetMapping("/findById/{id}")
    public ResponseEntity<ApiResponse<Products>> findById(@PathVariable Long id){
      Products products=  productService.findById(id);
        ApiResponse<Products> apiRes = ApiResponse.<Products>builder().success(true).msg("Data found").data(products).build();
        return ResponseEntity.ok().body(apiRes);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        productService.deleteById(id);
    }
}
