package com.flex.java.oss.service;

public interface CustomerService {
    void enterCustomerRole();

    void toCreateCustomer();

    boolean toCheckCustomerExistense(String customerName, String customerEmail);

    void toViewProfile();

    void toOrder();

    void toViewHistoryById();

    boolean toCheckCustomerExistenseUsingId(int userId);
}
