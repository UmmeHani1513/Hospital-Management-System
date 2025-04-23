package com.company;

import java.util.Scanner;

// Abstract class for Departments
public abstract class Department {
    public abstract void dep_info();
    public abstract void Services_available();
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

// Factory class using enum
class DepartmentFactory {
    public static Department getDepartment(DepartmentType type) {
        switch (type) {
            case CARDIOLOGY: return new Cardialogy_Dep();
            case NEUROLOGY: return new Neurology_Dep();
            case EYE: return new Eye_Dep();
            case DENTAL: return new Dentistry_Dep();
            case ICU: return new ICU_Dep();
            case LAB: return new Lab();
            default: return null;
        }
    }
}

// UI class that uses the factory and enum
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
                Department DEP = DepartmentFactory.getDepartment(selected);
                DEP.dep_info();
                DEP.Services_available();
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
class Cardialogy_Dep extends Department {
    public void dep_info() {
        System.out.println("It deals with the treatment of disorders of heart and blood vessels...");
    }

    public void Services_available() {
        System.out.println("Services: Angiography, Heart Surgery, CT of heart, ECG, BP checkup");
    }
}

class Neurology_Dep extends Department {
    public void dep_info() {
        System.out.println("Deals with disorders of the nervous system...");
    }

    public void Services_available() {
        System.out.println("Services: CAT scans, MRI, Ultrasound of major blood vessels");
    }
}

class Eye_Dep extends Department {
    public void dep_info() {
        System.out.println("Ophthalmology deals with eye disorders...");
    }

    public void Services_available() {
        System.out.println("Services: Eye examination, OCT, Eye surgery, etc.");
    }
}

class Dentistry_Dep extends Department {
    public void dep_info() {
        System.out.println("Diagnosis and treatment of oral diseases...");
    }

    public void Services_available() {
        System.out.println("Services: Braces, Tooth implant, Extraction, Filling, Scaling");
    }
}

class ICU_Dep extends Department {
    public void dep_info() {
        System.out.println("Specialized care for critically ill patients...");
    }

    public void Services_available() {
        System.out.println("Services: Ventilation, Dialysis, Cardiac support");
    }
}

class Lab extends Department {
    public void dep_info() {
        System.out.println("Diagnostic testing for treatment and prevention...");
    }

    public void Services_available() {
        System.out.println("Services: Blood tests, Cholesterol, Liver fat, Blood sugar");
    }
}
