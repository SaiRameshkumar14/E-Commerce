package com.flex.java.oss.service;

import com.flex.java.oss.OnlineShoppingSystemMain;
import com.flex.java.oss.dto.CustomerDTO;
import com.flex.java.oss.dto.OrderDTO;
import com.flex.java.oss.dto.ProductDTO;
import com.flex.java.oss.repository.Repository;

import java.util.Scanner;

public class OrderServiceImpl implements OrderService {

    OnlineShoppingSystemMain mainMenu = new OnlineShoppingSystemMain();
    AdminServiceImpl adminService = new AdminServiceImpl();
    Scanner scan = new Scanner(System.in);

    @Override
    public void enterOrder() {
        String customerMenu = """
                1. View Products
                2. Create Order
                3. Main Menu
                4. Exit
                """;

        System.out.println(customerMenu);
        System.out.print("Enter Your Choice : ");

        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                toViewProducts();
            case 2:
                toCreateOrder();
            case 3:
                mainMenu.mainMenu();
            case 4:
                System.exit(0);
            default:
                mainMenu.mainMenu();
        }
    }

    @Override
    public void toCreateOrder() {

        int total = 0;

        System.out.print("Enter User ID : ");
        int userId = scan.nextInt();

        System.out.println("Enter Product ID : ");
        int productId = scan.nextInt();

        System.out.println("Enter Product Quantity : ");
        int quantity = scan.nextInt();

        String userName = validateUserId(userId);
        String productName = validateProductId(productId);

        if (quantity >= 1) {
            if (!userName.equalsIgnoreCase("")) {
                if (!productName.equalsIgnoreCase("")) {

                    for (ProductDTO productDTO : Repository.productDTOList) {
                        if (productDTO.productId() == productId) {
                            total = quantity * productDTO.productPrice();
                            OrderDTO orderDTO = new OrderDTO(userId, userName, productId, productName, productDTO.productPrice(), quantity, total);
                            Repository.orderDTOList.add(orderDTO);
                            enterOrder();
                        }
                    }
                } else {
                    System.out.println(adminService.frontAlign + "Invalid Product ID" + adminService.backAlign);
                    enterOrder();
                }
            } else {
                System.out.println(adminService.frontAlign + "Invalid User ID" + adminService.backAlign);
                enterOrder();
            }
        } else {
            System.out.println("Invalid Quantity");
        }
        enterOrder();
    }

    @Override
    public void toViewProducts() {

        if (Repository.productDTOList.isEmpty()) {
            System.out.println(adminService.frontAlign + "Product List is Empty!!" + adminService.backAlign);
        } else {
            System.out.println(adminService.frontAlign + "ID     " + " Name     " + " Price     " + adminService.backAlign); //space - 5
            for (ProductDTO productDTO : Repository.productDTOList) {
                System.out.println(productDTO.productId() + "     " + productDTO.productName() + "     " + productDTO.productPrice() + adminService.backAlign);
            }
        }
        enterOrder();
    }

    @Override
    public String validateUserId(int userId) {

        for (CustomerDTO customerDTO : Repository.customerDTOList) {
            if (userId == customerDTO.getUserId()) {
                return customerDTO.getUserName();
            }
        }

        return "";
    }

    @Override
    public String validateProductId(int productId) {
        for (ProductDTO productDTO : Repository.productDTOList) {
            if (productDTO.productId() == productId) {
                return productDTO.productName();
            }
        }
        return "";
    }
}
