package com.flex.ps.repository;

import com.flex.ps.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ProductRepository extends JpaRepository<ProductDTO, Integer> {
    List<ProductDTO> productDTOArrayList = new ArrayList<>();
}
