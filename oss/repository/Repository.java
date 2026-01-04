package com.flex.java.oss.repository;

import com.flex.java.oss.dto.AdminDTO;
import com.flex.java.oss.dto.CustomerDTO;
import com.flex.java.oss.dto.OrderDTO;
import com.flex.java.oss.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    public static List<CustomerDTO> customerDTOList = new ArrayList<>();
    public static List<ProductDTO> productDTOList = new ArrayList<>();
    public static List<AdminDTO> adminDTOList = new ArrayList<>();
    public static List<OrderDTO> orderDTOList = new ArrayList<>();
}
