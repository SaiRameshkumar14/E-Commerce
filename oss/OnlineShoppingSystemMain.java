package com.flex.java.oss;

import com.flex.java.oss.service.AdminServiceImpl;
import com.flex.java.oss.service.CustomerServiceImpl;

import java.util.Scanner;

public class OnlineShoppingSystemMain {

    public static void main(String[] args) {
        System.out.println("---- Welcome To Online Shopping System ----");
        OnlineShoppingSystemMain onlineShoppingSystemMain = new OnlineShoppingSystemMain();
        onlineShoppingSystemMain.mainMenu();
    }

    public void mainMenu() {
        AdminServiceImpl adminServiceimpl = new AdminServiceImpl();
        CustomerServiceImpl customerService = new CustomerServiceImpl();

        Scanner scan = new Scanner(System.in);

        System.out.println(adminServiceimpl.frontAlign + "MAIN MENU" + adminServiceimpl.backAlign);

        String mainMenu = """
                1. Admin User
                2. Customer
                3. Exit
                """;

        System.out.println(mainMenu);
        System.out.print("Enter Your Choice : ");
        int choice = scan.nextInt();

        if (choice > 3) {
            System.out.println("Enter vaild option");
        } else {
            switch (choice) {
                case 1:
                    adminServiceimpl.enterAdminRole();
                case 2:
                    customerService.enterCustomerRole();
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

}


// \t -
// \b - WelcomeCUS