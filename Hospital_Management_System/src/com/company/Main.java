package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice, exitFlag;
        String username, password;

        System.out.println("**********************************************************************");
        System.out.println("\tTo Access Hospital System Enter LOGIN:");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("\tUSER NAME:\t");
        username = input.next();
        System.out.print("\tPASSWORD:\t");
        password = input.next();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("**********************************************************************");

        // Check user credentials
        if (username.equals("project") && password.equals("laaa")) {
            do {
                System.out.println("----------------------------------------------------------------------");
                System.out.println("          Welcome To Hospital Management System");
                System.out.println("----------------------------------------------------------------------");
                System.out.println("1. ADMIN\t2. DEPARTMENTS\t3. PHARMACY");
                System.out.print("Enter option: ");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        Admin admin = new Admin();
                        admin.choose();
                        break;
                    case 2:
                        Dep department = new Dep();
                        department.Dep_Display();
                        break;
                    case 3:
                        Pharmacy pharmacy = new Pharmacy();
                        pharmacy.display();
                        break;
                    default:
                        System.out.println("Enter a valid option (1, 2, or 3)");
                        break;
                }

                System.out.println("To Exit System Press 1, or press any other number to continue:");
                exitFlag = input.nextInt();
            } while (exitFlag != 1);
        } else {
            System.out.println("*** WRONG USERNAME OR PASSWORD ***");
        }
    }
}