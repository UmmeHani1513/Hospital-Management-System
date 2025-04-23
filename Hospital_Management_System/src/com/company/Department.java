package com.company;

import java.util.Scanner;

// Abstract class using Template Method pattern
public abstract class Department {
    // Template Method
    public final void showDepartmentDetails() {
        dep_info();
        Services_available();
        additionalInfo(); // Hook method
    }

    protected abstract void dep_info();
    protected abstract void Services_available();

    // Hook method - optional for subclasses
    protected void additionalInfo() {
        // Default implementation does nothing
    }
}

// Enum for department types
enum DepartmentType {
    CARDIOLOGY,
    NEUROLOGY,
    EYE,
    DENTAL,
    ICU,
    LAB
}

// Factory class to create department objects
class DepartmentFactory {
    public static Department getDepartment(DepartmentType type) {
        switch (type) {
            case CARDIOLOGY:
                return new Cardiology_Dep();
            case NEUROLOGY:
                return new Neurology_Dep();
            case EYE:
                return new Eye_Dep();
            case DENTAL:
                return new Dentistry_Dep();
            case ICU:
                return new ICU_Dep();
            case LAB:
                return new Lab();
            default:
                return null;
        }
    }
}

// UI class for department interaction
class Dep {
    Scanner input = new Scanner(System.in);

    public void Dep_Display() {
        int i;
        do {
            System.out.println("Departments in our Hospital are:");
            DepartmentType[] values = DepartmentType.values();
            for (int idx = 0; idx < values.length; idx++) {
                System.out.println((idx + 1) + ". " + capitalize(values[idx].name()));
            }

            System.out.print("See Details Of: ");
            int choice = input.nextInt();

            if (choice >= 1 && choice <= values.length) {
                DepartmentType selected = values[choice - 1];
                Department dep = DepartmentFactory.getDepartment(selected);
                dep.showDepartmentDetails(); // Using Template Method
            } else {
                System.out.println("Enter Valid Option From 1 to " + values.length);
            }

            System.out.print("To See Department info Again press 1: ");
            i = input.nextInt();
        } while (i == 1);
    }

    private String capitalize(String text) {
        return text.charAt(0) + text.substring(1).toLowerCase().replace('_', ' ');
    }
}

// Department Implementations

class Cardiology_Dep extends Department {
    @Override
    protected void dep_info() {
        System.out.println("It deals with the treatment of disorders of heart and blood vessels...");
    }

    @Override
    protected void Services_available() {
        System.out.println("Services: Angiography, Heart Surgery, CT of heart, ECG, BP checkup");
    }

    @Override
    protected void additionalInfo() {
        System.out.println("Specialized emergency services available 24/7.");
    }
}

class Neurology_Dep extends Department {
    @Override
    protected void dep_info() {
        System.out.println("Deals with disorders of the nervous system...");
    }

    @Override
    protected void Services_available() {
        System.out.println("Services: CAT scans, MRI, Ultrasound of major blood vessels");
    }
}

class Eye_Dep extends Department {
    @Override
    protected void dep_info() {
        System.out.println("Ophthalmology deals with eye disorders...");
    }

    @Override
    protected void Services_available() {
        System.out.println("Services: Eye examination, OCT, Eye surgery, etc.");
    }
}

class Dentistry_Dep extends Department {
    @Override
    protected void dep_info() {
        System.out.println("Diagnosis and treatment of oral diseases...");
    }

    @Override
    protected void Services_available() {
        System.out.println("Services: Braces, Tooth implant, Extraction, Filling, Scaling");
    }
}

class ICU_Dep extends Department {
    @Override
    protected void dep_info() {
        System.out.println("Specialized care for critically ill patients...");
    }

    @Override
    protected void Services_available() {
        System.out.println("Services: Ventilation, Dialysis, Cardiac support");
    }

    @Override
    protected void additionalInfo() {
        System.out.println("Advanced life-support equipment and continuous monitoring.");
    }
}

class Lab extends Department {
    @Override
    protected void dep_info() {
        System.out.println("Diagnostic testing for treatment and prevention...");
    }

    @Override
    protected void Services_available() {
        System.out.println("Services: Blood tests, Cholesterol, Liver fat, Blood sugar");
    }
}
