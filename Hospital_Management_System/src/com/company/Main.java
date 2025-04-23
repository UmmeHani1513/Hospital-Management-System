package com.company;

import java.util.*;

// Enum for user roles
enum UserRole {
    ADMIN, DOCTOR, PATIENT
}

// Strategy interface
interface ModuleStrategy {
    void execute();
    void logActivity(String userRole);  // New logging method
}

// Admin Module Strategy
class AdminStrategy implements ModuleStrategy {
    public void execute() {
        System.out.println("Executing Admin Module...");
        Admin admin = new Admin();
        admin.choose();
    }

    public void logActivity(String userRole) {
        System.out.println(userRole + " accessed the Admin module at " + System.currentTimeMillis());
    }
}

// Department Module Strategy
class DepartmentStrategy implements ModuleStrategy {
    public void execute() {
        System.out.println("Executing Department Module...");
        Dep department = new Dep();
        department.Dep_Display();
    }

    public void logActivity(String userRole) {
        System.out.println(userRole + " accessed the Department module at " + System.currentTimeMillis());
    }
}

// Pharmacy Module Strategy
class PharmacyStrategy implements ModuleStrategy {
    public void execute() {
        System.out.println("Executing Pharmacy Module...");
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.display();
    }

    public void logActivity(String userRole) {
        System.out.println(userRole + " accessed the Pharmacy module at " + System.currentTimeMillis());
    }
}

// Session Timeout Strategy
class SessionTimeoutStrategy implements ModuleStrategy {
    private static final long TIMEOUT_LIMIT = 5000; // 5 seconds for example
    private long lastActionTime = System.currentTimeMillis();

    public void execute() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastActionTime > TIMEOUT_LIMIT) {
            System.out.println("Session expired due to inactivity.");
            System.exit(0);  // End the program
        }
        lastActionTime = currentTime;
        System.out.println("Session is active.");
    }

    public void logActivity(String userRole) {
        // Log session activity
    }
}

// Multiple Module Execution Strategy
class MultipleModulesStrategy implements ModuleStrategy {
    private List<ModuleStrategy> strategies;

    public MultipleModulesStrategy(List<ModuleStrategy> strategies) {
        this.strategies = strategies;
    }

    public void execute() {
        for (ModuleStrategy strategy : strategies) {
            strategy.execute();  // Execute multiple strategies in sequence
        }
    }

    public void logActivity(String userRole) {
        for (ModuleStrategy strategy : strategies) {
            strategy.logActivity(userRole);
        }
    }
}

// Context Class - the context class will interact with the strategies
class ModuleContext {
    private ModuleStrategy moduleStrategy;

    public void setModuleStrategy(ModuleStrategy moduleStrategy) {
        this.moduleStrategy = moduleStrategy;
    }

    public void executeModule(String userRole) {
        this.moduleStrategy.execute();
        this.moduleStrategy.logActivity(userRole);
    }
}

// Main Class with login and menu system
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a, y;
        String u_N, password;
        UserRole userRole = UserRole.PATIENT;  // Default to patient

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
            System.out.println("Enter your role (ADMIN, DOCTOR, PATIENT):");
            String role = input.next();
            try {
                userRole = UserRole.valueOf(role.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid role, defaulting to PATIENT.");
            }

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
                        if (userRole == UserRole.ADMIN) {
                            context.setModuleStrategy(new AdminStrategy());
                            context.executeModule(userRole.toString());
                        } else {
                            System.out.println("Access denied for non-admin users.");
                        }
                        break;
                    case 2:
                        context.setModuleStrategy(new DepartmentStrategy());
                        context.executeModule(userRole.toString());
                        break;
                    case 3:
                        if (userRole == UserRole.ADMIN || userRole == UserRole.DOCTOR) {
                            context.setModuleStrategy(new PharmacyStrategy());
                            context.executeModule(userRole.toString());
                        } else {
                            System.out.println("Access denied for non-doctor users.");
                        }
                        break;
                    default:
                        System.out.println("Enter Valid Option From (1, 2, or 3)");
                        break;
                }

                System.out.println("To exit, press 1");
                y = input.nextInt();
            } while (y != 1);
        } else {
            System.out.println("*** Incorrect credentials ***");
        }
    }
}
