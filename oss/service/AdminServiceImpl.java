package com.flex.java.oss.service;


import com.flex.java.oss.OnlineShoppingSystemMain;
import com.flex.java.oss.dto.AdminDTO;
import com.flex.java.oss.dto.CustomerDTO;
import com.flex.java.oss.dto.OrderDTO;
import com.flex.java.oss.dto.ProductDTO;
import com.flex.java.oss.repository.Repository;

import java.util.Scanner;


public class AdminServiceImpl implements AdminService {

    public String frontAlign = "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n";
    public String backAlign = "\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    OnlineShoppingSystemMain mainMenu = new OnlineShoppingSystemMain();

    long adminId = 12180;
    long productId = 101;
    Scanner scan = new Scanner(System.in);

    @Override
    public void enterAdminRole() {

        Scanner scan = new Scanner(System.in);

        System.out.println(frontAlign + "ADMIN MENU" + backAlign);

        // java latest feature to single string for multiple line
        String adminMenu = """
                1. Create Admin
                2. View Admin
                3. Remove admin
                4. View Customers
                5. Remove Customer
                6. Add Product
                7. View Products
                8. Remove Product
                9. Order History
                10. Main Menu
                11. Exit
                """;
        System.out.println(adminMenu);

        System.out.print("Enter Your Choice : ");

        int choice = scan.nextInt();

        switch (choice) {

            case 1:
                toCreateAdmin();
            case 2:
                toViewAdminsList();
            case 3:
                toRemoveAdmin();
            case 4:
                toViewCustomersList();
            case 5:
                toRemoveCustomer();
            case 6:
                toAddProduct();
            case 7:
                toViewProduct();
            case 8:
                toRemoveProduct();
            case 9:
                toViewOrderHistory();
            case 10:
                mainMenu.mainMenu();
            case 11:
                System.exit(0);
            default:
                enterAdminRole();
        }

    }

    @Override
    public void toCreateAdmin() {
        System.out.print("Enter Admin Name : ");
        String adminName = scan.next().toUpperCase();
        System.out.print("Enter Admin Email : ");
        String adminEmail = scan.next().replaceAll(" ", "");

        if (isValidEmail(adminEmail)) {
            if (!tocheckAdminExistence(adminName, adminEmail)) {
                AdminDTO adminDTO = new AdminDTO(adminId++, adminName, adminEmail, "ADMIN");
                Repository.adminDTOList.add(adminDTO);
                System.out.println(frontAlign + adminDTO.getUserName() + " has Created Successfully." + backAlign);
            } else {
                System.out.println(frontAlign + adminName + " with " + adminEmail + " is Already Exist!!" + backAlign);
                enterAdminRole();
            }
        } else {
            System.out.println(frontAlign + "Enter Valid Email Addess" + backAlign);
        }
        enterAdminRole();
    }

    @Override
    public boolean isValidEmail(String adminEmail) {
        if (adminEmail.contains("@")) {
            String[] splitedEmal = adminEmail.split("@");
            if (splitedEmal[1].equalsIgnoreCase("gmail.com")) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean tocheckAdminExistence(String adminName, String adminEmail) {

        for (AdminDTO adminDTO : Repository.adminDTOList) {
            if (adminDTO.getUserName().equalsIgnoreCase(adminName) && adminDTO.getUserEmail().equalsIgnoreCase(adminEmail)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void toViewAdminsList() {
        int totalAdmins = 0;

        if (Repository.adminDTOList.isEmpty()) {
            System.out.println(frontAlign + "Admin List is Empty!!" + backAlign);
        } else {
            for (AdminDTO adminDTO : Repository.adminDTOList) {
                System.out.println(frontAlign +
                        "ID : " + adminDTO.getUserId() +
                        "\nName : " + adminDTO.getUserName() +
                        "\nRole : " + adminDTO.getRole() +
                        "\nEmail : " + adminDTO.getUserEmail() + backAlign);
                totalAdmins++;
            }
            System.out.println(frontAlign + "Total Admins in the List : " + totalAdmins + backAlign);
        }
        enterAdminRole();
    }

    @Override
    public void toRemoveAdmin() {
        System.out.print("Enter Admin ID :");
        int adminIdRemove = scan.nextInt();
        boolean temp = false;

        for (AdminDTO adminDTO : Repository.adminDTOList) {
            if (adminDTO.getUserId() == adminIdRemove) {
                System.out.println(frontAlign + adminDTO.getUserName() + " Removed Sucessfully" + backAlign);
                Repository.adminDTOList.remove(adminDTO);
                temp = true;
                enterAdminRole();
            }
        }

        if (!temp) {
            System.out.println(frontAlign + "Invalid User ID" + backAlign);
            enterAdminRole();
        }
        enterAdminRole();
    }

    @Override
    public void toViewCustomersList() {
        int totalAdmins = 0;

        if (Repository.customerDTOList.isEmpty()) {
            System.out.println(frontAlign + "Customer List is Empty!!" + backAlign);
        } else {
            for (CustomerDTO customerDTO : Repository.customerDTOList) {
                System.out.println(frontAlign +
                        "ID : " + customerDTO.getUserId() +
                        "\nName : " + customerDTO.getUserName() +
                        "\nAddress : " + customerDTO.getAddress() +
                        "\nEmail : " + customerDTO.getUserEmail() + backAlign);
                totalAdmins++;
            }
            System.out.println(frontAlign + "Total Customers in the List : " + totalAdmins + backAlign);
        }
        enterAdminRole();
    }

    @Override
    public void toRemoveCustomer() {
        System.out.print("Enter Customer Id : ");
        int customerId = scan.nextInt();

        for (CustomerDTO customerDTO : Repository.customerDTOList) {
            if (customerDTO.getUserId() == customerId) {
                Repository.customerDTOList.remove(customerDTO);
                enterAdminRole();
            } else {
                System.out.println("Enter Valid Customer ID!!");
                enterAdminRole();
            }
        }

        enterAdminRole();
    }

    @Override
    public void toAddProduct() {
        System.out.print("How many products : ");
        int size = scan.nextInt();
        int i = 1;

        while (size > 0) {
            System.out.print("Enter Product Name " + (i) + " :  ");
            String productName = scan.next().toUpperCase();

            System.out.print("Enter " + productName + " Price " + (i++) + " : ");
            int productPrice = scan.nextInt();

            ProductDTO productDTO = new ProductDTO(productId++, productName, productPrice);

            Repository.productDTOList.add(productDTO);
            size--;
        }
        System.out.println(frontAlign + "Products Added Successfully" + backAlign);
        enterAdminRole();
    }

    @Override
    public void toViewProduct() {
        if (Repository.productDTOList.isEmpty()) {
            System.out.println(frontAlign + "Product List is Empty!!" + backAlign);
        } else {
            System.out.println(frontAlign + "ID     " + " Name     " + " Price     " + backAlign); //space - 5
            for (ProductDTO productDTO : Repository.productDTOList) {
                System.out.println(productDTO.productId() + "     " + productDTO.productName() + "     " + productDTO.productPrice() + backAlign);
            }
        }
        enterAdminRole();
    }

    @Override
    public void toRemoveProduct() {
        System.out.print("Enter Product ID : ");
        int productIdRemove = scan.nextInt();

        for (ProductDTO productDTO : Repository.productDTOList) {
            if (productDTO.productId() == productIdRemove) {
                System.out.println(frontAlign + productDTO.productName() + " Removed Sucessfully" + backAlign);
                Repository.productDTOList.remove(productDTO);
                enterAdminRole();

            } else {
                System.out.println(frontAlign + "Invalid Product ID" + backAlign);
                enterAdminRole();

            }
        }
        enterAdminRole();
    }

    @Override
    public void toViewOrderHistory() {
        System.out.println(frontAlign + "User ID   " + " User Name   " + " Product ID   " + " Product Name   " + " Price   " + " Quantity   " + " Total   " + backAlign); //space - 5
        for (OrderDTO orderDTO : Repository.orderDTOList) {
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

        enterAdminRole();
    }

}
