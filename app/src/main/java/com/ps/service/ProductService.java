package com.flex.ps.service;

import com.flex.ps.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService{

    ResponseEntity<List<ProductDTO>> toGetAllProducts();

    ResponseEntity<ProductDTO> toGetSingleProduct(int id);

    ResponseEntity<String> toCreateProduct(ProductDTO productDTO);

    ResponseEntity<String> toUpdateProduct(int id, ProductDTO productDTO);

    ResponseEntity<String> toPatchUpdateProduct(int id, ProductDTO productDTO);

    ResponseEntity<String> toDeleteProduct(int id);
}
