package com.company;
import java.util.Scanner;

class Dep {
    Scanner input = new Scanner(System.in);

    public void Dep_Display() {
        int a, i = 0;  // ✅ Initialize 'i' to prevent compilation error
        Department DEP;

        do {
            System.out.println("Departments in our Hospital:");
            System.out.println("1. Cardiology  2. Neurology  3. Eye  4. Dental  5. ICU  6. Lab");
            System.out.print("See Details Of: ");
            a = input.nextInt();

            switch (a) {
                case 1:
                    DEP = new Cardialogy_Dep();
                    break;
                case 2:
                    DEP = new Neurology_Dep();
                    break;
                case 3:
                    DEP = new Eye_Dep();
                    break;
                case 4:
                    DEP = new Dentistry_Dep();
                    break;
                case 5:
                    DEP = new ICU_Dep();
                    break;
                case 6:
                    DEP = new Lab();
                    break;
                default:
                    System.out.println("Enter a valid option (1-6).");
                    continue;
            }

            DEP.showDepartmentDetails();

            // ✅ Ensure 'i' is initialized before checking in the while condition
            System.out.println("\nTo See Department info Again press 1, otherwise press any other key.");
            i = input.nextInt();
        } while (i == 1);
    }
}

// Abstract Department class with Template Method Pattern
public abstract class Department {
    public abstract void dep_info();
    public abstract void Services_available();
    
    // Hook method - Can be overridden if needed
    public void additionalInfo() {
        // Default implementation does nothing
    }

    // Template Method: Defines the standard execution flow
    public final void showDepartmentDetails() {
        dep_info();
        Services_available();
        additionalInfo();  // Hook method call
    }
}

// Cardiology Department
class Cardialogy_Dep extends Department {
    public void dep_info() {
        System.out.println("It deals with the treatment of heart and blood vessel disorders.");
    }
    public void Services_available() {
        System.out.println("Services available: Angiography, Heart Surgery, ECG, BP checkup.");
    }
    public void additionalInfo() {
        System.out.println("Equipped with 24/7 Emergency Heart Attack Response Team.");
    }
}

// Neurology Department
class Neurology_Dep extends Department {
    public void dep_info() {
        System.out.println("Deals with the study and treatment of nervous system disorders.");
    }
    public void Services_available() {
        System.out.println("Facilities available: MRI, CT scans, Ultrasound of major blood vessels.");
    }
}

// Dentistry Department
class Dentistry_Dep extends Department {
    public void dep_info() {
        System.out.println("Deals with the diagnosis and treatment of oral diseases.");
    }
    public void Services_available() {
        System.out.println("Treatments: Braces, Tooth Implant, Extraction, Filling, Scaling.");
    }
}

// Eye Department
class Eye_Dep extends Department {
    public void dep_info() {
        System.out.println("Ophthalmology deals with diagnosis and treatment of eye disorders.");
    }
    public void Services_available() {
        System.out.println("Tests: Eye Examination, OCT scans, Ultrasonography, Eye Surgery.");
    }
}

// ICU Department (Overrides Hook Method)
class ICU_Dep extends Department {
    public void dep_info() {
        System.out.println("Special department providing intensive care medicine.");
    }
    public void Services_available() {
        System.out.println("Includes critical operations: Ventilators, Renal support, and Cardiac support.");
    }
    public void additionalInfo() {
        System.out.println("Special Emergency Hotline: 911-ICU");
    }
}

// Lab Department
class Lab extends Department {
    public void dep_info() {
        System.out.println("Tests are carried out to diagnose and prevent diseases.");
    }
    public void Services_available() {
        System.out.println("Facilities: Blood Testing, Cholesterol Check, Liver Fat Testing, Blood Sugar Test.");
    }
}