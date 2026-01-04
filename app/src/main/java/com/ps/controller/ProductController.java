package com.flex.ps.controller;

import com.flex.ps.dto.ProductDTO;
import com.flex.ps.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> toGetAllProducts(){
        return productService.toGetAllProducts();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> toGetSingleProduct(@PathVariable("id") int id){
        return productService.toGetSingleProduct(id);
    }

    @PostMapping("/product")
    public ResponseEntity<String> toCreateProduct(@RequestBody ProductDTO productDTO){
        return  productService.toCreateProduct(productDTO);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> toUpdateProduct(@PathVariable("id") int id , @RequestBody ProductDTO productDTO){
        return productService.toUpdateProduct(id, productDTO);
    }

    @PatchMapping("/product/{id}")
    public ResponseEntity<String> toPatchUpdateProduct(@PathVariable("id") int id, @RequestBody ProductDTO productDTO){
        return productService.toPatchUpdateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> toDeleteProduct(@PathVariable("id") int id){
        return productService.toDeleteProduct(id);
    }
}
