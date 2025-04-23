package com.company;

import java.util.Scanner;

// Strategy interface
interface ModuleStrategy {
    void execute();
}

// Admin Module Strategy
class AdminStrategy implements ModuleStrategy {
    public void execute() {
        Admin admin = new Admin();
        admin.choose();
    }
}

// Department Module Strategy
class DepartmentStrategy implements ModuleStrategy {
    public void execute() {
        Dep department = new Dep();
        department.Dep_Display();
    }
}

// Pharmacy Module Strategy
class PharmacyStrategy implements ModuleStrategy {
    public void execute() {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.display();
    }
}

// Context Class - the context class will interact with the strategies
class ModuleContext {
    private ModuleStrategy moduleStrategy;

    public void setModuleStrategy(ModuleStrategy moduleStrategy) {
        this.moduleStrategy = moduleStrategy;
    }

    public void executeModule() {
        this.moduleStrategy.execute();
    }
}

// Main Class with login and menu system
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, y;
        String u_N, password;

        System.out.println("**********************************************************************");
        System.out.println("\tTo Access Hospital System Enter LOGIN:");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("\tUSER NAME:\t");
        u_N = input.next();
        System.out.print("\tPASSWORD:\t");
        password = input.next();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("**********************************************************************");

        // Check user credentials
        if (u_N.equals("project") && password.equals("laaa")) {
            do {
                System.out.println("----------------------------------------------------------------------");
                System.out.println("          Welcome To Hospital Management System");
                System.out.println("-----------------------------------------------------------------------");
                System.out.println("1.ADMIN\t2.DEPARTMENTS\t3.PHARMACY\n");
                System.out.println("Enter option:");
                a = input.nextInt();

                // Strategy pattern context for dynamic module selection
                ModuleContext context = new ModuleContext();

                switch (a) {
                    case 1:
                        context.setModuleStrategy(new AdminStrategy());
                        context.executeModule();
                        break;
                    case 2:
                        context.setModuleStrategy(new DepartmentStrategy());
                        context.executeModule();
                        break;
                    case 3:
                        context.setModuleStrategy(new PharmacyStrategy());
                        context.executeModule();
                        break;
                    default:
                        System.out.println("Enter Valid Option From (1, 2, or 3)");
                        break;
                }

                System.out.println("To Exit System Press 1");
                y = input.nextInt();
            } while (y != 1);
        } else {
            System.out.println("***WRONG!!!!!!!USER NAME OR PASSWORD*****");
        }
    }
}
