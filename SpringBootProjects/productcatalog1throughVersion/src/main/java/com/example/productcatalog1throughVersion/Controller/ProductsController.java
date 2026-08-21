package com.example.productcatalog1throughVersion.Controller;

import com.example.productcatalog1throughVersion.DTO.ReqDto;
import com.example.productcatalog1throughVersion.entity.Products;
import com.example.productcatalog1throughVersion.response.ApiResponse;
import com.example.productcatalog1throughVersion.service.IdempotencyService;
import com.example.productcatalog1throughVersion.service.ProductService;
import com.example.productcatalog1throughVersion.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductsController {
    @Autowired
    IdempotencyService idempotencyService;

    @Autowired
    ProductServiceImpl productService;


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

    @PostMapping("/createProduct")
    public ResponseEntity<ApiResponse<Products>> createProduct(@RequestHeader("Idempotency-Key") String idempotencyKey,

                                                               @Valid @RequestBody ReqDto request){
        if (idempotencyService.isProcessed(idempotencyKey)){
            Long existingProductId = idempotencyService.getProductsId(idempotencyKey);
            Products existingProduct=productService.findById(existingProductId);

            ApiResponse<Products> response = ApiResponse.<Products>builder()
                    .success(true)
                    .msg("Request already processed")
                    .data(existingProduct).build();

            return ResponseEntity.status(HttpStatus.OK).body(response);


        }
        Products products = productService.createAllProducts(request);
        idempotencyService.save(idempotencyKey, products.getId());

        ApiResponse<Products> response = ApiResponse.<Products>builder().
                success(true)
                .msg("Products created successfully")
                .data(products).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<ApiResponse<Products>> updateProduct(
          //  @RequestHeader("Idempotency-Key") String idempotencyKey,
            @PathVariable Long id,
            @Valid @RequestBody ReqDto request) {

//        if (idempotencyService.isProcessed(idempotencyKey)) {
//            Long existingProductId = idempotencyService.getProductsId(idempotencyKey);
//            Products existingProduct = productService.findById(existingProductId);
//            ApiResponse<Products> response =
//                    ApiResponse.<Products>builder()
//                            .success(true)
//                            .msg("Request already processed")
//                            .data(existingProduct)
//                            .build();
//
//            return ResponseEntity.status(HttpStatus.OK).body(response);
//        }

       Products updatedProduct = productService.updateProducts(id, request);
      //  idempotencyService.save(idempotencyKey, updatedProduct.getId());

        ApiResponse<Products> response =
                ApiResponse.<Products>builder()
                        .success(true)
                        .msg("Product updated successfully")
                        .data(updatedProduct)
                        .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
