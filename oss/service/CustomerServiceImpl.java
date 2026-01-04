package com.flex.java.oss.service;

import com.flex.java.oss.OnlineShoppingSystemMain;
import com.flex.java.oss.dto.CustomerDTO;
import com.flex.java.oss.dto.OrderDTO;
import com.flex.java.oss.repository.Repository;

import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {

    OnlineShoppingSystemMain mainMenu = new OnlineShoppingSystemMain();
    AdminServiceImpl adminService = new AdminServiceImpl();
    OrderServiceImpl orderService = new OrderServiceImpl();

    Scanner scan = new Scanner(System.in);

    long customerId = 1411L;

    @Override
    public void enterCustomerRole() {
        String customerMenu = """
                1. Create Profile
                2. View Profile
                3. Create Order
                4. History
                5. Main Menu
                6. Exist
                """;

        System.out.println(customerMenu);
        System.out.print("Enter Your Choice : ");

        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                toCreateCustomer();
            case 2:
                toViewProfile();
            case 3:
                toOrder();
            case 4:
                toViewHistoryById();
            case 5:
                mainMenu.mainMenu();
            case 6:
                System.exit(0);
            default:
                mainMenu.mainMenu();
        }
    }

    @Override
    public void toCreateCustomer() {
        System.out.print("Enter Your Name : ");
        String customerName = scan.next().toUpperCase();

        System.out.print("Enter Your Address : ");
        String customerAddress = scan.next().toUpperCase();

        System.out.print("Enter Your Email : ");
        String customerEmail = scan.next();

        if (adminService.isValidEmail(customerEmail)) {
            if (!toCheckCustomerExistense(customerName, customerEmail)) {
                CustomerDTO customerDTO = new CustomerDTO(customerId, customerName, customerEmail, customerAddress);
                Repository.customerDTOList.add(customerDTO);
                System.out.println(adminService.frontAlign + "ID : " + customerId++ + " , " + customerDTO.getUserName() + " Added Successfully" + adminService.backAlign);
                enterCustomerRole();
            } else {
                System.out.println(adminService.frontAlign + customerName + " With " + customerEmail + " is Already Exist" + adminService.backAlign);
                enterCustomerRole();
            }
        } else {
            System.out.println(adminService.frontAlign + "Enter Valid Email Address" + adminService.backAlign);
            enterCustomerRole();
        }
        enterCustomerRole();
    }

    @Override
    public boolean toCheckCustomerExistense(String customerName, String customerEmail) {

        for (CustomerDTO customerDTO : Repository.customerDTOList) {
            if (customerDTO.getUserName().equalsIgnoreCase(customerName) && customerDTO.getUserEmail().equalsIgnoreCase(customerEmail)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void toViewProfile() {

        System.out.print("Enter Your ID : ");
        int customerId = scan.nextInt();
        boolean temp = false;

        for (CustomerDTO customerDTO : Repository.customerDTOList) {
            if (customerId == customerDTO.getUserId()) {
                System.out.println(adminService.frontAlign +
                        "ID : " + customerDTO.getUserId() +
                        "\nName : " + customerDTO.getUserName() +
                        "\nAddress : " + customerDTO.getAddress() +
                        "\nEmail : " + customerDTO.getUserEmail() + adminService.backAlign);
                temp = true;
            }
        }

        if (!temp) {
            System.out.println("User ID not found : " + customerId);
        }

        enterCustomerRole();
    }


    @Override
    public void toOrder() {
        orderService.enterOrder();
    }

    @Override
    public void toViewHistoryById() {
        System.out.println("Enter Your ID : ");
        int userId = scan.nextInt();

        if (toCheckCustomerExistenseUsingId(userId)) {
            System.out.println(adminService.frontAlign +
                    "User ID   " +
                    " User Name   " +
                    " Product ID   " +
                    " Product Name   " +
                    " Price   " +
                    " Quantity   " +
                    " Total   " + adminService.backAlign); //space - 5
            for (OrderDTO orderDTO : Repository.orderDTOList) {
                if (orderDTO.userId() == userId) {
                    System.out.println(
                            orderDTO.userId() + "     " +
                                    orderDTO.userName() + "     " +
                                    orderDTO.productId() + "     " +
                                    orderDTO.productName() + "     " +
                                    orderDTO.productPrice() + "     " +
                                    orderDTO.productQuantity() + "     " +
                                    orderDTO.total()
                    );
                }
            }
        }
        enterCustomerRole();
    }
    
    @Override
    public boolean toCheckCustomerExistenseUsingId(int userId) {
        for (CustomerDTO customerDTO : Repository.customerDTOList) {
            if (customerDTO.getUserId() == userId) {
                return true;
            }
        }

        return false;
    }
}
