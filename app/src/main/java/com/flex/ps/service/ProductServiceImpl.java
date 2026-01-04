package com.flex.ps.service;

import com.flex.ps.dto.ProductDTO;
import com.flex.ps.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<List<ProductDTO>> toGetAllProducts() {
        return new ResponseEntity<>(productRepository.productDTOArrayList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProductDTO> toGetSingleProduct(int id) {
        for(ProductDTO productDTO : productRepository.productDTOArrayList){
            if(productDTO.getId() == id){
                return new ResponseEntity<>(productDTO, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> toCreateProduct(ProductDTO productDTO) {
        productRepository.productDTOArrayList.add(productDTO);
        return new ResponseEntity<>("Product Created Sucessfully", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> toUpdateProduct(int id, ProductDTO productDTO) {
        for (ProductDTO productDTOs : productRepository.productDTOArrayList) {
            if (productDTOs.getId() == id) {
                productDTOs.setName(productDTO.getName().toUpperCase());
                productDTOs.setDescription(productDTO.getDescription());
                productDTOs.setPrice(productDTO.getPrice());
                productDTOs.setQuantity(productDTO.getQuantity());
                return new ResponseEntity<>("Product Updated Sucessfully", HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> toPatchUpdateProduct(int id, ProductDTO productDTO) {
        for (ProductDTO productDTOs : productRepository.productDTOArrayList){
            if(productDTOs.getId() == id){
                productDTOs.setPrice(productDTO.getPrice());
                return new ResponseEntity<>("Product Price Updated Sucessfully", HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> toDeleteProduct(int id) {
        for (ProductDTO productDTO : productRepository.productDTOArrayList){
            if(productDTO.getId() == id){
                productRepository.productDTOArrayList.remove(productDTO);
                return new ResponseEntity<>("Product Removed Sucessfully",HttpStatus.ACCEPTED);
            }
        }
        return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
    }
}
