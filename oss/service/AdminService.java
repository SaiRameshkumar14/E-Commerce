package com.flex.java.oss.service;

public interface AdminService {
    void enterAdminRole();

    void toCreateAdmin();

    boolean isValidEmail(String adminEmail);

    boolean tocheckAdminExistence(String adminName, String AdminEmail);

    void toViewAdminsList();

    void toRemoveAdmin();

    void toViewCustomersList();

    void toRemoveCustomer();

    void toAddProduct();

    void toViewProduct();

    void toRemoveProduct();

    void toViewOrderHistory();

}
