package com.flex.java.oss.service;

public interface OrderService {

    void enterOrder();

    void toCreateOrder();

    void toViewProducts();

    String validateUserId(int userId);

    String validateProductId(int productId);
}
