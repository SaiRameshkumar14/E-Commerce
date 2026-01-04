package com.flex.java.oss.dto;

public record OrderDTO(int userId, String userName, int productId, String productName, int productPrice,
                       int productQuantity, int total) {
}
