package com.company;
import java.util.Scanner;

// Abstract class for Departments
public abstract class Department {
    public abstract void dep_info();
    public abstract void Services_available();
}

// Factory class
class DepartmentFactory {
    public static Department getDepartment(int choice) {
        switch (choice) {
            case 1: return new Cardialogy_Dep();
            case 2: return new Neurology_Dep();
            case 3: return new Eye_Dep();
            case 4: return new Dentistry_Dep();
            case 5: return new ICU_Dep();
            case 6: return new Lab();
            default: return null;
        }
    }
}

// UI Class that uses the factory
class Dep {
    Scanner input = new Scanner(System.in);

    public void Dep_Display() {
        int a, i;
        do {
            System.out.println("Departments in our Hospital are:");
            System.out.println("1. Cardiology\n2. Neurology\n3. Eye\n4. Dental\n5. ICU/CCU\n6. Lab");
            System.out.print("See Details Of: ");
            a = input.nextInt();

            Department DEP = DepartmentFactory.getDepartment(a);
            if (DEP != null) {
                DEP.dep_info();
                DEP.Services_available();
            } else {
                System.out.println("Enter Valid Option From (1,2,3,4,5,6)");
            }

            System.out.print("To See Department info Again press 1: ");
            i = input.nextInt();
        } while (i == 1);
    }
}

// Department Implementations
class Cardialogy_Dep extends Department {
    public void dep_info() {
        System.out.println("It deals with the treatment of Disorders of heart and blood vessels...");
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
